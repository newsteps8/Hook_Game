//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
class LineBlack extends Pane{

    Line line;

    public LineBlack(int x, int y, int endx, int endy) {

        line = new Line();
        line.setStartX(x);
        line.setEndX(endx);
        line.setStartY(y);
        line.setEndY(endy);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        getChildren().add(line);
    }

    public void lineTranslationToLeftorRight(int endValue) {
        KeyValue keyValue3 = new KeyValue(line.layoutXProperty(), endValue);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        KeyFrame keyFrame = new KeyFrame(duration, keyValue3);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void lineTranslationToDownorTop(int endValue) {
        KeyValue keyValue3 = new KeyValue(line.layoutYProperty(), endValue);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        KeyFrame keyFrame = new KeyFrame(duration, keyValue3);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void expandLeftAndRight() {
        KeyValue keyValue = new KeyValue(line.scaleXProperty(), 2);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);
        KeyFrame keyFrame = new KeyFrame(duration, keyValue);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void expandBelowAndAbove() {

        KeyValue keyValue = new KeyValue(line.scaleYProperty(), 2);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        KeyFrame keyFrame = new KeyFrame(duration, keyValue);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    public void shrinkAndDisappear() {

        KeyValue keyValue = new KeyValue(line.scaleYProperty(), 0.25);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            }
        };
        KeyFrame keyFrame = new KeyFrame(duration,keyValue);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    public void shrinkAndDisappear2(){
        KeyValue keyValue = new KeyValue(line.scaleXProperty(), 0.25);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            }
        };
        KeyFrame keyFrame = new KeyFrame(duration,keyValue);
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

}

