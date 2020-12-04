package elements.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import global.SuperController;

import java.net.URL;
import java.util.ResourceBundle;

public class ColourSwitcherController extends SuperController implements Initializable {
    @FXML public Pane colourSwitcher;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addRotation(colourSwitcher, 3000, true);
    }
}
