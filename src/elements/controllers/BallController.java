package elements.controllers;

import global.SuperController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BallController extends SuperController implements Initializable {

    @FXML
    public Pane ball;
    @FXML
    public Circle circle_ball;

    private static double moveUpDist = 80, moveUpDur = 200, minY = 1024/2, maxY = 1024-50;
    private Timeline upTimeline, downTimeline, initialTimeline;

    public BallController () {
        upTimeline = new Timeline();
        downTimeline = new Timeline();
        initialTimeline = new Timeline();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void welcome() {
        // Welcome translate transition
        initialTimeline.setCycleCount(Timeline.INDEFINITE);
        KeyValue kv = new KeyValue(ball.layoutYProperty(), ball.layoutYProperty().getValue() - moveUpDist, Interpolator.EASE_OUT);
        initialTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur*2), kv));
        initialTimeline.setAutoReverse(true);
        initialTimeline.play();
    }

    public double moveUp() {
        double ret = 0, value = moveUpDist;
        upTimeline.stop();
        initialTimeline.stop();
        downTimeline.stop();
        upTimeline = new Timeline();

        double layoutY = ball.getLayoutY();

        if(layoutY - value < minY) {
            ret = minY - (layoutY - value);
            value = layoutY - minY;
        }
//        For Debugging purpose
//        System.out.println("ball y: "+ layoutY +" move ball up by: "+value + ", shift obstacles down by : "+ret);

        DoubleProperty posY = ball.layoutYProperty();
        upTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur*(value)/moveUpDist), new KeyValue(posY, posY.getValue() - value + 1, Interpolator.EASE_OUT)));
        upTimeline.play();
        upTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                freeFall();
            }
        });
        return ret;
    }
    public void freeFall(){
        downTimeline.stop();
        downTimeline = new Timeline();
        DoubleProperty layoutY = ball.layoutYProperty();
        downTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(moveUpDur * (maxY - layoutY.getValue())/moveUpDist), new KeyValue(layoutY, maxY, Interpolator.EASE_IN)));
        downTimeline.play();
        System.out.println("Down movement triggered!");
    }
}
