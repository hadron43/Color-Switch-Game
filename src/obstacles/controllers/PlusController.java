package obstacles.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlusController extends SuperController {
    @FXML
    public Pane plus;

    public PlusController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(plus);
        loadStar();
    }
}
