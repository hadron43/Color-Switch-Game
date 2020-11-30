package obstacles;

import interfaces.Collideable;
import obstacles.controllers.CircleController;

public class Circle extends Obstacle {
    private CircleController circleController;

    Circle(double posY) {
        super(posY);

        // Load the FXML and set 'pane' in Parent
        loadObstaclePane("/obstacles/fxml/circle.fxml");

        circleController = (CircleController) controller;
    }

    @Override
    public int hasCollided(Collideable c) {
        return 0;
    }
}
