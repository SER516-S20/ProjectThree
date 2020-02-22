/**
 * @author ShihYu Chang
 */
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class Line extends JButton{
	private static final long serialVersionUID = 1L;
	private Color foreground = new Color(0, 0, 0);
	private Color background = new Color(0, 0, 0);
	public Line(String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = 1000;
		size.height = 1000;
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
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		super.paintComponent(g);
	}
}
