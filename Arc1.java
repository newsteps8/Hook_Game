//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;


class Arc1 extends Pane{
    Arc arc = new Arc();
    public Arc1(int centerX,int centerY) {
        arc.setCenterX(centerX);
        arc.setCenterY(centerY);
        arc.setRadiusX(10);
        arc.setRadiusY(10);
        arc.setStartAngle(0.0f);
        arc.setLength(180.0f);
        arc.setStrokeWidth(3);
        arc.setFill(Color.WHITE);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.BLACK);
        getChildren().add(arc);
    }
    public void arcTranslationLeftorRight(int endValue) {
        KeyValue keyValue4 = new KeyValue(arc.layoutXProperty(), endValue);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        KeyFrame keyFrame = new KeyFrame(duration, keyValue4);
        //        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }




}

