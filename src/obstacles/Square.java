package obstacles;

import interfaces.Collidable;
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
    public int hasCollided(Collidable c) {
        return 0;
    }
}
