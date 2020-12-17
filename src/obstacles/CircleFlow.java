package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.CircleController;

public class CircleFlow extends Obstacle{
    private CircleController circleFlowController;

    public CircleFlow() {

        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/circleFlow.fxml");

        circleFlowController = (CircleController) controller;
        loadStar(circleFlowController.star);
    }

    @Override
    public int hasCollided(Ball b) {
        // Returns :-
        // 0  -> not collided
        // -1 -> star earned
        // 1  -> collided
        int result = 0;
//        System.out.println("Brooks was here!");

        if(Shape.intersect(circleFlowController.safe, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1) {
            // To be done: handle star collision

            if(b.getColour() != 0 && Shape.intersect(circleFlowController.yellowRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                    b.getColour() != 1 && Shape.intersect(circleFlowController.pinkRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                    b.getColour() != 2 && Shape.intersect(circleFlowController.blueRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                    b.getColour() != 3 && Shape.intersect(circleFlowController.purpleRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1
            )
                result = 1;
        }

        if(result == 0) {
            result = hasCollidedWithStar(b);
        }

        return result;
    }
}
