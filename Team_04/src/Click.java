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
	private static Point point1;
	private static Point point2;

	public Click(int x, int y, DrawShape shape) {
		if (numPoints == 0) {
			numPoints += 1;
			point1 = new Point(x, y);
			Point relative = new Point(x - shape.positionX, y - shape.positionY);
			Point[] shapePoints = { point1, relative };
			shape.connections.add(shapePoints);
		} else {
			point2 = new Point(x, y);
			Point[] points = { point1, point2 };
			Point relative = new Point(x - shape.positionX, y - shape.positionY);
			Point[] shapePoints = { point2, relative };
			shape.connections.add(shapePoints);
			shape.canvas.lineArray.add(points);
			shape.canvas.repaint();
			numPoints = 0;
		}
	}

}