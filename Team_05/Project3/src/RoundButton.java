import java.awt.*;
import java.awt.geom.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * this class implement the customer round button
 * @author Hongqi Zhang
 */ 
public class RoundButton extends JButton{

	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color foreground = new Color(178, 255, 102);
	private Color background = new Color(0, 255, 255);
	
	public RoundButton(String label) {
		super(label);
		Dimension size = getPreferredSize();
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
		g.fillOval(0, 0, getSize().width - 1,getSize().height - 1);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(this.getForeground());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(0, 0, getSize().width - 1,     getSize().height - 1);
		Stroke stroke = new BasicStroke(4f);
		g2d.setStroke(stroke);
		g2d.drawLine((getSize().width - 1) / 2, (getSize().height - 1) / 2,
				(getSize().width - 1) / 2, (getSize().height -1) / 2);
	}

	public boolean contains(int x, int y) {
		if(shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
}
