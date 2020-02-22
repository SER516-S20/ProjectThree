import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author ShihYu Chang
 */
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
		// TODO Auto-generated method stub
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

	@Override
	public void mousePressed(MouseEvent e) {
		Component btn = e.getComponent();
		String className = e.getSource().getClass().getName();
		if(className.equals("TriangleButton")) {
			TriangleButton triangle = (TriangleButton) btn;
			Point []points = triangle.getPointsPosition();
			for(int i = 0; i < points.length; i++) {
				System.out.println("triangle: " + points[i]);
			}
		}else if(className.equals("RoundButton")) {
			RoundButton round = (RoundButton) btn;
			System.out.println("round: " + round.getCenterPoint());
		}else if(className.equals("RectangleButton")) {
			RectangleButton rect = (RectangleButton) btn;
			Point []points = rect.getPointsPosition();
			for(int i = 0; i < points.length; i++) {
				System.out.println("rect: " + points[i]);
			}
		}
		currentX = e.getX();
		currentY = e.getY();
		if(e.getButton() == MouseEvent.BUTTON3) {
			rightPanel.deleteShape(e.getComponent().hashCode());
		}
	}
			
}
