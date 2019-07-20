//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

class Arc3 extends Pane{
    Arc arc2 = new Arc();
    public Arc3(int centerX,int centerY){

        arc2.setCenterX(centerX);
        arc2.setCenterY(centerY);
        arc2.setRadiusX(10);
        arc2.setRadiusY(10);
        arc2.setStartAngle(0.0f);
        arc2.setLength(180.0f);
        arc2.setRotate(270);
        arc2.setStrokeWidth(3);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);
        getChildren().add(arc2);
    }
    public void arcTranslationUporDown(int endValue) {
        KeyValue keyValue3 = new KeyValue(arc2.layoutYProperty(), endValue);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        KeyFrame keyFrame = new KeyFrame(duration, keyValue3);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
