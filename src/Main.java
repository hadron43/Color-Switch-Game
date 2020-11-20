import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.transform.*;
import javafx.stage.*;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Scene loadSampleObstacle() throws Exception {
        Node obstacle = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));
        BorderPane box = new BorderPane();
        box.setCenter(obstacle);
        Scene scene = new Scene(box, 500, 500);

        scene.getStylesheets().add(getClass().getResource("style/style.css").toExternalForm());

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1000);
        rotateTransition.setDuration(Duration.millis(2000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setNode(obstacle);
        rotateTransition.play();

        scene.setCursor(Cursor.DEFAULT);
        return scene;
    }

    private Scene loadSettings() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scenes/settings.fxml"));
        return new Scene(root);
    }

    private Scene loadProducedBy() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scenes/produced.fxml"));
        return new Scene(root);
    }

    public Scene getHome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scenes/home.fxml"));
        return new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");

        Scene scene = getHome();

        primaryStage.setScene(scene);
        primaryStage.setHeight(1024);
        primaryStage.setWidth(768);
        primaryStage.show();
    }
}
