import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public interface ButtonStyle{
    final int buttonsize=30;
     default void buttonShapeAndColor(Button button) {//Make the button which is circle
         double r=15;
         Circle circle1=new Circle(3,3,3);
         circle1.setFill(Color.BLACK);

         button.setShape(circle1);
         button.setMinSize(2*r, 2*r);
         button.setMaxSize(2*r, 2*r);
         button.setStyle("fx-background-color:black;");

    }
    default void buttonShrink(Button button){

        KeyValue keyValue = new KeyValue(button.scaleXProperty(), 0.25);
        KeyValue keyValue2=new KeyValue(button.scaleYProperty(),0.25);
        Timeline timeline = new Timeline();
        Duration duration = Duration.millis(1500);

        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            }
        };
        KeyFrame keyFrame = new KeyFrame(duration,keyValue,keyValue2);


        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }
}
