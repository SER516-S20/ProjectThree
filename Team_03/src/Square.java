import java.awt.Color;
import java.awt.Graphics;

/**
 * Square.java - a class for creating square shape at a particular position
 * 
 * @author Nachiappan Lakshmanan
 * @version 1.0
 * @since 01/29/2020
 */
public class Square implements Shape {

	private int coordinateX;
	private int coordinateY;
	private Color color;
	Square bar1, bar2;

	static final int BAR_HEIGHT = 40;
	static final int BAR_WIDTH = 10;
	static final int BAR_DEVIATION = 5;

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public void setPosition(int x, int y) {
		this.coordinateX = x;
		this.coordinateY = y;
	}

	public void addBar(Graphics graphics, int cordinateX, int cordinateY) {
		this.bar1 = new Square();
		this.bar1.setColor(Color.black);
		this.bar1.setPosition(cordinateX + BAR_DEVIATION, cordinateY + BAR_DEVIATION);
		this.bar1.draw(graphics, false, BAR_HEIGHT, BAR_WIDTH);

		this.bar2 = new Square();
		this.bar2.setColor(Color.black);
		this.bar2.setPosition(cordinateX + (BAR_DEVIATION * 7), cordinateY + BAR_DEVIATION);
		this.bar2.draw(graphics, false, BAR_HEIGHT, BAR_WIDTH);
	}

	@Override
	public void draw(Graphics graphics, boolean isShape, int height, int width) {
		graphics.setColor(color);
		graphics.drawRect(coordinateX, coordinateY, width, height);
		graphics.fillRect(coordinateX, coordinateY, width, height);

		if (isShape) {
			addBar(graphics, coordinateX, coordinateY);
		}
	}

	@Override
	public void setLinePosition(int x, int y, int x1, int y1) {
		//setLinePosition() is a method in interface Shape and we need to override it
		//Line Position is not required to be implemented for Square Shape
	}

}
