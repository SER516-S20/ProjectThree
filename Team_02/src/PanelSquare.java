import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Sarvansh Prasher
 * @created on 01-27-2020
 * @version 1.0
 * @author Suryadeep
 * @modified on 01-28-2020
 * @version 2.0
 * @author Sarvansh Prasher
 * @modified on 17th Feb 2020
 * @version 3.0
 */
public class PanelSquare extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelSquare() {

		addMouseListener(new PanelMouseListener());
		JPanel objSquarePane = new JPanel();
		repaint();
		objSquarePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		objSquarePane.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objSquare = new Rectangle(105, 60, 80, 80);
			Shape bar = new Line2D.Double(110, 70, 110, 130);
			Shape secondBar = new Line2D.Double(180, 70, 180, 130);
			obj2D.draw(objSquare);
			obj2D.draw(bar);
			obj2D.draw(secondBar);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private class PanelMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			ClickedShape objClickedShape = new ClickedShape();
			objClickedShape.returnShape("Square");
		}
	}
}
