package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CircleController extends SuperController {
    @FXML
    public Pane circle;

    public CircleController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circle);
        loadStar();
    }
}
