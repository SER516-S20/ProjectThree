import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;

/**
 * This class is used to drag a particular shape and create a shape on mouse
 * click
 * 
 * @author Ashutosh Dey
 * @version 1.0
 * @since 01/28/2020
 */
class MouseListener extends MouseInputAdapter {

	private boolean activateDrag = false;

	public void mousePressed(MouseEvent e) {
		Point startPoint = e.getPoint();
		int coordinateX = Math.min(startPoint.x, e.getX());
		int coordinateY = Math.min(startPoint.y, e.getY());
		if (Boundary.checkBoundary(coordinateX, coordinateY)) {
			activateDrag = true;
		} else {
			activateDrag = false;
			if (JButtonActionListener.isSquarePanelClicked) {
				Square square = new Square();
				square.setPosition(coordinateX, coordinateY);
				Frame.drawingArea.addSquare(square);
			} else if (JButtonActionListener.isCirclePanelClicked) {
				Circle circle = new Circle();
				circle.setPosition(coordinateX, coordinateY);
				Frame.drawingArea.addCircle(circle);
			} else if (JButtonActionListener.isTrianglePanelClicked) {
				Triangle triangle = new Triangle();
				triangle.setPosition(coordinateX, coordinateY);
				Frame.drawingArea.addTriangle(triangle);
			} else {
				JOptionPane.showMessageDialog(null, "Please select a shape");
			}
		}
	}

	public void mouseDragged(MouseEvent event) {
		int coordinateX = event.getX();
		int coordinateY = event.getY();

		Dots dots = new Dots();
		Connections connections = new Connections();
		Relocate relocate = new Relocate();

		if (activateDrag && !Dots.lineDrag) {

			Object object = Boundary.selectedObject;
			if (object instanceof Square) {
				Square square = (Square) object;
				if (!dots.isBarInSquare(square, coordinateX, coordinateY)) {
					square.setPosition(coordinateX, coordinateY);
					relocate.updateLinesDrawnToSquare(square);
					Frame.drawingArea.repaintOnDrag();
				}
			} else if (object instanceof Circle) {
				Circle circle = (Circle) object;
				if (!dots.isDotInCircle(circle, coordinateX, coordinateY)) {
					circle.setPosition(coordinateX, coordinateY);
					relocate.updateLinesDrawnToCircle(circle, circle.dot.getCoordinateX(), circle.dot.getCoordinateY());
					Frame.drawingArea.repaintOnDrag();
				}
			} else if (object instanceof Triangle) {
				Triangle triangle = (Triangle) object;
				if (!dots.isDotInTriangle(triangle, coordinateX, coordinateY)) {
					triangle.setPosition(coordinateX, coordinateY);
					relocate.updateLinesDrawnToTriangle(triangle);
					Frame.drawingArea.repaintOnDrag();
				}
			}
		}

		if (Dots.lineDrag && !connections.isConnected(coordinateX, coordinateY)) {
			Dots.currentLineObject.setLinePosition(Dots.currentLineObject.startCoordinateX,
					Dots.currentLineObject.startCoordinateY, coordinateX, coordinateY);
			Frame.drawingArea.addLine(Dots.currentLineObject);
		}
	}

}