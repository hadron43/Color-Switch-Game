package obstacles;

import elements.Ball;
import obstacles.controllers.CircleFlowController;

public class CircleFlow extends Obstacle{
    private CircleFlowController circleFlowController;

    public CircleFlow() {

        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/circleFlow.fxml");

        circleFlowController = (CircleFlowController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        return 0;
    }
}
