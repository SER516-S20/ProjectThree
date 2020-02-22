/**
 * @author ShihYu Chang
 */
//for line connection, but not finished yet.
import java.awt.*;
import java.awt.geom.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
public class Line extends JButton{
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color foreground = new Color(0, 0, 0);
	private Color background = new Color(0, 0, 0);
	public Line(String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = 10000;
		size.height = 10000;
		setPreferredSize(size);
		setContentAreaFilled(false);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
	}

	protected void paintComponent(Graphics g) {
		RightPanel rightpanel = new RightPanel();
		int x = 0; 
		int y = 0;
		int dy = 0;
		int dx = 0;
		if(getModel().isArmed()) {
			g.setColor(background);
		}else {
			g.setColor(foreground);
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(x, y, dx, dy));
		super.paintComponent(g);
	}
}
