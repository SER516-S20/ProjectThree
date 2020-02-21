import java.awt.*;

/**
 * @author Aditya Bajaj
 * @since 02-18-2020
 */

public class Dot extends Shapes {
    final int RADIUS = 5;
    final int DIAMETER = 2 * RADIUS;

    public Dot(int x, int y, Graphics graphics) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.createShape(graphics);
    }

    @Override
    public void createShape(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(xCoordinate - RADIUS, yCoordinate - RADIUS, DIAMETER, DIAMETER);
    }

    @Override
    public boolean isInside(int x, int y) {
        return ((x - (this.xCoordinate + RADIUS)) * (x - (this.xCoordinate + RADIUS)) +
                (y - (this.yCoordinate + RADIUS)) * (y - (this.yCoordinate + RADIUS)) <= this.RADIUS * this.RADIUS);
    }

    @Override
    public void changeLocation(int x, int y) {

    }
}
