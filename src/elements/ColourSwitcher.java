package elements;

import interfaces.Collideable;
import javafx.geometry.Bounds;

public class ColourSwitcher implements Collideable {
    @Override
    public Bounds getBounds() {
        return null;
    }

    @Override
    public int hasCollided(Ball b) {
        return 0;
    }
}
