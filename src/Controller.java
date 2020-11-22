import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Pane ring_1, ring_2, ring_3, icon_1, produced_btn, box;
    @FXML private ImageView ring_4, ring_5;

    @FXML private ImageView backButton;
    @FXML private Text high_score, total_stars;

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
            r[i].setCycleCount(Animation.INDEFINITE);
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
        r[6].setNode(produced_btn);

        for(int i=0; i<items; ++i)
            r[i].play();

//        For loading sample obstacles for testing purposes
        if(box != null) {
            Pane newPane;
            try {
                newPane = FXMLLoader.load(getClass().getResource("/obstacles/circleFlow.fxml"));
                List<Node> parentChildren = ((Pane) box.getParent()).getChildren();
                parentChildren.set(parentChildren.indexOf(box), newPane);
                box = newPane;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void loadSettings(MouseEvent me) throws Exception {
        Main.loadSettings();
    }
    @FXML
    private void loadProducedBy(MouseEvent me) throws Exception {
        Main.loadProducedBy();
    }
    @FXML
    private void loadAbout(MouseEvent me) throws Exception {
        Main.loadAboutGame();
    }

    @FXML
    private void loadStats(MouseEvent me) throws Exception {
        Main.loadStats();
    }

    @FXML
    private void backToHome(MouseEvent me) throws Exception {
        Main.loadHome();
    }
}
