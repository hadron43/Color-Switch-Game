package obstacles;

import elements.Ball;
import obstacles.controllers.SquareController;

public class Square extends Obstacle {
    private SquareController squareController;

    Square(double posY) {
        super(posY);

        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/square.fxml");

        squareController = (SquareController) controller;
    }

    @Override
    public int hasCollided(Ball c) {
        return 0;
    }
}
