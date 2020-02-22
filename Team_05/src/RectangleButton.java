import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * This class can draw and create rectangle button.
 * @author KaiRui Hsu, Hongqi Zhang
 * @since 01/26/2020 version 1.0
 * @modified 2/20/2020 by Hongqi Zhang
 */
public class RectangleButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Shape rectangle;
	private Color foreground = new Color(178, 255, 102);
	private Color background = new Color(0, 255, 255);
	private Dimension size;
	private Point []points = new Point[4];
	
	public RectangleButton(String label) {
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
	}

	protected void paintComponent(Graphics g) {
		if(getModel().isArmed()) {
			g.setColor(background);
		}else {
			g.setColor(foreground);
		}
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillRect(0, 0, getSize().width, getSize().height);	
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(this.getForeground());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		/*  the "-1" to make sure the right vertical line and bottom horizontal line can be drew */
		g2d.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		Stroke stroke = new BasicStroke(2f);
		g2d.setStroke(stroke);
		
		Point topLeft = new Point(getSize().width / 5, getSize().height / 5);
		Point botLeft = new Point(getSize().width / 5, getSize().height - getSize().height / 5);
		Point topRight = new Point(getSize().width - getSize().width / 5, getSize().height / 5);
		Point botRight = new Point(getSize().width - getSize().width / 5, 
									getSize().height - getSize().height / 5);
		g2d.drawLine(topLeft.x, topLeft.y, botLeft.x, botLeft.y);
		g2d.drawLine(topRight.x, topRight.y, botRight.x, botRight.y);
		points[0] = topLeft;
		points[1] = botLeft;
		points[2] = topRight;
		points[3] = botRight;
	}

	public boolean contains(int x, int y) {
		if(rectangle == null || !rectangle.getBounds().equals(getBounds())) {
			rectangle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return rectangle.contains(x, y);
	}
	
	/**
	 * points[0] = topLeft dot
	 * points[1] = botLeft dot
	 * points[2] = topRight dot
	 * points[3] = botRight dot
	 * @return four points that represent two vertical line
	 */
	public Point[] getPointsPosition() {
		return points;
	}
}

