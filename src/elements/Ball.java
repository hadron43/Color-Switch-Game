package elements;

import elements.controllers.BallController;
import javafx.geometry.Bounds;

import java.util.Random;

public class Ball {

    private BallController ballController;
    private int colour;
    private double speed;

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
}
