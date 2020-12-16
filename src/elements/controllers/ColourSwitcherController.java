package elements.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import global.SuperController;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class ColourSwitcherController extends SuperController implements Initializable {
    @FXML public Pane colourSwitcher;
    @FXML public Rectangle colour_switch_rect;
    @FXML public Arc yellow_arc, pink_arc, blue_arc, purple_arc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRotation(colourSwitcher, 3000, true);
    }
}
