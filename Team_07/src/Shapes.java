import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author Aditya Bajaj
 * @since 02-18-2020
 */

public abstract class Shapes {
    public int xCoordinate, yCoordinate;

    public abstract void createShape(Graphics graphics);

    public abstract boolean isInside(int x, int y);

    public abstract void changeLocation(int x, int y);

    public abstract Shapes getClickedDotOrBar(MouseEvent mouseEvent);

    public abstract boolean isDotOrBarClicked(MouseEvent mouseEvent);
}
