import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    static double width, height;

    public static void main(String[] args) {
        launch(args);
    }

    private static void scale(Parent root) {
        Scale scale = new Scale();
        scale.setPivotY(0);;
        scale.setPivotX(0);
        scale.setY(height/1024);;
        scale.setX(width/768);
        System.out.println(root);
        root.getTransforms().addAll(scale);
    }

    protected static Scene loadSettings() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/settings.fxml"));
        scale(root);
        Scene scene = new Scene(root);
        scene.setFill(Paint.valueOf("#292929"));
        return scene;
    }

    protected static Scene loadProducedBy() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/produced.fxml"));
        scale(root);
        Scene scene = new Scene(root);
        scene.setFill(Paint.valueOf("#292929"));
        return scene;
    }

    protected static Scene loadAboutGame() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/about_game.fxml"));
        scale(root);
        Scene scene = new Scene(root);
        scene.setFill(Paint.valueOf("#292929"));
        return scene;
    }

    protected static Scene loadStats() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/stats.fxml"));
        return new Scene(root);
    }

    protected static Scene getHome() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/home.fxml"));
        scale(root);
        Scene scene = new Scene(root);
        scene.setFill(Paint.valueOf("#292929"));
        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");

        Rectangle2D viewPort = Screen.getPrimary().getVisualBounds();
        height = viewPort.getHeight();
        width = 3*height/4;

        Scene scene = getHome();
//        Scene scene = loadStats();

        primaryStage.setScene(scene);
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.show();
    }

    @Override
    public void init() {
        Font font = Font.loadFont(getClass().getResourceAsStream("fonts/Dyuthi-Regular.ttf"), 32);
    }
}
