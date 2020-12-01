import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    private void loadGameOver(MouseEvent me) throws Exception {
        Main.loadGameOver();
    }
}
