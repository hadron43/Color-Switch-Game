package global;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class GameObjects {
    @FXML
    protected Pane pane;
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
        return pane.getWidth();
    }

    public double getHeight() {
        if(pane == null)
            return 0;
        return pane.getHeight();
    }

    // Attach itself to a particular Parent Node
    // To be modified later
    public void attachToGrid(GridPane parent, int i, int j) {
        parent.setAlignment(Pos.CENTER);
        parent.add(pane, i, j);
    }

    public void attachToPane(Pane parent, int i, int j) {
        pane.setLayoutX(i);
        pane.setLayoutY(j);
        parent.getChildren().add(pane);
    }
}
