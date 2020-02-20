import javax.swing.*;
import java.awt.*;

/**
 * @author Ashutosh Dey
 * @version 1.0
 * @since 01/27/2020
 */
public class CircleIcon implements Icon {

	public int getIconWidth() {
		return 0;
	}

	public int getIconHeight() {
		return 0;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int positionDeviation = 25;
		Circle circle = new Circle();
		circle.setColor(Color.RED);
		circle.setPosition(x - positionDeviation, y - positionDeviation);
		circle.draw(g, false, DrawingArea.CIRCLE_WIDTH, DrawingArea.CIRCLE_HEIGHT);
	}

}
