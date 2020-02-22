/**
 * @author ShihYu Chang
 */
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class RightPanelMouse implements MouseListener, MouseMotionListener {
	private int currentX;
	private int currentY;
	private RightPanel rightPanel;
	public RightPanelMouse(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Component btn = e.getComponent();
		String className = e.getSource().getClass().getName();
		Point points[] = null;
		if(className.equals("TriangleButton")) {
			TriangleButton triangle = (TriangleButton) btn;
			points = triangle.getPointsPosition();
		}
		else if(className.equals("RoundButton")) {
			RoundButton round = (RoundButton) btn;	
		}
		else if(className.equals("RectangleButton")) {
			RectangleButton rect = (RectangleButton) btn;
			points = rect.getPointsPosition();
		}
		addLine(points);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getX() + e.getComponent().getX() - currentX, 
				 					 e.getY() + e.getComponent().getY() - currentY);
		
	}
	public void mousePressed(MouseEvent e) {
		currentX = e.getX();
		currentY = e.getY();
		if(e.getButton() == MouseEvent.BUTTON3) {
			rightPanel.deleteShape(e.getComponent().hashCode());
		}
	}
	//not finished yet
	public void addLine(Point[] points) {
		Line line = new Line("");
	}
}
