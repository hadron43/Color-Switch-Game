package obstacles;

import elements.Ball;
import elements.Star;
import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Obstacle extends GameObjects implements Collideable {
    // We will center the pane
    // Movement open only in Y axis

    // It will have a star if required
    // Stores Null if No Star is present inside the Obstacle
    private ArrayList<Star> stars;

    public Obstacle() {
        stars = new ArrayList<>();
    }

    // Getters and Setters

    // To be verified, which type of bound is required
    @Override
    public Bounds getBounds() {
        if(getPane() == null)
            return null;
        return getPane().getBoundsInLocal();
    }

    public int hasCollidedWithStar(Ball b) {
        // Returns 1 if it has collided with the star
        int res = 0;
        for(Star s: stars) {
            if(s.hasCollided(b) == 1) {
                res = -1;
                break;
            }
        }
        return res;
    }

    protected void loadStar(Pane customPane) {
        if(customPane != null) {
            Star s = new Star();
            s.attachToPane(customPane, 0, 0);
            stars.add(s);
        }
    }
}
