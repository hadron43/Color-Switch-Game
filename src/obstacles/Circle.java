package obstacles;

import elements.Ball;
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
    public int hasCollided(Ball b) {
        return 0;
    }
}
