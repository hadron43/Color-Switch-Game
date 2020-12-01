package obstacles;

import elements.Ball;
import global.Collideable;
import global.GameObjects;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import obstacles.controllers.SuperController;

import java.io.IOException;

abstract class Obstacle extends GameObjects implements Collideable {
    protected SuperController controller;
    // We will center the pane
    // Movement open only in Y axis

    public Obstacle() {

    }

    // It will have a star if required
    // Stores Null if No Star is present inside the Obstacle
//    private Star star;

    // Getters and Setters

    // To be verified, which type of bound is required
    @Override
    public Bounds getBounds() {
        if(pane == null)
            return null;
        return pane.getBoundsInParent();
    }

    @Override
    public int hasCollided(Ball b) {
        if(pane == null || b == null || b.getBounds() == null)
            return -1;
        return (getBounds().intersects(b.getBounds())) ? 1 : 0;
    }

    // Helper Functions

    protected void loadObstaclePane(String FXMLPath) {
        Pane temp = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPath));
            temp = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane = temp;
        setPane(temp);
    }
}
