package elements;

import elements.controllers.BallController;
import elements.controllers.ColourSwitcherController;
import global.GameObjects;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

public class Ball extends GameObjects {

    private BallController ballController;
    private int colour;
    private double speed;

    public Ball () {
        loadFXMLtoPane("/elements/fxml/ball.fxml");
        setColour();
    }

    public Bounds getBounds() {
        if(ballController == null || ballController.circle_ball == null)
            return null;
        return ballController.circle_ball.getBoundsInParent();
    }

    public int getColour(){
        return colour;
    }

    public void setColour(){
        Random rand = new Random();
        colour = rand.nextInt(4);
        switch(colour){
            case 0:
                // yellow
                ballController.circle_ball.setStyle("fill-yellow");
                break;
            case 1:
                // pink
                ballController.circle_ball.setStyle("fill-pink");
                break;
            case 2:
                // blue
                ballController.circle_ball.setStyle("fill-blue");
                break;
            case 3:
                // purple
                ballController.circle_ball.setStyle("fill-purple");
                break;
            default:
                break;
        }
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed(int speed_level){
        speed *= speed_level;
    }

    public void loadBallPane(String FXMLPath) {
        Pane temp = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPath));
            temp = loader.load();
            ballController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPane(temp);
    }
}
