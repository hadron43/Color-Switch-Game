import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameTester extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Only for testing purposes
        Scene scene = new Scene(new Pane());
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.setHeight(1024);
        primaryStage.setWidth(768);
        primaryStage.show();
        Game game = new Game(new Player(), scene);
        System.out.println(game.getId());
        primaryStage.hide();
        primaryStage.show();
    }
}
