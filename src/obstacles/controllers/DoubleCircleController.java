package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class DoubleCircleController extends SuperController {
    @FXML
    public Pane circle1, circle2;

    @FXML
    public Arc one_yellow_ring, one_blue_ring, one_pink_ring, one_purple_ring;

    @FXML
    public Arc two_yellow_ring, two_blue_ring, two_pink_ring, two_purple_ring;

    @FXML
    public Circle safe;
    @FXML
    public Pane star;

    public DoubleCircleController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circle1, defaultRotatingDuration, true);
        addRotation(circle2, defaultRotatingDuration, false);
    }
}
