package obstacles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TestObstacle extends Application {
    private Scene loadSampleObstacle() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/sample.fxml"));
        return new Scene(root, 500, 500);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");

        Scene scene = loadSampleObstacle();

        primaryStage.setScene(scene);
        primaryStage.setHeight(1024);
        primaryStage.setWidth(768);
        primaryStage.show();
    }
}
