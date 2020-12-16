import elements.Ball;
import elements.ColourSwitcher;
import global.GameObjects;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import obstacles.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements Serializable {
    private static final List<Class> map = Arrays.asList(
            DoubleCircleVertical.class
//            Circle.class, CircleFlow.class, DoubleCircle.class, Plus.class, Square.class, DoubleCircleVertical.class
//            Triangle.class
    );
    private final Ball ball;
    private final long id;
    private final Player player;

//    date and time when the game was last played
    private String date_time;
//     Includes Obstacles, ColourSwitcher's
    private final List<GameObjects> gameObjects;
//    Constants Required
    private static final double margin = 200, shift = 100, shiftDur = 30, width = 768, height = 1024, maxColorSwitcher = 2;
//     For storing the score
    int score;
//    For storing the list of all keyframes to be updated on a click
    private final List<DoubleProperty> objectsPosProperty;

//    It stores the number of colourSwitchers allowed to be loaded at a time on the screen
    private int colorSwitcherCount;

//     Controller With this Class
    private GameController gameController;
    @FXML
    private Pane obstaclesBox, root;

    public Game(Player player, Scene scene) {
        this.player = player;
        id = assignID();
        gameObjects = new ArrayList<>();
        objectsPosProperty = new ArrayList<>();
        score = 0;
        initialiseDateTime();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/game.fxml"));
            root = loader.load();
            scene.setRoot(root);
            Main.getInstance().scale(root);
            gameController = loader.getController();
            gameController.setGame(this);
            obstaclesBox = gameController.obstaclesBox;
        } catch (IOException e) {
            e.printStackTrace();
        }

        ball = new Ball();
        ball.attachToPane(root, (width/2-ball.getWidth()/2), height-margin);
        System.out.println(ball.getBounds());
        initializeGame();
    }

    private void attachGameObject(GameObjects ob) {
        double pos = height;
        if(gameObjects.size() != 0) {
            pos = gameObjects.get(gameObjects.size() - 1).getPosY().getValue();

            // To reduce gap in case of Colour Switchers
            if(gameObjects.get(gameObjects.size() - 1) instanceof ColourSwitcher || ob instanceof ColourSwitcher)
                pos += margin/2;

            // To add some offset
            // ColourSwitcher loads faster than Obstacle, and have less excess gap due to latency
            if(ob instanceof ColourSwitcher)
                pos -= margin/5;
        }
        pos -= margin + ob.getHeight();

        ob.attachToPane(obstaclesBox, (width-ob.getWidth())/2, pos);
        gameObjects.add(ob);
        objectsPosProperty.add(ob.getPosY());
    }

    private void newObstacle() {
        try {
            Class obsType = null;
            // No two consecutive Obstacles Should be Same
            while(obsType == null || (gameObjects.size() != 0 && obsType == gameObjects.get(gameObjects.size()-1).getClass())){
                obsType = map.get((int)(Math.random()*map.size()));
                if(map.size() == 1)
                    break;
            }
            Obstacle ob = (Obstacle) (obsType.getDeclaredConstructor().newInstance());
            attachGameObject(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void newColorSwitcher() {
        ColourSwitcher cs = new ColourSwitcher();
        attachGameObject(cs);
        colorSwitcherCount++;
    }

    private void initializeGame() {
        double pos = 1024 - margin;
        double x = 768;
        for(int i=0; i<3; ++i){
            newObstacle();
        }

        Thread collisionThread = new Thread(new collisionThread(), "Collision Thread");
        collisionThread.start();
    }

    public void shiftObstacles() {
        double shiftExcess = Math.min(shift, ball.getBallController().moveUp());
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setRate(0.1);
        for(DoubleProperty property : objectsPosProperty) {
            KeyValue keyValue = new KeyValue(property, property.getValue() + shiftExcess);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(shiftDur), keyValue));
        }
        timeline.play();
        // Generate new obstacle if running out of obstacles to display
        updateGameObjects();
    }

    private long assignID() {
        String strFilePath = "./data/gameId";
        long input = 1;
        try {
            FileInputStream fin = new FileInputStream(strFilePath);
            DataInputStream din = new DataInputStream(fin);
            input = din.readLong();
            din.close();
        } catch(IOException fe) {
            System.out.println(fe.toString());
        } finally {
            FileOutputStream fout;
            try {
                fout = new FileOutputStream(strFilePath, false);
                DataOutputStream dout = new DataOutputStream(fout);
                dout.writeLong(input+1);
                dout.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return input;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    private void updateGameObjects() {
        if(objectsPosProperty == null || objectsPosProperty.size() == 0)
            return;
        if(objectsPosProperty.get(objectsPosProperty.size()-1).getValue() > -height) {
            newObstacle();
            if(colorSwitcherCount < maxColorSwitcher && Math.random()*3 > 2)
                newColorSwitcher();
        }
        while(objectsPosProperty.size() > 0 && objectsPosProperty.get(0).getValue() > height) {
            if(gameObjects.get(0) instanceof ColourSwitcher)
                colorSwitcherCount--;
            objectsPosProperty.remove(0);
            gameObjects.remove(0);
        }
    }

    public void setDateTime(String date_time) {
        this.date_time = date_time;
    }

    private void initialiseDateTime(){
        DateTimeFormatter dt_format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dt = dt_format.format(now);
        setDateTime(dt);
    }

    class collisionThread implements Runnable {
        @Override
        public void run() {
            long counter = 0;
            for (int i=0; ;++i) {
                if(i == -1) {
                    System.out.println("Invalid State! i is -1!");
                }
                try {
                    if(!(gameObjects.get(i) instanceof Obstacle))
                        continue;
                    Obstacle go = (Obstacle) gameObjects.get(i);
//                    if (go.getPosY().getValue() - ball.getPosY().getValue() < -700)
//                        throw new Exception("Reached too far!");

                    int col = go.hasCollided(ball);
                    if(col == 1)
                        System.out.println("collision detected! " + counter);
                }
                catch(Exception e) {

                    i = -1;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        }
    }
}