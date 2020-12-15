package obstacles;

import elements.Ball;
import obstacles.controllers.CircleController;

public class Circle extends Obstacle {
    private CircleController circleController;

    public Circle() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/circle.fxml");

        circleController = (CircleController) controller;
    }

    @Override
    public int hasCollided(Ball b) {
        // Returns :-
        // 0  -> not collided
        // -1 -> star earned
        // 1  -> collided
        int result = 0;
        System.out.println("Brooks was here!");

        if(getBounds().intersects(b.getBounds())) {
            if(!circleController.safe.intersects(b.getBounds())) {
                // To be done: handle star collision

                if(b.getColour() == 0 && circleController.yellowRing.intersects(b.getBounds()) ||
                    b.getColour() == 1 && circleController.pinkRing.intersects(b.getBounds()) ||
                    b.getColour() == 2 && circleController.blueRing.intersects(b.getBounds()) ||
                    b.getColour() == 3 && circleController.purpleRing.intersects(b.getBounds())
                )
                    result = 1;
            }
        }

        if(result == 1)
            System.out.println(result);

        return result;
    }
}
