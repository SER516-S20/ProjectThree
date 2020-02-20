import javax.swing.*;
import java.awt.*;

/**
 * @author Ashutosh Dey
 * @version 1.0
 * @since 01/29/2020
 */
public class SquareIcon implements Icon {
	static final int SQUARE_HEIGHT = 50;
	static final int SQUARE_WIDTH = 50;

	public int getIconWidth() {
		return 0;
	}

	public int getIconHeight() {
		return 0;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int positionDeviation = 25;
		Square square = new Square();
		square.setColor(Color.BLUE);
		square.setPosition(x - positionDeviation, y - positionDeviation);
		square.draw(g, false, SQUARE_HEIGHT, SQUARE_WIDTH);
	}

}
