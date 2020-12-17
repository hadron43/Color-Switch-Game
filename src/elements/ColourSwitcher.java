package elements;

import elements.controllers.ColourSwitcherController;
import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;

public class ColourSwitcher extends GameObjects implements Collideable {
    private ColourSwitcherController colourSwitcherController;

    public ColourSwitcher() {
        loadFXMLtoPane("/elements/fxml/colourSwitcher.fxml");
        colourSwitcherController = (ColourSwitcherController) controller;
    }

    @Override
    public Bounds getBounds() {
        if(getPane() == null)
            return null;
        return getPane().getBoundsInParent();
    }

    @Override
    public int hasCollided(Ball b) {
        int result = 0;

        // return 2 if collision is detected
        if (colourSwitcherController.colourSwitcher.isVisible() && Shape.intersect(colourSwitcherController.colour_switch_rect, b.getBallController().circle_ball).getBoundsInLocal().getWidth() != -1){
            result = 2;
            changeBallColour(b);
            colourSwitcherController.colourSwitcher.setVisible(false);
        }
        return result;
    }

    public void changeBallColour(Ball b){
        b.setColour();
    }
}
