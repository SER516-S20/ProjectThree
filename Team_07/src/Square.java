import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Square extends Shapes implements Serializable {
    final int WIDTH = 100, HEIGHT = 100;
    Bar[] bars = new Bar[2];

    public Square(int x, int y) {
        this.xCoordinate = x - (WIDTH / 2);
        this.yCoordinate = y - (HEIGHT / 2);
    }

    public void createShape(Graphics graphics) {
        Color lightBlue = new Color(0, 122, 255, 101);
        graphics.setColor(lightBlue);
        graphics.fillRect(this.xCoordinate, this.yCoordinate, HEIGHT, WIDTH);
        bars[0] = new Bar(10 + this.xCoordinate, 10 + this.yCoordinate, graphics);
        bars[1] = new Bar(80 + this.xCoordinate, 10 + this.yCoordinate, graphics);
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x > this.xCoordinate && x < this.xCoordinate + WIDTH) &&
                (y > this.yCoordinate && y < this.yCoordinate + HEIGHT);
    }

    @Override
    public boolean isDotOrBarClicked(MouseEvent mouseEvent) {
        boolean tempFlag = false;
        for (Bar bar : bars) {
            if (bar.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                tempFlag = true;
            }
        }
        return tempFlag;
    }

    @Override
    public void changeLocation(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
}
