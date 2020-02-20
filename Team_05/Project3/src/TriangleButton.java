import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * this class implement the customer triangle button
 * @author Hongqi Zhang
 */ 
public class TriangleButton extends JButton{

	private static final long serialVersionUID = 1L;
	private Shape triangle;
	private Color foreground = new Color(178, 255, 102);
	private Color background = new Color(0, 255, 255);
	private Dimension size;
	
	public TriangleButton(String label) {
		super(label);
		size = getPreferredSize();
		size.width = size.height = Math.max(size.width,size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		triangle = createTriangle();
	}

	protected void paintComponent(Graphics g) {
		if(getModel().isArmed()) {
			g.setColor(background);
		}else {
			g.setColor(foreground);
		}
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(triangle);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(this.getForeground());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.draw(triangle);
		Stroke stroke = new BasicStroke(4f);
		g2d.setStroke(stroke);
		g2d.drawLine(15, size.height - 1 - 10, 15, size.height - 1 - 10);
		g2d.drawLine((size.width - 1) / 2, 15, (size.width - 1) / 2, 15);
		g2d.drawLine(size.width - 1 - 15, size.height - 1 - 10, size.width - 1 - 15, size.height - 1 - 10);
	}

	public boolean contains(int x, int y) {
		return triangle.contains(x, y);
	}
	
	private Shape createTriangle() {
        Polygon p = new Polygon();
        p.addPoint((size.width - 1) / 2, 0);
        p.addPoint(0, size.height - 1);
        p.addPoint(size.width - 1, size.height - 1);
        return p;
	}
	
	public Point[] getPointsCoordinate() {
		Point top = new Point((size.width - 1) / 2, 15);
		Point left = new Point(15, size.height - 1 - 10);
		Point right = new Point(size.width - 1 - 15, size.height - 1 - 10);
		Point []points = new Point[3];
		points[0] = top;
		points[1] = left;
		points[2] = right;
		return points;
	}
}
