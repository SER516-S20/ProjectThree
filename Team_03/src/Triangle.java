import java.awt.Color;
import java.awt.Graphics;

/**
 * Triangle.java - a class for creating triangle shape at a particular position
 * 
 * @author Nachiappan Lakshmanan
 * @version 1.0
 * @since 01/29/2020
 */
public class Triangle implements Shape {

	private int coordinateX;
	private int coordinateY;
	Color color;

	Circle dot1, dot2, dot3;

	private static final int NUMBER_OF_LINES = 3;
	private static final int DOT_TRIANGLE_X_CORD_DEVIATION = 20;
	private static final int DOT_TRIANGLE_Y_CORD_DEVIATION = 40;

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	@Override
	public void setPosition(int x, int y) {
		this.coordinateX = x;
		this.coordinateY = y;
	}

	public void addDots(Graphics graphics, int coordinateX, int coordinateY) {
		this.dot1 = new Circle();
		this.dot1.setPosition(coordinateX + DOT_TRIANGLE_X_CORD_DEVIATION, coordinateY + DOT_TRIANGLE_Y_CORD_DEVIATION);
		this.dot1.setColor(Color.RED);
		this.dot1.draw(graphics, false, Circle.DOT_HEIGHT, Circle.DOT_WIDTH);
		
		
		
		this.dot2 = new Circle();
		this.dot2.setPosition(coordinateX - DOT_TRIANGLE_X_CORD_DEVIATION, coordinateY + DOT_TRIANGLE_Y_CORD_DEVIATION);
		this.dot2.setColor(Color.RED);
		this.dot2.draw(graphics, false, Circle.DOT_HEIGHT, Circle.DOT_WIDTH);
		
		
		this.dot3 = new Circle();
		this.dot3.setPosition(coordinateX-5, coordinateY+5);
		this.dot3.setColor(Color.RED);
		this.dot3.draw(graphics, false, Circle.DOT_HEIGHT, Circle.DOT_WIDTH);
	}

	@Override
	public void draw(Graphics graphics, boolean isShape, int size, int dupSize) {
		graphics.setColor(Color.BLACK);
		int[] xAxis = new int[] { coordinateX, coordinateX - size, coordinateX + size };
		int[] yAxis = new int[] { coordinateY, coordinateY + size, coordinateY + size };
		graphics.drawPolygon(xAxis, yAxis, NUMBER_OF_LINES);
		graphics.fillPolygon(xAxis, yAxis, NUMBER_OF_LINES);
		if (isShape) {
			addDots(graphics, coordinateX, coordinateY);
		}
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public void setLinePosition(int x, int y, int x1, int y1) {
		// TODO Auto-generated method stub
		
	}

}
