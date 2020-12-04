package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DoubleCircleController extends SuperController {
    @FXML
    public Pane circle1, circle2;

    public DoubleCircleController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circle1, defaultRotatingDuration, true);
        addRotation(circle2, defaultRotatingDuration, false);
        loadStar();
    }
}
