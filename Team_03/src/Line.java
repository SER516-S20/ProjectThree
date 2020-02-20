import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line implements Shape {
	private Color color;
	public int startCoordinateX;
	public int startCoordinateY;

	public int endCoordinateX;
	public int endCoordinateY;

	@Override
	public void setLinePosition(int startCoordinateX, int startCoordinateY, int endCoordinateX, int endCoordinateY) {
		this.startCoordinateX = startCoordinateX;
		this.startCoordinateY = startCoordinateY;

		this.endCoordinateX = endCoordinateX;
		this.endCoordinateY = endCoordinateY;

	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public void draw(Graphics graphics, boolean status, int width, int height) {

		graphics.setColor(color);
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(startCoordinateX, startCoordinateY, endCoordinateX, endCoordinateY);

	}

	@Override
	public void setPosition(int x, int y) {
		//setPosition() is a method in interface Shape and we need to override it
		//Set Position is not required to be implemented for Line Shape
	}

}
