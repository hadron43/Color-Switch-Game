package obstacles;

import interfaces.Collideable;
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
    public int hasCollided(Collideable c) {
        return 0;
    }
}
