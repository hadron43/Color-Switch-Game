import global.DuplicateUsernameException;
import global.InvalidCredentialsException;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private TextField usernameTxt;
    @FXML private PasswordField passwordTxt;
    @FXML private Button loginBtn;
    @FXML private Button createAccBtn;
    @FXML private Text login_status_label;
    @FXML private Pane login_plus_1, login_plus_2;
    @FXML private ImageView login_ring_1, login_ring_2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        final int items = 4;
        RotateTransition[] r = new RotateTransition[items];

        for(int i=0; i<items; ++i) {
            r[i] = new RotateTransition();
            r[i].setAxis(Rotate.Z_AXIS);
            r[i].setByAngle((Math.pow(-1, i))*360);
            r[i].setCycleCount(Animation.INDEFINITE);
            r[i].setInterpolator(Interpolator.LINEAR);
            if (i<2) r[i].setDuration(Duration.millis(1000));
            else r[i].setDuration(Duration.millis(3000));
        }

        r[0].setNode(login_ring_1);
        r[1].setNode(login_ring_2);
        r[2].setNode(login_plus_1);
        r[3].setNode(login_plus_2);

        for(int i=0; i<items; i++)
            r[i].play();

//        // clockwise rotation for plus_1 (left)
//        RotateTransition rt_plus_1 = new RotateTransition();
//        rt_plus_1.setAxis((Rotate.Z_AXIS));
//        rt_plus_1.setByAngle(360);
//        rt_plus_1.setCycleCount(Animation.INDEFINITE);
//        rt_plus_1.setInterpolator(Interpolator.LINEAR);
//        rt_plus_1.setDuration(Duration.millis(3000));
//        rt_plus_1.setNode(login_plus_1);
//
//        // anti-clockwise rotation for plus_2 (right)
//        RotateTransition rt_plus_2 = new RotateTransition();
//        rt_plus_2.setAxis((Rotate.Z_AXIS));
//        rt_plus_2.setByAngle(-360);
//        rt_plus_2.setCycleCount(Animation.INDEFINITE);
//        rt_plus_2.setInterpolator(Interpolator.LINEAR);
//        rt_plus_2.setDuration(Duration.millis(3000));
//        rt_plus_2.setNode(login_plus_2);
//
//        rt_plus_1.play();
//        rt_plus_2.play();
    }


    @FXML
    public void loginValidate(MouseEvent me) {
        try {
            if (usernameTxt.getText() == null || passwordTxt.getText() == null ||
                    usernameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
                throw new NullPointerException();
            }
            String user_name = usernameTxt.getText();
            String password = passwordTxt.getText();
            Player new_player = new Player(user_name, password);

            // Validate player credentials
            if (Main.validateLoginDetails(new_player)){
                login_status_label.setText("Logged in successfully!");
                login_status_label.setFill(Color.GREEN);
                Main.setCurrentPlayer(new_player);
                Main.loadHome();
            }
            else {
                throw new InvalidCredentialsException("Wrong credentials entered!");
            }
        }
        catch(NullPointerException | NumberFormatException e){
            login_status_label.setFill(Color.RED);
            login_status_label.setText("Invalid details. Try again!");
        }
        catch(InvalidCredentialsException e){
            login_status_label.setFill(Color.RED);
            login_status_label.setText("Wrong credentials entered!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void createNewAccount(MouseEvent me) {
        try{
            if (usernameTxt.getText() == null || passwordTxt.getText() == null ||
                    usernameTxt.getText().trim().isEmpty() || passwordTxt.getText().trim().isEmpty()) {
                throw new NullPointerException();
            }
            String user_name = usernameTxt.getText();
            String password = passwordTxt.getText();

            // Checking for duplicate username
            Player new_player = new Player(user_name, password);
            if (Main.checkDuplicateUsername(new_player)){
                throw new DuplicateUsernameException("Username already exists!");
            }
            else{
                Main.getPlayerList().add(new_player);
                login_status_label.setText("Account created successfully!");
                login_status_label.setFill(Color.GREEN);
                Main.loadHome();
            }
        }
        catch (NullPointerException | NumberFormatException e){
            login_status_label.setFill(Color.RED);
            login_status_label.setText("Invalid details. Try again!");
        }
        catch (DuplicateUsernameException e){
            login_status_label.setFill(Color.RED);
            login_status_label.setText("Username already exists!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
