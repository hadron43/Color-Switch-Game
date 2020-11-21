package obstacles;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ObstaclesController implements Initializable {
    static int defaultRotatingDuration = 4000;

    ArrayList<RotateTransition> rotatingElements;
    @FXML
    Pane circle, circleFlow;

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

    private void addRotatingNode(Node node) {
        addRotatingNode(node, defaultRotatingDuration, true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rotatingElements = new ArrayList<>();
        addRotatingNode(circle);
        addRotatingNode(circleFlow);
    }
}
