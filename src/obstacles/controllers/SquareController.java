package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class SquareController extends SuperController {
    @FXML
    public Pane square;
    @FXML public Rectangle blue_rect, pink_rect, yellow_rect, purple_rect;

    public SquareController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(square);
        loadStar();
    }
}
