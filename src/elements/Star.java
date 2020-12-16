package elements;

import elements.controllers.StarController;
import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;

public class Star extends GameObjects implements Collideable {
    private final StarController starController;
    private boolean active;
    public Star() {
        loadFXMLtoPane("/elements/fxml/star.fxml");
        starController = (StarController) controller;
        active = true;
    }

    @Override
    public Bounds getBounds() {
        return null;
    }

    @Override
    public int hasCollided(Ball b) {
        int result = 0;
        if(!active)
            return result;

        // return 1 if collision is detected
        if (Shape.intersect(starController.collisionRect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1){
            result = 1;
            active = false;
            getPane().setOpacity(0);
        }
        return result;
    }
}
