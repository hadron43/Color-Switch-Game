package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DoubleCircleVerticalController extends SuperController {
    @FXML
    public Pane circle1, circle2;
    public Pane star1, star2;

    public DoubleCircleVerticalController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        boolean clockwise = (Math.random()*2 >= 1) ? true : false;
        addRotation(circle1, defaultRotatingDuration, clockwise);
        addRotation(circle2, defaultRotatingDuration, clockwise);
        loadStar(star1);
        loadStar(star2);
    }
}
