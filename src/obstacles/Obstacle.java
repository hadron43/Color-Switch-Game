package obstacles;

import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;

public abstract class Obstacle extends GameObjects implements Collideable {
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
        if(getPane() == null)
            return null;
        return getPane().getBoundsInLocal();
    }
}
