
import javax.swing.*;
import java.awt.*;

/**
 * @author srinivasan sundar
 * @since 01/26/2020
 * @version 1.0
 */
public class ShapePanel extends JPanel {

	private static final int BUTTON_WIDTH = 190;
	private static final int BUTTON_HEIGHT = 190;
	static JButton circleButton, squareButton, triangleButton;

	ShapePanel() {
		this.setLayout(new BorderLayout());
		this.add(constructCircle(), BorderLayout.NORTH);
		this.add(constructSquare(), BorderLayout.CENTER);
		this.add(constructTriangle(), BorderLayout.SOUTH);
		addIconsToPanel();
		new JButtonActionListener().addActionListener();
	}

	private static JButton constructCircle() {
		circleButton = new JButton();
		circleButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		circleButton.setBackground(Color.GRAY);
		circleButton.setOpaque(true);
		return circleButton;
	}

	private static JButton constructSquare() {
		squareButton = new JButton();
		squareButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		squareButton.setBackground(Color.GRAY);
		squareButton.setOpaque(true);
		return squareButton;
	}

	private static JButton constructTriangle() {
		triangleButton = new JButton();
		triangleButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		triangleButton.setBackground(Color.GRAY);
		triangleButton.setOpaque(true);
		return triangleButton;
	}

	public void addIconsToPanel() {
		circleButton.setIcon(new CircleIcon());
		triangleButton.setIcon(new TriangleIcon());
		squareButton.setIcon(new SquareIcon());
	}

}
