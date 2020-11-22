import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    static double width, height;
    static String color = "#292929";
    static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    private static void scale(Parent root) {
        Scale scale = new Scale();
        scale.setPivotY(0);
        scale.setPivotX(0);
        scale.setY(height/1024);
        scale.setX(width/768);
        root.getTransforms().addAll(scale);
    }

    protected static void loadSettings() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/settings.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadProducedBy() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/produced.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadAboutGame() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/about_game.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadStats() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/stats.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadGame() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/game.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadGameOver() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/game_over.fxml"));

        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected static void loadHome() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/home.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    @Override
    public void start(Stage stage) throws Exception{
        primaryStage = stage;
        Scene scene = new Scene(new Pane());
        scene.setFill(Paint.valueOf(color));
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");

        Rectangle2D viewPort = Screen.getPrimary().getVisualBounds();
        height = viewPort.getHeight();
        width = 3*height/4;

//        loadHome();
        loadGameOver();

        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.show();
    }

    @Override
    public void init() {
        Font font = Font.loadFont(getClass().getResourceAsStream("fonts/Dyuthi-Regular.ttf"), 32);
    }
}
