import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author somesh
 * @since 02-18-2020
 */
public class SelectShape {
	public void select(JButton shape, int shapeNumber) {
		
		shape.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e){
		        if (shape.isEnabled()){
		        	RightPanel.getInstance().shapeNumber = shapeNumber;
		        }				
			}
		});
	}
	
	public void release(JPanel rightPanel) {
		rightPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				JButton shape = new JButton();
				int shapeNumber = RightPanel.getInstance().shapeNumber;
				
				RightPanel.getInstance().points.add(new Point(e.getX(), e.getY()));
				
				Object rp = e.getComponent();
				
				if (shapeNumber == 1) {
					shape = new Triangle("", e.getX(), e.getY(), true);
					RightPanel.getInstance().circlePoints.add(new Point( e.getX(), e.getY()));
				}
				if (shapeNumber == 2) {
					shape = new Circle("", e.getX(), e.getY(), true);
					RightPanel.getInstance().circlePoints.add(new Point( e.getX(), e.getY()));
				}
				if (shapeNumber == 3) {
					shape = new Square("", e.getX(), e.getY(), true);
					RightPanel.getInstance().squarePoints.add(new Point( e.getX(), e.getY()));
				}
				
				((RightPanel) rp).add(shape);
				((RightPanel) rp).repaint();
			}					
		});
	}
}
