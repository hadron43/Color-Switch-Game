package obstacles;

import elements.Ball;
import obstacles.controllers.DoubleCircleVerticalController;

public class DoubleCircleVertical extends Obstacle {
    private DoubleCircleVerticalController doubleCircleVerticalController;

    public DoubleCircleVertical() {
        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/doubleCircleVertical.fxml");

        doubleCircleVerticalController = (DoubleCircleVerticalController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        return 0;
    }
}
