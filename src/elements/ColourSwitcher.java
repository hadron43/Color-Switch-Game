package elements;

import elements.controllers.ColourSwitcherController;
import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;

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
        if(getPane() == null || b == null || b.getBounds() == null)
            return -1;
        return (getBounds().intersects(b.getBounds())) ? 1 : 0;
    }

    public void changeBallColour(Ball b){
        b.setColour();
    }
}
