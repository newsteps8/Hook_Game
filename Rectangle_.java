import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

    public class Rectangle_ extends Pane {

        public Rectangle_(int x, int y, int width, int height) {
            Rectangle rectangle = new Rectangle(x,y,width,height);
            rectangle.setStroke(Color.WHITE);
            rectangle.setFill(Color.WHITE);
            getChildren().add(rectangle);
        }
    }


