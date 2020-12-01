package obstacles;

import elements.Ball;
import obstacles.controllers.PlusController;

public class Plus extends Obstacle {
    private PlusController plusController;

    Plus() {
        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/plus.fxml");

        plusController = (PlusController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        return 0;
    }
}
