import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Pane ring_1, ring_2, ring_3, icon_1, icon_2;
    @FXML private ImageView ring_4, ring_5;

    @FXML
    private void handleFeedback() {
        System.out.println("Button was pressed");
        // Open feedback form
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final int items = 7;
        RotateTransition[] r = new RotateTransition[items];

        for(int i=0; i<items; ++i) {
            r[i] = new RotateTransition();
            r[i].setAxis(Rotate.Z_AXIS);
            r[i].setByAngle((Math.pow(-1, i))*360);
            r[i].setCycleCount(1000);
            r[i].setInterpolator(Interpolator.LINEAR);
            if(i<3)
                r[i].setDuration(Duration.millis(3000 - 250*i));
            else
                r[i].setDuration(Duration.millis(2500));
        }

        r[0].setNode(ring_1);
        r[1].setNode(ring_2);
        r[2].setNode(ring_3);
        r[3].setNode(ring_4);
        r[4].setNode(ring_5);
        r[5].setNode(icon_1);
        r[6].setNode(icon_2);

        for(int i=0; i<items; ++i)
            r[i].play();
    }
}
