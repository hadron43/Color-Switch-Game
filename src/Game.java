import elements.Ball;
import global.GameObjects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import obstacles.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements Serializable {
    private static List<Class> map = Arrays.asList(
            Circle.class, CircleFlow.class, DoubleCircle.class, Plus.class, Square.class
    );
    private final Ball ball;
    private final long id;
    private final Player player;
//     Includes Obstacles, ColourSwitcher's
    private final List<GameObjects> gameObjects;
//     For storing the score
    int score;
    @FXML
    Pane obstaclesBox;
//     Controller With this Class
    private GameController gameController;

    public Game(Player player, Scene scene) {
        this.player = player;
        id = assignID();
        gameObjects = new ArrayList<>();
        ball = new Ball();
        score = 0;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/game.fxml"));
            Pane root = loader.load();
            scene.setRoot(root);
            gameController = loader.getController();
            obstaclesBox = gameController.obstaclesBox;
        } catch (IOException e) {
            e.printStackTrace();
        }

        initializeGame();
    }

    private void initializeGame() {
        int pos = 1024;
        int x = 250;
        for(int i=0; i<3; ++i){
            Obstacle ob = null;
            try {
                ob = (Obstacle) (map.get((int)(Math.random()*map.size()))).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(ob == null)
                continue;
            ob.attachToPane(obstaclesBox, x,pos);
            gameObjects.add(ob);
            pos -= ob.getHeight();
            System.out.println(ob.getHeight() + ", pos: "+ pos);
        }
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
}