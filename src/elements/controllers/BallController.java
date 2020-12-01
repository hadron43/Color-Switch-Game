package elements.controllers;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BallController implements Initializable {

    @FXML
    public Pane ball;
    @FXML
    public Circle circle_ball;
    private final List<Transition> ball_transitions;

    public BallController() {
        this.ball_transitions = new ArrayList<Transition>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Welcome translate transition
        TranslateTransition t_trans = new TranslateTransition();
        t_trans.setByY(-100);
        t_trans.setDuration(Duration.millis(750));
        t_trans.setCycleCount(Animation.INDEFINITE);
        t_trans.setAutoReverse(true);
        t_trans.setNode(ball);
        t_trans.play();
        ball_transitions.add(t_trans);

        // move up transition
        TranslateTransition move_up = new TranslateTransition(Duration.millis(250), ball);
        move_up.setByY(-100);
        ball_transitions.add(move_up);

        // free fall transition
        TranslateTransition free_fall = new TranslateTransition(Duration.millis(250), ball);
        free_fall.setByY(75);
        ball_transitions.add(free_fall);


    }

    public void moveUp(MouseEvent mouseEvent) {
        ball_transitions.get(0).stop();
        ball_transitions.get(1).play();
    }

    public void freeFall(MouseEvent me) {
        ball_transitions.get(2).play();
    }


    // Key functionality to be added:

//    public void moveUp(KeyEvent ke){
//        if (ke.getCode() == KeyCode.UP){
//            System.out.println("UP pressed!");
//            TranslateTransition move_up = new TranslateTransition(Duration.millis(250), ball);
//            move_up.setByY(-100);
//            move_up.play();
//        }
//    }
//    public void freeFall(KeyEvent ke){
//        if (ke.getCode() == KeyCode.UP){
//            System.out.println("UP released!");
//            TranslateTransition fall = new TranslateTransition(Duration.millis(250), ball);
//            fall.setByY(75);
//            fall.play();
//        }
//    }
}
