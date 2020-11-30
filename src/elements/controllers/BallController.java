package elements.controllers;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BallController implements Initializable {

    @FXML
    public Pane ball;
    @FXML
    public Circle circle_ball;
    public static int defaultRotatingDuration = 4000;

    public BallController() { }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(ball);
    }

    public void addRotation(Node node) {
        addRotatingNode(node, defaultRotatingDuration, true);
    }

    private void addRotatingNode(Node node, int timeInMillis, boolean clockwise) {
        RotateTransition rt = new RotateTransition();
        rt.setAxis(Rotate.Z_AXIS);
        rt.setByAngle((clockwise) ? 360 : -360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setDuration(Duration.millis(timeInMillis));
        rt.setNode(node);
        rt.play();
    }
}
