package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.DoubleCircleController;

public class DoubleCircle extends Obstacle {
    private DoubleCircleController doubleCircleController;

    public DoubleCircle() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/doubleCircle.fxml");

        doubleCircleController = (DoubleCircleController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
//        return 1 if ball collides with a part of different colour
        int result = 0;

        if(Shape.intersect(doubleCircleController.safe, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1) {

            if ((Shape.intersect(doubleCircleController.one_yellow_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 0) ||
                    (Shape.intersect(doubleCircleController.one_pink_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 1) ||
                    (Shape.intersect(doubleCircleController.one_blue_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 2) ||
                    (Shape.intersect(doubleCircleController.one_purple_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 3) ||

                    (Shape.intersect(doubleCircleController.two_yellow_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 0) ||
                    (Shape.intersect(doubleCircleController.two_pink_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 1) ||
                    (Shape.intersect(doubleCircleController.two_blue_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 2) ||
                    (Shape.intersect(doubleCircleController.two_purple_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 3)) {

                result = 1;
            }
        }

        return result;
    }
}
