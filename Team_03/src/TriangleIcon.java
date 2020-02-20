import javax.swing.*;
import java.awt.*;

/**
 * @author Ashutosh Dey
 * @version 1.0
 * @since 01/29/2020
 */
public class TriangleIcon implements Icon {

	public int getIconWidth() {
		return 0;
	}

	public int getIconHeight() {
		return 0;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int positionDeviation = 0;
		Triangle triangle = new Triangle();
		triangle.setColor(Color.BLACK);
		triangle.setPosition(x - positionDeviation, y - positionDeviation);
		triangle.draw(g, false, DrawingArea.TRIANGLE_SIZE, DrawingArea.TRIANGLE_SIZE);
	}

}
