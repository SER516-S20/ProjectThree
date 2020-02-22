import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;


/** 
 * @author somesh
 * @since 02-28-2020
 */

public class DrawLine{
	
	int objectX = 0; 
	int objectY = 0;
	
	int mouseX = 0;
	int mouseY = 0;
	
	static boolean selected = false;
	
	DrawLine(JButton lineObject){
		lineObject.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e){
				
				objectX = e.getXOnScreen();
				objectY = e.getYOnScreen();
				mouseX = lineObject.getX();
				mouseY = lineObject.getY();
			}

			@Override
			public void mousePressed(MouseEvent e) {	
			}

			@Override
			public void mouseReleased(MouseEvent e){
			}

			@Override
			public void mouseEntered(MouseEvent e){
			}

			@Override
			public void mouseExited(MouseEvent e){
			}

		});
		
		RightPanel.getInstance().addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - objectX;
				int deltaY = e.getYOnScreen() - objectY;
				
				Object rp = e.getComponent();
				((RightPanel) rp).startX = mouseX; 
				((RightPanel) rp).startY = mouseY; 
				((RightPanel) rp).endX = deltaX; 
				((RightPanel) rp).endY = deltaY; 
				((RightPanel) rp).repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e){
			}
		});
	}
}
