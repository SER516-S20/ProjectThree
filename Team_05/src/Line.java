/**
 * @author ShihYu Chang
 */
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;
import java.awt.geom.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Line extends JPanel{
	private static int sourceX, sourceY, destX, destY;
	public void setSource(int tsourceX, int tsourceY) {
		sourceX = tsourceX;
		sourceY = tsourceY;
	}
	public void setDest(int tdestX, int tdestY) {
		destX = tdestX;
		destY = tdestY;
	}
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawLine(sourceX,sourceY,destX,destY);
	}
}
