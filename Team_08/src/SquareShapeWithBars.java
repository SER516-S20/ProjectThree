import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Kartik
 * @version 1.0
 */

public class SquareShapeWithBars extends Shape {
//This class is used to draw two vertical bars in the square
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillRect(left, top, width, height);
        g.fillRect(left - 5, top, width, height);
        g.setStroke(Color.BLACK);
        g.strokeRect(left, top, width, height);
        g.strokeRect(left - 5, top, width, height);
    }
}
