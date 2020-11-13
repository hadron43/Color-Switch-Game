import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("screens/sample.fxml"));
        // Adding stylesheet to the root
        root.getStylesheets().add(getClass().getResource("style/style.css").toExternalForm());

        primaryStage.setTitle("Color Switch");
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
