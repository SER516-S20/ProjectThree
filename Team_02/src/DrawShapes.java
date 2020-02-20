import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class DrawShapes extends JPanel {
	
	public DrawShapes() {
		
	}
	
//	public void paintAllShapes() {
//		repaint();
//	}
//	
//	@Override
//	public void paintComponent(Graphics graphics) {
//		System.out.println("Inside paint component.....");
//		try {
//			super.paintComponent(graphics);
//			Graphics2D graphicsDimension = (Graphics2D) graphics;
//			graphicsDimension.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//			for(Point p1 : ShapeLocation.squarePoint) {
//				graphicsDimension.drawRect(p1.x, p1.y, 100, 80);
//			}
//			for(Point p1 : ShapeLocation.circlePoint) {
//				graphicsDimension.drawOval(p1.x-40, p1.y-40, 80, 80);
//				graphicsDimension.fillOval(p1.x-3, p1.y-3, 6, 6);
//			}
//			for(Point p1 : ShapeLocation.trianglePoint) {
//				graphicsDimension.drawPolygon(new int[] { p1.x - 40, p1.x, p1.x + 40 },
//						new int[] { p1.y + 40, p1.y - 40, p1.y + 40 }, 3);
//				
//				graphicsDimension.fillOval(p1.x - 4, p1.y - 40 + 8 - 4,
//						8, 8);
//				graphicsDimension.fillOval(p1.x - 40 + 8 - 4,
//						p1.y + 40 - 8 - 4, 8, 8);
//				graphicsDimension.fillOval(p1.x + 40 - 8 - 4,
//						p1.y + 40 - 8 - 4, 8, 8);
//			}
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
}
