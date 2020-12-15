package obstacles;

import elements.Ball;
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

    @Override
    public int hasCollided(Ball b) {
        if(getPane() == null || b == null || b.getBounds() == null)
            return -1;
        return (getBounds().intersects(b.getBounds())) ? 1 : 0;
    }
}
