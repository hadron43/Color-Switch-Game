package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CircleFlowController extends SuperController {
    @FXML
    public Pane circleFlow;

    public CircleFlowController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circleFlow);
        loadStar();
    }
}
