import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        Node obstacle = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));
        BorderPane box = new BorderPane();
        box.setCenter(obstacle);
        primaryStage.setTitle("Color Switch");
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
