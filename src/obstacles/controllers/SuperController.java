package obstacles.controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperController implements Initializable {
    public static int defaultRotatingDuration = 4000;
    public static int defaultScalingDuration = 750;
    // To store all transition objects
    private final List<Transition> transitions;
    @FXML
    private Pane star;

    protected SuperController() {
        this.transitions = new ArrayList<>();
    }

    protected void loadStar(Pane customPane) {
        if(customPane != null) {
            Pane temp;
            try {
                temp = FXMLLoader.load(getClass().getResource("/elements/fxml/star.fxml"));
                List<Node> parentChildren = ((Pane) customPane.getParent()).getChildren();
                parentChildren.set(parentChildren.indexOf(customPane), temp);
                customPane = temp;
                addScaling(customPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadStar() {
        loadStar(star);
    }

    public void addRotation(Node node, int timeInMillis, boolean clockwise) {
        RotateTransition rt = new RotateTransition();
        rt.setAxis(Rotate.Z_AXIS);
        rt.setByAngle((clockwise) ? 360 : -360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setDuration(Duration.millis(timeInMillis));
        rt.setNode(node);
        transitions.add(rt);
        rt.play();
    }

    protected void addScaling(Node node, int timeInMillis, double scaleFactor) {
        ScaleTransition st = new ScaleTransition();
        st.setByX(scaleFactor);
        st.setByY(scaleFactor);
        st.setByZ(scaleFactor);
        st.setDuration(Duration.millis(timeInMillis));
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.setNode(node);
        transitions.add(st);
        st.play();
    }

    protected void addScaling(Node node) { addScaling(node, defaultScalingDuration, 0.3);}

    public void addRotation(Node node) {
        addRotation(node, defaultRotatingDuration, ((int) (Math.random()*2))==1?true:false);
    }

    protected Pane getStar() {return star;}
}
