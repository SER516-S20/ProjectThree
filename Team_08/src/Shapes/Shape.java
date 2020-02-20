package Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Kartik
 * @version 1.0
 */
public abstract class Shape {
    int left, top;
    int width, height;
    Color color = Color.WHITE;

    public void reshape(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void moveBy(int dx, int dy) {
        left += dx;
        top += dy;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean containsPoint(int x, int y) {
        if (x >= left && x < left + width && y >= top && y < top + height)
            return true;
        else
            return false;
    }

    public abstract void draw(GraphicsContext g);

}