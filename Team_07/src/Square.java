import java.awt.*;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Square extends Shapes {
    final int WIDTH = 100, HEIGHT = 100;

    public Square(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public void createShape(Graphics graphics) {
        Color lightblue = new Color(0, 122, 255, 101);
        graphics.setColor(lightblue);
        graphics.fillRect(this.xCoordinate, this.yCoordinate, HEIGHT, WIDTH);
        new Bar(10 + this.xCoordinate, 10 + this.yCoordinate, graphics);
        new Bar(80 + this.xCoordinate, 10 + this.yCoordinate, graphics);
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x > this.xCoordinate && this.xCoordinate < this.xCoordinate + WIDTH) && (y > this.yCoordinate && this.yCoordinate < this.yCoordinate + HEIGHT);
    }

    @Override
    public void changeLocation(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

}
