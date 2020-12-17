import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GameTester extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Only for testing purposes
        Main.getInstance().setupScreen(primaryStage);
        Scene scene = new Scene(new Pane());
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
        Game game = new Game(new Player("uname", "pass"), scene);
        primaryStage.setHeight(Main.getInstance().getHeight());
        primaryStage.setWidth(Main.getInstance().getWidth());
        scene.setFill(Paint.valueOf(Main.getInstance().getColor()));
        System.out.println(game.getId());
        primaryStage.hide();
        primaryStage.show();
    }
}
