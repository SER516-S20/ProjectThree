package Shapes;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author Anusha
 * @version 1.0
 */
public class TriangleShape extends Shape {

    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillPolygon(new double[]{left, left - 65, left + 10}, new double[]{top, top - 10, top + 55}, 3);
        g.strokePolygon(new double[]{left, left - 65, left + 10}, new double[]{top, top - 10, top + 55}, 3);

    }
}