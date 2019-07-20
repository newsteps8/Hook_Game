import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public interface Disappear{

    default void disappear(Object arr[]){
        for (int i = 0; i <arr.length ; i++) {
            FadeTransition ft = new FadeTransition(Duration.millis(1000),(Pane)arr[i]);
            ft.setFromValue(1.0f);
            ft.setToValue(0.0f);
            ft.play();
        }
    }
}
