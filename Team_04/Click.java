import java.awt.Graphics;
import java.awt.Point;
/**
 * 
 * @author Rohith Varma Gaddam
 * @since 02-16-2020
 *
 */
public class Click {
	private static int numPoints = 0;
	static int x1;
	static int x2;
	static int y1;
	static int y2;
	static DrawShape shape1;
	static DrawShape shape2;
	static Point p1;
	static Point p2;

	public Click(int x, int y, DrawShape shape) {
		if (numPoints == 0) {
			x1 = x;
			y1 = y;
			numPoints += 1;
			shape1 = shape;
			p1 = new Point(x1, y1);
			Point relative = new Point(x1 - shape.positionX, y1 - shape.positionY);
			Point[] shapePoints = { p1, relative };
			shape.connections.add(shapePoints);
		} else {
			shape2 = shape;
			x2 = x;
			y2 = y;

			p2 = new Point(x2, y2);
			Point[] points = { p1, p2 };

			Point relative = new Point(x2 - shape.positionX, y2 - shape.positionY);
			Point[] shapePoints = { p2, relative };
			shape.connections.add(shapePoints);

			shape.canvas.lineArray.add(points);
			shape.canvas.repaint();
			numPoints = 0;
		}
	}

}