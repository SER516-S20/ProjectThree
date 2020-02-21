import java.awt.*;

/**
 * @author Aravind Thillai Villalan
 * @author Aditya Bajaj
 * @since 02-18-2020
 */

public class Bar extends Shapes {
    int WIDTH = 10;
    int HEIGHT = 80;

    public Bar(int x, int y, Graphics graphics) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.createShape(graphics);
    }

    @Override
    public void createShape(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x > this.xCoordinate && x < this.xCoordinate + WIDTH) && (y > this.yCoordinate && y < this.yCoordinate + HEIGHT);
    }

    @Override
    public void changeLocation(int xCoordinateNew, int yCoordinateNew) {

    }
}
