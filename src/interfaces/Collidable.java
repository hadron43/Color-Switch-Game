package interfaces;

import javafx.geometry.Bounds;

public interface Collidable {
    Bounds getBounds();
    int hasCollided(Collidable c);
}
