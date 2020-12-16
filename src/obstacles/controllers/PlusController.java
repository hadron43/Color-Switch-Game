package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class PlusController extends SuperController {
    @FXML public Pane plus;
    @FXML public Rectangle blue_rect, pink_rect, yellow_rect, purple_rect;

    @FXML
    public Pane star;

    public PlusController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(plus);
    }
}
