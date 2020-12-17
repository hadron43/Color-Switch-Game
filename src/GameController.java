import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable, Serializable {
    @FXML
    Pane obstaclesBox, overlay;

    @FXML
    BorderPane paused, resurrect;

    @FXML
    Text score, resurrectCount;

    @FXML Text game_over_score, game_over_highscore;

    private Game game;

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
    private boolean resurrectSuccess;

    public void pause() {
        System.out.println("Game was paused!");
        paused.setVisible(true);
        overlay.setVisible(true);
    }

    public void toggleResurrectSuccess() {
        resurrectSuccess = !resurrectSuccess;
    }

    public boolean displayResurrect() {
        resurrectSuccess = false;
        resurrect.setVisible(true);
        overlay.setVisible(true);

        System.out.println("Hello World, resurecting");

        for(int i=5; i>=0; --i) {
            if(resurrectSuccess)
                break;

            resurrectCount.setText(i+"");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resurrect.setVisible(false);
        overlay.setVisible(false);
        return resurrectSuccess;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        game.shiftObstacles();
    }

    public void backToHome() throws Exception {
        Main.getInstance().loadHome();
    }

    public void resume() throws Exception {
        overlay.setVisible(false);
        paused.setVisible(false);
    }

    public void keyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode == KeyCode.SPACE){
            game.shiftObstacles();
        }
    }
}
