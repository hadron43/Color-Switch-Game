package obstacles;

import interfaces.Collideable;
import obstacles.controllers.DoubleCircleController;

public class DoubleCircle extends Obstacle {
    private DoubleCircleController doubleCircleController;

    DoubleCircle(double posY) {
        super(posY);

        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/doubleCircle.fxml");

        doubleCircleController = (DoubleCircleController) controller;
    }

    @Override
    public int hasCollided(Collideable c) {
        return 0;
    }
}
