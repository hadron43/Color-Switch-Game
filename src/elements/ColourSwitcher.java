package elements;

import global.Collideable;
import global.GameObjects;
import javafx.geometry.Bounds;

public class ColourSwitcher extends GameObjects implements Collideable {
    @Override
    public Bounds getBounds() {
        return null;
    }

    @Override
    public int hasCollided(Ball b) {
        return 0;
    }
}
