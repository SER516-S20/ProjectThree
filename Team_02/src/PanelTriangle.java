import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Suryadeep
 * @created on 01-28-2020
 * @version 1.0
 * @author Abhinaw
 * @updated on 02-16-2020
 * @version 2.0
 */
public class PanelTriangle extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int X = 120;
	public static final int Y = 100;

	public PanelTriangle() {
		addMouseListener(new PanelMouseListener());
		JPanel objTrianglePane = new JPanel();
		repaint();
		objTrianglePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		objTrianglePane.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			int topX = X;
			int topY = Y - 40;
			int leftX = X - 40;
			int leftY = Y + 40;
			int rightX = X + 40;
			int rightY = Y + 40;
			int dotDiameter = (leftY - topY) / 10;
			int dotToCornerDistance = (leftY - topY) / 10;
			int dotRadius = (leftY - topY) / 20;

			Path2D path = new Path2D.Double();
			path.moveTo(topX, topY);
			path.lineTo(leftX, leftY);
			path.lineTo(rightX, rightY);
			path.closePath();
			Graphics2D obj2D = (Graphics2D) objGraphics;
			obj2D.draw(path);
			obj2D.fillOval(topX - dotRadius, topY + dotToCornerDistance - dotRadius, dotDiameter, dotDiameter);
			obj2D.fillOval(leftX + dotToCornerDistance - dotRadius, leftY - dotToCornerDistance - dotRadius,
					dotDiameter, dotDiameter);
			obj2D.fillOval(rightX - dotToCornerDistance - dotRadius, rightY - dotToCornerDistance - dotRadius,
					dotDiameter, dotDiameter);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private class PanelMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			ClickedShape objClickedShape = new ClickedShape();
			objClickedShape.returnShape("Triangle");
		}
	}
}
