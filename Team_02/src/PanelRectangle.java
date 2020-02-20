import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Suryadeep
 * @created on 01-27-2020
 * @version 1.0
 * @author Rohit
 * @modified on 02-19-2020
 * @version 2.0
 */
public class PanelRectangle extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelRectangle() {

		addMouseListener(new PanelMouseListener());
		JPanel objRectanglePane = new JPanel();
		repaint();
		objRectanglePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		objRectanglePane.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objRectangle = new Rectangle(105, 60, 100, 80);
			obj2D.draw(objRectangle);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private class PanelMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			ClickedShape objClickedShape = new ClickedShape();
			objClickedShape.returnShape("Rectangle");
		}
	}
}
