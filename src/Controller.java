import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Pane ring_1, ring_2, ring_3, icon_1, icon_2;
    @FXML private ImageView ring_4, ring_5;

    @FXML private ImageView backButton;

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

    @FXML
    private void settings_to_home(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
        Scene scene = Main.getHome();
        game_stage.setScene(scene);
        game_stage.show();
    }

    @FXML
    private void home_to_settings(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
        Scene scene = Main.loadSettings();
        game_stage.setScene(scene);
        game_stage.show();
    }
    @FXML
    private void home_to_produced_by(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
        Scene scene = Main.loadProducedBy();
        game_stage.setScene(scene);
        game_stage.show();
    }
    private void home_to_about(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
//        Scene scene = Main.load_about_game();
//        game_stage.setScene(scene);
        game_stage.show();
    }

    private void home_to_stats(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
//        Scene scene = Main.load_stats();
//        game_stage.setScene(scene);
        game_stage.show();
    }

    @FXML
    private void produced_to_home(MouseEvent me) throws Exception {
        Stage game_stage = (Stage) ((Node) me.getSource()).getScene().getWindow();
        game_stage.hide();
        Scene scene = Main.getHome();
        game_stage.setScene(scene);
        game_stage.show();
    }
}
