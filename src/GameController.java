import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    Pane obstaclesBox;
    @FXML
    Text score;

    @FXML
    private void loadGameOver(MouseEvent me) throws Exception {
        Main.loadGameOver();
    }

    public void setScore(int _score) {
        score.setText(_score+"");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
