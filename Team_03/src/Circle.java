import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Circle.java - a class for creating circle shape at a particular position
 * 
 * @author Nachiappan Lakshmanan
 * @version 1.0
 * @since 01/27/2020
 */
public class Circle implements Shape {

	static final int DOT_HEIGHT = 10;
	static final int DOT_WIDTH = 10;
	

	static final int DOT_CENTER = 20;
    boolean isLineDrawn = false;
	Circle dot;

	private int coordinateX;
	private int coordinateY;
	private Color color;

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}
	
	public void setIsLineDrawn(boolean isLineDrawn) {
		this.isLineDrawn = isLineDrawn;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void addDot(Graphics graphics, int coordinateX, int coordinateY) {
		this.dot = new Circle();
		this.dot.setPosition(coordinateX + DOT_CENTER, coordinateY + DOT_CENTER);
		this.dot.setColor(Color.BLACK);
		this.dot.draw(graphics, false, DOT_HEIGHT, DOT_WIDTH);

	}

	@Override
	public void setPosition(int x, int y) {
		this.coordinateX = x;
		this.coordinateY = y;
	}

	@Override
	public void draw(Graphics graphics, boolean isShape, int circleWidth, int circleHeight) {

		graphics.setColor(color);
		graphics.drawOval(coordinateX, coordinateY, circleWidth, circleHeight);
		graphics.fillOval(coordinateX, coordinateY, circleWidth, circleHeight);
		if (isShape) {
			addDot(graphics, coordinateX, coordinateY);
		}

	}

	@Override
	public void setLinePosition(int x, int y, int x1, int y1) {
		
	}

}
