import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private static Main main;
    private double width, height;
    private String color = "#292929";
    private Stage primaryStage;
    private Player currentPlayer;

    public MediaPlayer bgMusic, tap, star, hit, resurrect, buttonPress, over, colorSwitch;

    private boolean musicOn, gameSounds, autoSave;

    private void loadMusic() {
        bgMusic = new MediaPlayer(new Media(new File("assets/sounds/bgMusic.mp3").toURI().toString()));
        tap = new MediaPlayer(new Media(new File("assets/sounds/jump.wav").toURI().toString()));
        star = new MediaPlayer(new Media(new File("assets/sounds/star.wav").toURI().toString()));
        hit = new MediaPlayer(new Media(new File("assets/sounds/dead.wav").toURI().toString()));
        resurrect = new MediaPlayer(new Media(new File("assets/sounds/victory.wav").toURI().toString()));
        buttonPress = new MediaPlayer(new Media(new File("assets/sounds/button.wav").toURI().toString()));
        over = new MediaPlayer(new Media(new File("assets/sounds/start.wav").toURI().toString()));
        colorSwitch = new MediaPlayer(new Media(new File("assets/sounds/colorswitch.wav").toURI().toString()));
    }

    public void playBackgroundMusic(){
        if(musicOn) {
            bgMusic.setCycleCount(MediaPlayer.INDEFINITE);
            bgMusic.play();
        }
        else{
            bgMusic.stop();
        }
    }

    public static Main getInstance() {
        if(main == null) {
            main = new Main();
            // Do set the stage when calling from outside
        }
        return main;
    }

    public boolean isAutoSave() {
        return autoSave;
    }
    public void toggleAutoSave() {
        autoSave = !autoSave;
    }
    public boolean isGameSounds() {
        return gameSounds;
    }
    public void toggleGameSounds() {
        gameSounds = !gameSounds;
    }
    public boolean isMusicOn() {
        return musicOn;
    }
    public void toggleMusic() {
        musicOn = !musicOn;
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
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("scenes/stats.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.updateStats();
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadGame() throws Exception {
        Game game = new Game(getCurrentPlayer(), primaryStage.getScene());
//        Game game = getCurrentPlayer().getPlayerGame();
//        System.out.println(game.score);
    }

    protected void loadSavedGames() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/saved_games.fxml"));
        Parent root = loader.load();
        ((Controller)loader.getController()).loadGamesList();
        scale(root);
        primaryStage.getScene().setRoot(root);
    }

    protected void loadGameOver(int score, int highScore) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/game_over.fxml"));
        Parent root = loader.load();
        GameController controller = loader.getController();
        controller.setGameOverScores(score, highScore);
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

    public void setupScreen(Stage stage) {
        primaryStage = stage;
        Rectangle2D viewPort = Screen.getPrimary().getVisualBounds();
        height = viewPort.getHeight();
        width = 3*height/4;
    }

    @Override
    public void start(Stage stage) throws Exception{
        setupScreen(stage);


        loadMusic();
        Scene scene = new Scene(new Pane());
        scene.setFill(Paint.valueOf(color));
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/assets/color-switch-icon.png"));
        primaryStage.setTitle("Color Switch");
        main = this;

//        toggleGameSounds();
//        playTapSound();
//        toggleMusic();
//        playBackgroundMusic();

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
