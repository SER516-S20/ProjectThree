import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Circle extends Shapes implements Serializable {
    final int RADIUS = 50;
    final int DIAMETER = RADIUS * 2;
    Dot dot;

    public Circle(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate - RADIUS;
        this.yCoordinate = yCoordinate - RADIUS;
    }

    public void createShape(Graphics graphics) {
        Color green = new Color(0, 233, 67, 188);
        graphics.setColor(green);
        graphics.fillOval(this.xCoordinate, this.yCoordinate, this.DIAMETER, this.DIAMETER);
        dot = new Dot(RADIUS + this.xCoordinate, RADIUS + this.yCoordinate, graphics);
    }

    //checks if the point is inside the shape
    public boolean isInside(int x, int y) {
        return ((x - (this.xCoordinate + RADIUS)) * (x - (this.xCoordinate + RADIUS)) +
                (y - (this.yCoordinate + RADIUS)) * (y - (this.yCoordinate + RADIUS))
                <= this.RADIUS * this.RADIUS);
    }

    //returns the clicked dot
    public Shapes getClickedDotOrBar(MouseEvent mouseEvent) {
        if (dot.isInside(mouseEvent.getX(), mouseEvent.getY()))
            return dot;
        return null;
    }

    @Override
    public boolean isDotOrBarClicked(MouseEvent mouseEvent) {
        return dot.isInside(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void changeLocation(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
}