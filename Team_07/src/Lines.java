import java.awt.Graphics;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Lines extends Shapes{
	
	//private int srcPointX,srcPointY;
	//the x and y of the abstract class  is the srcPointX and srcPointY
	
	private int destPointX,destPointY;
	
	public int getDestPointX() {
		return destPointX;
	}
	public void setDestPointX(int destPointX) {
		this.destPointX = destPointX;
	}
	public int getDestPointY() {
		return destPointY;
	}
	public void setDestPointY(int destPointY) {
		this.destPointY = destPointY;
	}
	
	public Lines(int srcPointX, int srcPointY) {
		super();
		this.xCoordinate = srcPointX;
		this.yCoordinate = srcPointY;
	}
	
	@Override
	public void createShape(Graphics graphics) {
		
		graphics.drawLine(this.xCoordinate, this.yCoordinate, destPointX, destPointY);
	}
	
	@Override
	public boolean isInside(int x, int y) {
		return false;
	}
	
	@Override
	public void changeLocation(int x, int y) {
		
		//this method changes the source point of the line
		this.xCoordinate=x;
		this.yCoordinate=y;
		
		
	}
	
	
	
}
