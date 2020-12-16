package elements.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class StarController extends SuperController {
    @FXML
    public Pane star;

    @FXML
    public Rectangle collisionRect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addScaling(star);
    }
}
