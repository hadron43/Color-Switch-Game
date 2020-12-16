package elements;

import elements.controllers.BallController;
import global.GameObjects;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Ball extends GameObjects {

    private BallController ballController;
    private int colour;
    private double speed;

    public Ball () {
        loadFXMLtoPane("/elements/fxml/ball.fxml");
        ballController = (BallController) controller;
        setColour();
    }

    public Bounds getBounds() {
        if(ballController == null || ballController.circle_ball == null)
            return null;
        return ballController.circle_ball.getBoundsInLocal();
    }

    public int getColour(){
        return colour;
    }

    public void setColour(){
        Random rand = new Random();
        colour = rand.nextInt(4);
        while(!ballController.circle_ball.getStyleClass().isEmpty())
            ballController.circle_ball.getStyleClass().remove(0);
        switch(colour) {
            case 0:
                // yellow
                ballController.circle_ball.getStyleClass().add("fill-yellow");
                break;
            case 1:
                // pink
                ballController.circle_ball.getStyleClass().add("fill-pink");
                break;
            case 2:
                // blue
                ballController.circle_ball.getStyleClass().add("fill-blue");
                break;
            case 3:
                // purple
                ballController.circle_ball.getStyleClass().add("fill-purple");
                break;
            default:
                break;
        }
    }

    public BallController getBallController() {
        return ballController;
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed(int speed_level){
        speed *= speed_level;
    }

    @Override
    public void attachToPane(Pane node, double i, double j) {
        super.attachToPane(node, i, j);
        ballController.welcome();
    }
}
