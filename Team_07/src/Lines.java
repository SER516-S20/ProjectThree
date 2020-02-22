import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Lines extends Shapes {

    private int srcPointX, srcPointY;
    private int destPointX, destPointY;

    public Lines(int x1, int y1, int x2, int y2) {
        super();
        this.srcPointX = x1;
        this.srcPointY = y1;
        this.destPointX = x2;
        this.destPointY = y2;
    }

    @Override
    public void createShape(Graphics graphics) {
        graphics.drawLine(this.srcPointX, this.srcPointY, destPointX, destPointY);
    }

    @Override
    public boolean isInside(int x, int y) {
        return false;
    }

    @Override
    public void changeLocation(int x, int y) {
        this.srcPointX = x;
        this.srcPointY = y;
    }

    @Override
    public Shapes getClickedDotOrBar(MouseEvent mouseEvent) {
        return null;
    }

    @Override
    public boolean isDotOrBarClicked(MouseEvent mouseEvent) {
        return false;
    }

    public void changeSourceLocation(int x, int y) {
        this.srcPointX = x;
        this.srcPointY = y;
    }

    public void changeDestinationLocation(int x, int y) {
        this.destPointX = x;
        this.destPointY = y;
    }

    public Point getCoordinatesOne() {
        return new Point(srcPointX, srcPointY);
    }

    public Point getCoordinatesTwo() {
        return new Point(destPointX, destPointY);
    }

}
