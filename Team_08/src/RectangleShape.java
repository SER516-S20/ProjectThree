import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Amudhan
 * @version 1.0
 */
public class RectangleShape extends Shape {
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillRect(left, top, width, height);
        g.setStroke(Color.BLACK);
        g.strokeRect(left, top, width, height);
    }
}