package obstacles;

import interfaces.Collideable;
import obstacles.controllers.PlusController;

public class Plus extends Obstacle {
    private PlusController plusController;

    Plus(double posY) {
        super(posY);

        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/plus.fxml");

        plusController = (PlusController) controller;
    }

    @Override
    public int hasCollided(Collideable c) {
        return 0;
    }
}
