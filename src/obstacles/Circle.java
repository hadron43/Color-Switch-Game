package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.CircleController;

public class Circle extends Obstacle {
    private CircleController circleController;

    public Circle() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/circle.fxml");

        circleController = (CircleController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        // Returns :-
        // 0  -> not collided
        // -1 -> star earned
        // 1  -> collided
        int result = 0;
//        System.out.println("Brooks was here!");

        if(Shape.intersect(circleController.safe, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1) {
            // To be done: handle star collision

            if(b.getColour() != 0 && Shape.intersect(circleController.yellowRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                b.getColour() != 1 && Shape.intersect(circleController.pinkRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                b.getColour() != 2 && Shape.intersect(circleController.blueRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 ||
                b.getColour() != 3 && Shape.intersect(circleController.purpleRing, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1
            )
                result = 1;
        }

        return result;
    }
}
