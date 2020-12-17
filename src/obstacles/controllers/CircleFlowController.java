package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class CircleFlowController extends SuperController {
    @FXML
    public Pane circleFlow;

    @FXML private Circle yellow_ball_1, yellow_ball_2, yellow_ball_3, yellow_ball_4, yellow_ball_5, yellow_ball_6, yellow_ball_7;
    @FXML private Circle blue_ball_1, blue_ball_2, blue_ball_3, blue_ball_4, blue_ball_5, blue_ball_6, blue_ball_7;
    @FXML private Circle pink_ball_1, pink_ball_2, pink_ball_3, pink_ball_4, pink_ball_5, pink_ball_6, pink_ball_7;
    @FXML private Circle purple_ball_1, purple_ball_2, purple_ball_3, purple_ball_4, purple_ball_5, purple_ball_6, purple_ball_7;

    @FXML
    public Pane star;

    public Circle[] yellow_balls = {yellow_ball_1, yellow_ball_2, yellow_ball_3, yellow_ball_4, yellow_ball_5, yellow_ball_6, yellow_ball_7};
    public Circle[] blue_balls = {blue_ball_1, blue_ball_2, blue_ball_3, blue_ball_4, blue_ball_5, blue_ball_6, blue_ball_7};
    public Circle[] pink_balls = {pink_ball_1, pink_ball_2, pink_ball_3, pink_ball_4, pink_ball_5, pink_ball_6, pink_ball_7};
    public Circle[] purple_balls = {purple_ball_1, purple_ball_2, purple_ball_3, purple_ball_4, purple_ball_5, purple_ball_6, purple_ball_7};

    public CircleFlowController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circleFlow);
    }
}
