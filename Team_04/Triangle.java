import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 * @author Rohith Varma Gaddam
 * @since 01-27-2020
 * @version 1.0
 */
public class Triangle extends JButton {
	private SelectionEvent event;
	private static Icon label;

	public Triangle() {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = 100;
		setPreferredSize(size);
		setContentAreaFilled(false);
		event = new SelectionEvent(this, "triangle");
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		int xPoints[] = { getSize().width / 2, 30, getSize().width - 30 };
		int yPoints[] = { 10, getSize().height - 11, getSize().height - 11 };
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		int xPoints[] = { getSize().width / 2, 30, getSize().width - 30 };
		int yPoints[] = { 10, getSize().height - 11, getSize().height - 11 };
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
}