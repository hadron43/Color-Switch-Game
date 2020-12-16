package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.PlusController;

public class Plus extends Obstacle {
    private PlusController plusController;

    public Plus() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/plus.fxml");

        plusController = (PlusController) controller;
        loadStar(plusController.star);
    }

    @Override
    public int hasCollided(Ball b) {
//        return 1 if ball collides with a part of different colour
        int result = 0;

        if ((Shape.intersect(plusController.yellow_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 0) ||
                (Shape.intersect(plusController.pink_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 1) ||
                (Shape.intersect(plusController.blue_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 2) ||
                (Shape.intersect(plusController.purple_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1 && b.getColour() != 3)){
            result = 1;
        }

        if(result == 0) {
            result = hasCollidedWithStar(b);
        }

        return result;
    }
}
