package obstacles;

import elements.Ball;
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
        return 0;
    }
}
