package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.DoubleCircleVerticalController;

public class DoubleCircleVertical extends Obstacle {
    private DoubleCircleVerticalController doubleCircleVerticalController;

    public DoubleCircleVertical() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/doubleCircleVertical.fxml");

        doubleCircleVerticalController = (DoubleCircleVerticalController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
//        return 1 if ball collides with a part of different colour
        int result = 0;

        if(Shape.intersect(doubleCircleVerticalController.safe_1, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 &&
                Shape.intersect(doubleCircleVerticalController.safe_2, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1) {

            if ((Shape.intersect(doubleCircleVerticalController.one_yellow_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 0) ||
                    (Shape.intersect(doubleCircleVerticalController.one_pink_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 1) ||
                    (Shape.intersect(doubleCircleVerticalController.one_blue_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 2) ||
                    (Shape.intersect(doubleCircleVerticalController.one_purple_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 3) ||

                    (Shape.intersect(doubleCircleVerticalController.two_yellow_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 0) ||
                    (Shape.intersect(doubleCircleVerticalController.two_pink_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 1) ||
                    (Shape.intersect(doubleCircleVerticalController.two_blue_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 2) ||
                    (Shape.intersect(doubleCircleVerticalController.two_purple_ring, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 3)) {

                result = 1;
            }
        }

        return result;
    }
}
