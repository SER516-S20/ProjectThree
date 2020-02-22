import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * @author Aditya Bajaj
 * @author Aravind Thillai Villalan
 * @since 02-18-2020
 */

public class Dot extends Shapes implements Serializable {
    final int RADIUS = 5;
    final int DIAMETER = 2 * RADIUS;
    boolean isConnected = true;

    //isDrawn
    //ischecked

    public Dot(int x, int y, Graphics graphics) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.createShape(graphics);
    }
    
    public Dot(int x,int y) {
    	this.xCoordinate=x;
    	this.yCoordinate=y;
    }

    @Override
    public void createShape(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(xCoordinate - RADIUS, yCoordinate - RADIUS, DIAMETER, DIAMETER);
    }

    @Override
    public boolean isInside(int x, int y) {
        return ((x - (this.xCoordinate)) * (x - (this.xCoordinate)) +
                (y - (this.yCoordinate)) * (y - (this.yCoordinate)) <= this.DIAMETER * this.DIAMETER);
    }

    @Override
    public void changeLocation(int x, int y) {
    }

    @Override
    public Shapes getClickedDotOrBar(MouseEvent mouseEvent) {
        return null;
    }

    @Override
    public boolean isDotOrBarClicked(MouseEvent mouseEvent) {
        return false;
    }
      
}
