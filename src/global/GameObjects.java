package global;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class GameObjects {
    @FXML
    private Pane pane;
    private DoubleProperty posY;
    protected SuperController controller;

    public DoubleProperty getPosY() {
        return posY;
    }
    public Pane getPane() {
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
//        For adding border to each GameObject
//        pane.setStyle("-fx-border-color: white;");
    }

    protected void loadFXMLtoPane(String FXMLPath) {
        Pane temp = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPath));
            temp = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPane(temp);
    }
}
