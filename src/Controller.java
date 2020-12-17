import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.swing.text.TabableView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ImageView ring_4, ring_5;
    @FXML private Pane ring_1, ring_2, ring_3, icon_1, produced_btn;
    @FXML private Text high_score, total_stars;
    @FXML private TableView game_table;
    @FXML private ToggleButton play_bgmusic_btn, play_sounds_btn, autosave_btn;

    @FXML
    private void handleFeedback() throws Exception {
        System.out.println("Feedback Button was pressed");
        // Open feedback form
        URI uri = new URI("mailto:harsh19043@iiitd.ac.in;varun19124@iiitd.ac.in?subject=Color%20Switch%20Game%20Feedback");
        if (Desktop.isDesktopSupported()){
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse(uri);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }

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
        r[3].setNode(icon_1);
        r[4].setNode(produced_btn);
        r[5].setNode(ring_4);
        r[6].setNode(ring_5);

        for(int i=0; i<items; ++i)
            r[i].play();

    }

    public void updateStats(){
        total_stars.setText(Integer.toString(Main.getInstance().getCurrentPlayer().getStarsEarned()));
        high_score.setText((Integer.toString(Main.getInstance().getCurrentPlayer().getHighScore())));
    }

    @FXML
    private void loadSettings(MouseEvent me) throws Exception {
        Main.getInstance().loadSettings();
    }
    @FXML
    private void loadProducedBy(MouseEvent me) throws Exception {
        Main.getInstance().loadProducedBy();
    }
    @FXML
    private void loadAbout(MouseEvent me) throws Exception {
        Main.getInstance().loadAboutGame();
    }

    @FXML
    private void loadStats(MouseEvent me) throws Exception {
        Main.getInstance().loadStats();
    }

    @FXML
    private void backToHome(MouseEvent me) throws Exception {
        Main.getInstance().loadHome();
    }

    @FXML
    private void loadGamePage(MouseEvent me) throws Exception {
        Main.getInstance().loadGame();
    }

    @FXML
    public void exitGame(MouseEvent me) throws IOException {
        LoginController.serialize(Main.getInstance().getCurrentPlayer());

        System.out.println("\nexit game serialize:");
        Main.getInstance().getCurrentPlayer().print_player();

        Main.getInstance().setCurrentPlayer(null);
        Platform.exit();
    }

    public void logoutGame(MouseEvent mouseEvent) throws Exception {
        LoginController.serialize(Main.getInstance().getCurrentPlayer());

        System.out.println("\nlogout serialize:");
        Main.getInstance().getCurrentPlayer().print_player();

        Main.getInstance().setCurrentPlayer(null);
        Main.getInstance().loadUserLogin();
    }

    @FXML
    private void loadHome(MouseEvent me) throws Exception {
        Main.getInstance().loadHome();
    }

    public void loadUserLogin(MouseEvent mouseEvent) throws Exception {
        Main.getInstance().setCurrentPlayer(null);
        Main.getInstance().loadUserLogin();
    }

    public Object[][] getTableMatrix(){
        Map<Long, Game> game_map = Main.getInstance().getCurrentPlayer().getSavedGamesMap();
        int col = 3;
        int row = game_map.size();

        Object[][] game_data = new Object[row][col];

        int i = 0;

        for (Map.Entry<Long, Game> map_element : game_map.entrySet()){
            long id  = map_element.getKey();
            String date_time = map_element.getValue().getDateTime();
            int score = map_element.getValue().score;

            game_data[i][0] = id;
            game_data[i][1] = date_time;
            game_data[i][2] = score;

            i++;
        }
        return game_data;
    }

    public void playBgMusic(MouseEvent mouseEvent) {
        Main.getInstance().toggleMusic();
        Main.getInstance().playBackgroundMusic();
    }

    public void playSounds(MouseEvent mouseEvent) {
        Main.getInstance().toggleGameSounds();
    }

    public void toggleAutoSave(MouseEvent mouseEvent){
        Main.getInstance().toggleAutoSave();
    }
}
