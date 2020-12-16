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

    @FXML Text game_over_score, game_over_highscore;

    private Game game;

    @FXML
    private void loadGameOver(MouseEvent me) throws Exception {
        Main.getInstance().loadGameOver();
    }

    @FXML
    private void backToHome(MouseEvent me) throws Exception {
        Main.getInstance().loadHome();
    }

    public void setGameOverScores(int score, int highscore){
        game_over_score.setText(score + "");
        game_over_highscore.setText(highscore + "");
    }


    public void setScore(int _score) {
        score.setText(_score+"");
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        game.shiftObstacles();
    }
}
