import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Sandya
 * @version 1.0
 */
public class OvalShape extends Shape {
    static Map<Integer, Integer> relCoordinates = new HashMap<>();

    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillOval(left, top, width, height);
        g.setStroke(Color.BLACK);
        g.strokeOval(left, top, width, height);
        relCoordinates.put(left + 35, top + 35);
        g.strokeOval(left + 35, top + 35, 2.5, 2.5);
    }

    public boolean containsPoint(int x, int y) {
        double rx = width / 2.0;
        double ry = height / 2.0;
        double cx = left + rx;
        double cy = top + ry;
        if ((ry * (x - cx)) * (ry * (x - cx)) + (rx * (y - cy)) * (rx * (y - cy)) <= rx * rx * ry * ry)
            return true;
        else
            return false;
    }
}
