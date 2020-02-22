import javafx.scene.canvas.GraphicsContext;

/**
 * @author Amudhan
 * @version 1.0
 */

public class TriangleShapeWithDots extends Shape {
//This class is used to draw three dots in each triangle
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillPolygon(new double[]{left - 10, left + 70, left - 70}, new double[]{top - 40, top + 40, top + 40}, 3);
        g.strokePolygon(new double[]{left - 10, left + 70, left - 70}, new double[]{top - 40, top + 40, top + 40}, 3);
    }
}