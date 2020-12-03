package global;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class GameObjects {
    @FXML
    private Pane pane;
    private DoubleProperty posY;

    public DoubleProperty getPosY() {
        return posY;
    }
    protected Pane getPane() {
        return pane;
    }
    protected void setPane(Pane pane) {
        this.pane = pane;
        this.posY = pane.layoutYProperty();
    }

    public double getWidth() {
        if(pane == null)
            return 0;
        // Use only maxWidth Property in fxml objects associated with game objects
        return pane.getMaxWidth();
    }

    public double getHeight() {
        if(pane == null) {
            System.out.println("Null Pointer!");
            return 0;
        }

        // As I've set max height property to fxml objects,
        // This means, set max height property to all game objects
        return pane.getMaxHeight();
    }

    // Attach itself to a particular Parent Node
    // To be modified later
    public void attachToGrid(GridPane parent, int i, int j) {
        parent.setAlignment(Pos.CENTER);
        parent.add(pane, i, j);
    }

    public void attachToPane(Pane node, double i, double j) {
        node.getChildren().add(pane);
        pane.setLayoutX(i);
        pane.setLayoutY(j);
        pane.setStyle("-fx-border-color: white;");
    }
}
