/**
 * Connections.java - a class for connecting lines on drag from one dot in(circle,triangle)  
 * to another dot(circle,triangle) or bar in square
 * 
 * @author Ashwin Srinivasan
 * @version 1.1
 *
 */
public class Connections {

	public boolean isConnectedToCircle(Object object, Line line) {
		Circle circle = (Circle) object;
		if (!Boundary.polygonCheck(circle.getCoordinateX(), circle.getCoordinateY(),
				circle.getCoordinateX() + DrawingArea.CIRCLE_WIDTH, circle.getCoordinateY() + DrawingArea.CIRCLE_HEIGHT,
				Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY)
				&& !circle.isLineDrawn) {
			Dots.initCircle.setIsLineDrawn(true);
			circle.setIsLineDrawn(true);

			line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
					circle.dot.getCoordinateX(), circle.dot.getCoordinateY());

			return true;
		}
		return false;
	}

	public boolean isConnectedToSquare(Object object, Line line, int coordinateX, int coordinateY) {

		Square square = (Square) object;
		if (!Boundary.polygonCheck(square.getCoordinateX(), square.getCoordinateY(),
				square.getCoordinateX() + DrawingArea.SQUARE_WIDTH, square.getCoordinateY() + DrawingArea.SQUARE_HEIGHT,
				Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY)) {

			Square bar1 = square.bar1;
			Square bar2 = square.bar2;

			if (Boundary.polygonCheck(bar1.getCoordinateX(), bar1.getCoordinateY(),
					bar1.getCoordinateX() + Square.BAR_WIDTH, bar1.getCoordinateY() + Square.BAR_HEIGHT, coordinateX,
					coordinateY)) {

				line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
						bar1.getCoordinateX(), bar1.getCoordinateY());

				return true;

			}

			else if (Boundary.polygonCheck(bar2.getCoordinateX(), bar2.getCoordinateY(),
					bar2.getCoordinateX() + Square.BAR_WIDTH, bar2.getCoordinateY() + Square.BAR_HEIGHT, coordinateX,
					coordinateY)) {

				line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
						bar2.getCoordinateX(), bar2.getCoordinateY());

				return true;

			}

		}
		return false;
	}

	public boolean isConnectedToTriangle(Object object, Line line, int coordinateX, int coordinateY) {
		Triangle triangle = (Triangle) object;
		if (!Boundary.polygonCheck(triangle.getCoordinateX() - DrawingArea.TRIANGLE_SIZE, triangle.getCoordinateY(),
				triangle.getCoordinateX() + DrawingArea.TRIANGLE_SIZE,
				triangle.getCoordinateY() + DrawingArea.TRIANGLE_SIZE, Dots.currentLineObject.startCordinateX,
				Dots.currentLineObject.startCordinateY)) {

			Circle dot1 = (Circle) triangle.dot1;
			Circle dot2 = (Circle) triangle.dot2;
			Circle dot3 = (Circle) triangle.dot3;

			if (Boundary.polygonCheck(dot1.getCoordinateX(), dot1.getCoordinateY(),
					dot1.getCoordinateX() + dot1.DOT_WIDTH, dot1.getCoordinateY() + dot1.DOT_HEIGHT, coordinateX,
					coordinateY) && !dot1.isLineDrawn) {

				dot1.setIsLineDrawn(true);
				line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
						dot1.getCoordinateX(), dot1.getCoordinateY());
				Dots.initCircle.setIsLineDrawn(true);
				return true;

			}

			else if (Boundary.polygonCheck(dot2.getCoordinateX(), dot2.getCoordinateY(),
					dot2.getCoordinateX() + dot2.DOT_WIDTH, dot1.getCoordinateY() + dot2.DOT_HEIGHT, coordinateX,
					coordinateY) && !dot2.isLineDrawn) {

				dot2.setIsLineDrawn(true);
				line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
						dot2.getCoordinateX(), dot2.getCoordinateY());
				Dots.initCircle.setIsLineDrawn(true);
				return true;

			}

			else if (Boundary.polygonCheck(dot3.getCoordinateX(), dot3.getCoordinateY(),
					dot3.getCoordinateX() + dot3.DOT_WIDTH, dot3.getCoordinateY() + dot3.DOT_HEIGHT, coordinateX,
					coordinateY) && !dot3.isLineDrawn) {

				dot3.setIsLineDrawn(true);
				line.setLinePosition(Dots.currentLineObject.startCordinateX, Dots.currentLineObject.startCordinateY,
						dot3.getCoordinateX(), dot3.getCoordinateY());
				Dots.initCircle.setIsLineDrawn(true);
				return true;

			}

		}
		return false;
	}
    /*
     * Check whether a line already exists from a dot and if no draw a line on drag
     */
	public boolean isConnected(int coordinateX, int coordinateY) {
		boolean result = false;
		Line line = new Line();
		if (Boundary.checkBoundary(coordinateX, coordinateY)) {
			Object object = Boundary.selectedObject;
			if (object instanceof Circle) {
				result = isConnectedToCircle(object, line);


			} else if (object instanceof Triangle) {
				result = isConnectedToTriangle(object, line, coordinateX, coordinateY);
			} else if (object instanceof Square) {
				result = isConnectedToSquare(object, line, coordinateX, coordinateY);
			}

		}
		if (result) {
			
			Dots.lineDrag = false;
			Boundary.selectedObject = null;
			Frame.drawingArea.addLine(line);
			return result;
		}

		return false;
	}

}
