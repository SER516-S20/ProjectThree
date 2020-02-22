import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author abhinaw sarang
 * @created on 01-27-2020
 * @version 1.0
 * @author Rohit Kumar Singh
 * @modified on 01-28-2020
 * @version 2.0
 * @author abhinaw sarang
 * @modified on 02-19-2020
 * @version 3.0
 */
public class MouseListener extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String draggedShapeName;
	private String draggedTriangleSide;
	private Boolean isFirstDotSelected = false;
	private Boolean isSecondDotSelected = false;
	private Boolean isLeftBarConnected = false;
	private Boolean isRightBarConnected = false;
	private Point lineStartPoint;
	private Point lineEndPoint;
	private Point prevPoint = new Point();
	private MouseEvent dragStartEvent;

	public MouseListener() {
		this.setPreferredSize(new Dimension(1600, 800));
		this.setVisible(true);
		addMouseListener(new DrawBoardMouseListener());
		addMouseMotionListener(new DrawBoardMouseMotionListener());
	}

	public void restore() {
		repaint();
		JOptionPane.showMessageDialog(null, "Please click on drawing board to reflect clear/load.");
	}

	@Override
	public void paintComponent(Graphics graphics) {
		System.out.println("Inside paint component.....");
		try {
			super.paintComponent(graphics);
			Graphics2D graphicsDimension = (Graphics2D) graphics;
			graphicsDimension.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (isFirstDotSelected && isSecondDotSelected) {
				new Connections(lineStartPoint.x, lineStartPoint.y, lineEndPoint.x,
						lineEndPoint.y);
				isFirstDotSelected = false;
				isSecondDotSelected = false;
			}
			for (Point p1 : ShapeLocation.squarePoint) {
				graphicsDimension.drawRect(p1.x, p1.y, 100, 100);
			}
			for (Point p1 : ShapeLocation.squarebarpoints) {
				graphicsDimension.fillRect(p1.x - 1, p1.y - 40, 2, 80);
			}
			for (Point p1 : ShapeLocation.circlePoint) {
				graphicsDimension.drawOval(p1.x - 40, p1.y - 40, 80, 80);
			}
			for (Point p1 : ShapeLocation.trianglePoint) {
				graphicsDimension.drawPolygon(new int[] { p1.x - 40, p1.x, p1.x + 40 },
						new int[] { p1.y + 40, p1.y - 40, p1.y + 40 }, 3);
			}
			for (Point p : ShapeLocation.dotPoint) {
				graphicsDimension.fillOval(p.x, p.y, 6, 6);
			}
			for (Lineconnection line : ShapeLocation.LinePoint) {
				graphicsDimension.drawLine(line.P1.x, line.P1.y, line.P2.x, line.P2.y);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private class DrawBoardMouseListener extends MouseAdapter {

		private String selectedShapeName = "";
		
		@Override
		public void mouseClicked(MouseEvent event) {
			boolean selectingSecond = isFirstDotSelected;
			List<Point> allPoints = new ArrayList<Point>();
			allPoints.addAll(ShapeLocation.dotPoint);
			allPoints.addAll(ShapeLocation.squarebarpoints);
			for (Point point : ShapeLocation.dotPoint) {
				if (new Rectangle2D.Double(event.getX() - 10, event.getY() - 10, 20, 20).contains(point)) {
					if (!isFirstDotSelected) {
						isFirstDotSelected = true;
						lineStartPoint = point;
					} else {
						isSecondDotSelected = true;
						lineEndPoint = point;
					}
					break;
				}
			}
			for (Point point : ShapeLocation.squarebarpoints) {
				if (new Rectangle2D.Double(event.getX() - 5, event.getY() - 50, 10, 100).contains(point)) {
					if (!isFirstDotSelected) {
						isFirstDotSelected = true;
						lineStartPoint = point;
					} else {
						isSecondDotSelected = true;
						lineEndPoint = point;
					}
					break;
				}
			}
			if (isFirstDotSelected && isSecondDotSelected) {
				repaint();
			} else if ((!isFirstDotSelected) || (selectingSecond && !isSecondDotSelected)) {
				drawSelectedShape(event);
			}
		}

		@Override
		public void mousePressed(MouseEvent event) {
			System.out.println("Inside mouse pressed");
			dragStartEvent = event;
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			try {
				if (draggedShapeName.equalsIgnoreCase("triangle")) {
					drawDraggedTriangle(event);
				} else if (draggedShapeName.equalsIgnoreCase("square")) {
					drawDraggedSquare(event);
				} else if (draggedShapeName.equalsIgnoreCase("circle")) {
					drawDraggedCircle(event);
				}
				draggedShapeName = "";
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			repaint();
		}

		private void drawDraggedCircle(MouseEvent event) {
			ShapeLocation.circlePoint.add(new Point(event.getX(), event.getY()));
			ShapeLocation.dotPoint.add(new Point(event.getX(), event.getY()));
			if (prevPoint.x != 0) {
				Point newDot = new Point(event.getX(), event.getY());
				Lineconnection objLC = new Lineconnection(prevPoint, newDot);
				ShapeLocation.LinePoint.add(objLC);
				prevPoint = null;
			}
		}

		private void drawDraggedSquare(MouseEvent event) {
			ShapeLocation.squarePoint.add(new Point(event.getX(), event.getY()));
			ShapeLocation.squarebarpoints.add(new Point(event.getX() + 5, event.getY() + 50));
			ShapeLocation.squarebarpoints.add(new Point(event.getX() + 95, event.getY() + 50));
			if (prevPoint.x != 0 && isLeftBarConnected) {
				Point newDot = new Point(event.getX() + 5, event.getY() + 50);
				Lineconnection objLC = new Lineconnection(prevPoint, newDot);
				ShapeLocation.LinePoint.add(objLC);
				prevPoint = null;
				isLeftBarConnected = false;
			} else if (prevPoint.x != 0 && isRightBarConnected) {
				Point newDot = new Point(event.getX() + 95, event.getY() + 50);
				Lineconnection objLC = new Lineconnection(prevPoint, newDot);
				ShapeLocation.LinePoint.add(objLC);
				prevPoint = null;
				isRightBarConnected = false;
			}
		}

		private void drawDraggedTriangle(MouseEvent event) {
			ShapeLocation.trianglePoint.add(new Point(event.getX(), event.getY()));
			ShapeLocation.dotPoint.add(new Point(event.getX() - 4, event.getY() - 40 + 8 - 4));
			ShapeLocation.dotPoint.add(new Point(event.getX() - 40 + 8 - 4, event.getY() + 40 - 8 - 4));
			ShapeLocation.dotPoint.add(new Point(event.getX() + 40 - 8 - 4, event.getY() + 40 - 8 - 4));
			if (prevPoint.x != 0) {
				Point newDot = new Point(event.getX(), event.getY());
				if (draggedTriangleSide.equalsIgnoreCase("top")) {
					newDot = new Point(event.getX() - 4, event.getY() - 40 + 8 - 4);
					draggedTriangleSide = "";
				} else if (draggedTriangleSide.equalsIgnoreCase("left")) {
					newDot = new Point(event.getX() - 40 + 8 - 4, event.getY() + 40 - 8 - 4);
					draggedTriangleSide = "";
				} else if (draggedTriangleSide.equalsIgnoreCase("right")) {
					newDot = new Point(event.getX() + 40 - 8 - 4, event.getY() + 40 - 8 - 4);
					draggedTriangleSide = "";
				}
				Lineconnection objLC = new Lineconnection(prevPoint, newDot);
				ShapeLocation.LinePoint.add(objLC);
				prevPoint = null;
			}
		}
		
		private void drawSelectedShape(MouseEvent event) {
			isFirstDotSelected = false;
			isSecondDotSelected = false;
			try {
				selectedShapeName = ClickedShape.shapeName;
				if (selectedShapeName.isEmpty() || (selectedShapeName == null)) {
					System.out.println("selectedShapeName");
					JOptionPane.showMessageDialog(null, "Please select a shape");
				} else {
					int X = event.getX();
					int Y = event.getY();
					if (selectedShapeName.equalsIgnoreCase("triangle")) {
						ShapeLocation.trianglePoint.add((new Point(X, Y)));
						ShapeLocation.dotPoint.add(new Point(X - 4, Y - 40 + 8 - 4));
						ShapeLocation.dotPoint.add(new Point(X - 40 + 8 - 4, Y + 40 - 8 - 4));
						ShapeLocation.dotPoint.add(new Point(X + 40 - 8 - 4, Y + 40 - 8 - 4));
					} else if (selectedShapeName.equalsIgnoreCase("circle")) {
						ShapeLocation.circlePoint.add((new Point(X, Y)));
						ShapeLocation.dotPoint.add(new Point(X - 3, Y - 3));
					} else if (selectedShapeName.equalsIgnoreCase("square")) {
						ShapeLocation.squarePoint.add((new Point(X, Y)));
						ShapeLocation.squarebarpoints.add(new Point(X + 5, Y + 50));
						ShapeLocation.squarebarpoints.add(new Point(X + 95, Y + 50));

					} else {
						System.out.println("Shape not selected");
					}
					repaint();
				}
			} catch (Exception e1) {
				
			}
		}
	}

	private class DrawBoardMouseMotionListener extends MouseMotionAdapter {

		@Override
		public void mouseDragged(MouseEvent event) {
			System.out.println("Inside mouse dragged");
			try {
				for (Point point : ShapeLocation.circlePoint) {
					if (new Rectangle2D.Double(dragStartEvent.getX() - 80, dragStartEvent.getY() - 80, 120, 120)
							.contains(point)) {
						draggedShapeName = "circle";
						ShapeLocation.circlePoint.remove(point);
						break;
					}
				}
				for (Point point : ShapeLocation.trianglePoint) {
					if (new Rectangle2D.Double(dragStartEvent.getX() - 80, dragStartEvent.getY() - 80, 120, 120)
							.contains(point)) {
						draggedShapeName = "triangle";
						ShapeLocation.trianglePoint.remove(point);
						break;
					}
				}
				for (Point point : ShapeLocation.squarePoint) {
					if (new Rectangle2D.Double(dragStartEvent.getX() - 80, dragStartEvent.getY() - 80, 120, 120)
							.contains(point)) {
						draggedShapeName = "square";
						ShapeLocation.squarePoint.remove(point);
						break;
					}
				}

				for (Point point : ShapeLocation.dotPoint) {
					if (new Rectangle2D.Double(dragStartEvent.getX() - 80, dragStartEvent.getY() - 80, 160, 160)
							.contains(point)) {
						System.out.println("Removing point " + point);
						ShapeLocation.dotPoint.remove(point);
						removeConnectedLine(point);
					}
				}
				for (Point point : ShapeLocation.squarebarpoints) {
					if (new Rectangle2D.Double(dragStartEvent.getX() - 100, dragStartEvent.getY() - 100, 200, 200)
							.contains(point)) {
						System.out.println("Removing point from circle" + point);
						ShapeLocation.squarebarpoints.remove(point);
						removeConnectedLines(point);
					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		private void removeConnectedLines(Point point) {
			for (Lineconnection lc : ShapeLocation.LinePoint) {
				if (lc.P1.equals(point)) {
					prevPoint = lc.P2;
					ShapeLocation.LinePoint.remove(lc);
					if (dragStartEvent.getX() > point.x) {
						isLeftBarConnected = true;
					} else {
						isRightBarConnected = true;
					}
					break;
				} else if (lc.P2.equals(point)) {
					prevPoint = lc.P1;
					ShapeLocation.LinePoint.remove(lc);
					if (dragStartEvent.getX() > point.x) {
						isLeftBarConnected = true;
					} else {
						isRightBarConnected = true;
					}
					break;
				}
			}
		}

		private void removeConnectedLine(Point point) {
			for (Lineconnection lc : ShapeLocation.LinePoint) {
				if (lc.P1.equals(point)) {
					prevPoint = lc.P2;
					ShapeLocation.LinePoint.remove(lc);
					if (draggedShapeName.equalsIgnoreCase("triangle")) {
						if (point.x < dragStartEvent.getX() && point.y > dragStartEvent.getY()) {
							draggedTriangleSide = new String("left");
						} else if (point.x > dragStartEvent.getX() && point.y > dragStartEvent.getY()) {
							draggedTriangleSide = new String("right");
						} else if (point.y < dragStartEvent.getY()) {
							draggedTriangleSide = new String("top");
						}
						break;
					}
				} else if (lc.P2.equals(point)) {
					prevPoint = lc.P1;
					ShapeLocation.LinePoint.remove(lc);
					if (draggedShapeName.equalsIgnoreCase("triangle")) {
						if (point.x < dragStartEvent.getX() && point.y > dragStartEvent.getY()) {
							draggedTriangleSide = new String("left");
						} else if (point.x > dragStartEvent.getX() && point.y > dragStartEvent.getY()) {
							draggedTriangleSide = new String("right");
						} else if (point.y < dragStartEvent.getY()) {
							draggedTriangleSide = new String("top");
						}
						break;
					}
				}
			}
		}
	}
}