package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class TriangleController extends SuperController {
    @FXML
    public Pane triangle;

    @FXML
    public Pane star;

    public TriangleController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(triangle);
    }
}
