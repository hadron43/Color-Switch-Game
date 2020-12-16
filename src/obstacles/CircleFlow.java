package obstacles;

import elements.Ball;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import obstacles.controllers.CircleFlowController;

public class CircleFlow extends Obstacle{
    private CircleFlowController circleFlowController;

    public CircleFlow() {

        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/circleFlow.fxml");

        circleFlowController = (CircleFlowController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        
        int result = 0;
        
        if (check_intersection(b, circleFlowController.yellow_balls, 0) ||
                check_intersection(b, circleFlowController.pink_balls, 1) ||
                check_intersection(b, circleFlowController.blue_balls, 2) ||
                check_intersection(b, circleFlowController.purple_balls, 3)){
            result = 1;
        }

        return result;
    }
    
    private boolean check_intersection(Ball b, Circle array[], int colour){
        boolean check = false;
        for (Circle circle: array){
            if (Shape.intersect(circle, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 
                    && b.getColour() != colour){
                check = true;
                break;
            }
        }
        return check;
    }
}
