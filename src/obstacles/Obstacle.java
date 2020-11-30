package obstacles;

import interfaces.Collidable;
import javafx.geometry.Bounds;

public abstract class Obstacle implements Collidable {
    private double posX, posY;

    // Stores the width of the parent Container
    private double width, height;

//    It will have a star if required
//    Stores Null if No Star is present inside the Obstacle
//    private Star star;

    // Getters and Setters

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setPos(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public abstract Bounds getBounds();
    @Override
    public abstract int hasCollided(Collidable c);
}
