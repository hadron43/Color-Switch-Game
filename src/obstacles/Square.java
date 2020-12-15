package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.SquareController;

public class Square extends Obstacle {
    private SquareController squareController;

    public Square() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/square.fxml");

        squareController = (SquareController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
//        return 1 if ball collides with a part of different colour
        int result = 0;

        if ((Shape.intersect(squareController.yellow_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 && b.getColour() != 0) ||
                (Shape.intersect(squareController.pink_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 && b.getColour() != 1) ||
                (Shape.intersect(squareController.blue_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 && b.getColour() != 2) ||
                (Shape.intersect(squareController.purple_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() == -1 && b.getColour() != 3)){
            result = 1;
        }

        return result;
    }
}
