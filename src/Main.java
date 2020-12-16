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
    private static Main main;
    private double width, height;
    private String color = "#292929";
    private Stage primaryStage;
    private Player currentPlayer;

    public static Main getInstance() {
        if(main == null) {
            main = new Main();
            main.setupScreen();
            // Do set the stage when calling from outside
        }
        return main;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected void scale(Parent root) {
        Scale scale = new Scale();
        scale.setPivotY(0);
        scale.setPivotX(0);
        scale.setY(height/1024);
        scale.setX(width/768);
        root.getTransforms().addAll(scale);
    }

    protected void loadSettings() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/settings.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadProducedBy() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/produced.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadAboutGame() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/about_game.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadStats() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/stats.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadGame() throws Exception {
        Game game = new Game(getCurrentPlayer(), primaryStage.getScene());
    }

    protected void loadGameOver() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/game_over.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadUserLogin() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/user_login.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadHome() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("scenes/home.fxml"));
        scale(root);
        primaryStage.getScene().setRoot(root);
    }


    protected Player getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private void setupScreen() {
        Rectangle2D viewPort = Screen.getPrimary().getVisualBounds();
        height = viewPort.getHeight();
        width = 3*height/4;
    }

    protected void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception{
        primaryStage = stage;
        Scene scene = new Scene(new Pane());
        scene.setFill(Paint.valueOf(color));
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");
        main = this;

        setupScreen();

        loadUserLogin();

        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.show();
    }

    @Override
    public void init() {
        Font font = Font.loadFont(getClass().getResourceAsStream("fonts/Dyuthi-Regular.ttf"), 32);
    }
}
