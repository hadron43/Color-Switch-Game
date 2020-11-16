import javafx.animation.Interpolator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.animation.RotateTransition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button feedbackButton;
    @FXML private Pane ring_1, ring_2, ring_3;

    @FXML
    private void handleFeedback() {
        System.out.println("Button was pressed");
        // Open feedback form
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition[] r = new RotateTransition[3];

        for(int i=0; i<3; ++i) {
            r[i] = new RotateTransition();
            r[i].setAxis(Rotate.Z_AXIS);
            r[i].setByAngle((Math.pow(-1, i))*360);
            r[i].setCycleCount(1000);
            r[i].setInterpolator(Interpolator.LINEAR);
            r[i].setDuration(Duration.millis(2200 - 250*i));
        }

        r[0].setNode(ring_1);
        r[1].setNode(ring_2);
        r[2].setNode(ring_3);
        for(int i=0; i<3; ++i)
            r[i].play();
    }
}
