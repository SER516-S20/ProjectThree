import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author Rohith Varma Gaddam
 * @since 01-27-2020
 * @version 1.0
 */
public class Circle extends JButton {
	private SelectionEvent event;
	private static Icon label;

	public Circle() {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = 100;
		setPreferredSize(size);
		setContentAreaFilled(false);
		event = new SelectionEvent(this, "circle");
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(50, 0, getSize().height - 1, getSize().height - 1);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(50, 0, getSize().height - 1, getSize().height - 1);
	}
}