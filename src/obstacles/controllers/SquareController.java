package obstacles.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SquareController extends SuperController {
    @FXML
    public Pane square;

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
