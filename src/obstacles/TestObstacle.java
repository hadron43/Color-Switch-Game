package obstacles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class TestObstacle extends Application {
    private Scene loadSampleObstacle() throws Exception {
        Node root = FXMLLoader.load(getClass().getResource("/obstacles/square.fxml"));
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.add(root, 0, 0);
        return new Scene(pane, 500, 500);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");

        Scene scene = loadSampleObstacle();
        scene.setFill(Paint.valueOf("#292929"));

        primaryStage.setScene(scene);
        primaryStage.setHeight(1024);
        primaryStage.setWidth(768);
        primaryStage.show();
    }
}
