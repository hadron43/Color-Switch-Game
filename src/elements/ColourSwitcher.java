package elements;

import elements.controllers.ColourSwitcherController;
import global.Collideable;
import global.GameObjects;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ColourSwitcher extends GameObjects implements Collideable {
    private ColourSwitcherController colourSwitcherController;

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

    protected void loadColourSwitcherPane(String FXMLPath) {
        Pane temp;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPath));
            temp = loader.load();
            setPane(temp);
            colourSwitcherController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
