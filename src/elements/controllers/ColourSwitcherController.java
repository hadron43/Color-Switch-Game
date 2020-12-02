package elements.controllers;

import javafx.animation.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class ColourSwitcherController implements Initializable {
    @FXML public Pane colourSwitcher;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotateCS = new RotateTransition();
        rotateCS.setAxis((Rotate.Z_AXIS));
        rotateCS.setByAngle(360);
        rotateCS.setCycleCount(Animation.INDEFINITE);
        rotateCS.setInterpolator(Interpolator.LINEAR);
        rotateCS.setDuration(Duration.millis(3000));
        rotateCS.setNode(colourSwitcher);
    }
}
