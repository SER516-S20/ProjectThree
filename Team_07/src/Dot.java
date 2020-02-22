import java.awt.*;

/**
 * @author Aditya Bajaj
 * @author Aravind Thillai Villalan
 * @since 02-18-2020
 */

public class Dot extends Shapes {
    final int RADIUS = 5;
    final int DIAMETER = 2 * RADIUS;
    boolean isConnected = false;

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
        return ((x - (this.xCoordinate )) * (x - (this.xCoordinate)) +
                (y - (this.yCoordinate)) * (y - (this.yCoordinate)) <= this.DIAMETER * this.DIAMETER);
    }
    @Override
    public void changeLocation(int x, int y) {

    }
      
}
