//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

class LineGray extends Pane{
    public LineGray(int x, int y, int x1, int y1) {
        Line line1 = new Line(x, y, x1, y1);
        line1.setStrokeWidth(2);
        line1.setStroke(Color.GRAY);
        getChildren().add(line1);
    }

}
