package interfaces;

import elements.Ball;
import javafx.geometry.Bounds;

public interface Collideable {
    Bounds getBounds();
    int hasCollided(Collideable c);
}
