import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line implements Shape {
	private Color color;
	public int startCordinateX;
	public int startCordinateY;

	public int endCordinateX;
	public int endCordinateY;

	@Override
	public void setLinePosition(int startCordinateX, int startCordinateY, int endCordinateX, int endCordinateY) {
		this.startCordinateX = startCordinateX;
		this.startCordinateY = startCordinateY;

		this.endCordinateX = endCordinateX;
		this.endCordinateY = endCordinateY;

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
		g2.drawLine(startCordinateX, startCordinateY, endCordinateX, endCordinateY);

	}

	@Override
	public void setPosition(int x, int y) {

	}

}
