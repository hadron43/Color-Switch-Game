package global;

import elements.Ball;
import javafx.geometry.Bounds;

public interface Collideable {
    Bounds getBounds();
    int hasCollided(Ball b);
}
