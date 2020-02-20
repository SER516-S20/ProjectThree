/**
 * returns true if  the coordinates clicked  are within a dot in circle,triangle 
 *  or if the click is inside a bar in square.
 * 
 * @author Ashutosh Dey
 * @version 1.1
 *
 */

public class Dots {

	static boolean lineDrag = false;
	static Line currentLineObject;
	static Circle initCircle;

	public boolean isInsideDot(Circle dot, int cordinateX, int cordinateY) {
		return Boundary.polygonCheck(dot.getCoordinateX(), dot.getCoordinateY(), dot.getCoordinateX() + dot.DOT_WIDTH,
				dot.getCoordinateY() + dot.DOT_HEIGHT, cordinateX, cordinateY);
	}

	public boolean isDotInCircle(Circle circle, int cordinateX, int cordinateY) {
		lineDrag = false;
		Circle dot = (Circle) circle.dot;
		if (!circle.isLineDrawn && isInsideDot(dot, cordinateX, cordinateY)) {
			lineDrag = true;
			initCircle = circle;
			currentLineObject = new Line();
			currentLineObject.setLinePosition(cordinateX, cordinateY, cordinateX + 5, cordinateY + 5);
			return true;
		}
		return false;
	}

	public boolean isDotInTriangle(Triangle triangle, int cordinateX, int cordinateY) {
		lineDrag = false;
		Circle dot1 = (Circle) triangle.dot1;
		Circle dot2 = (Circle) triangle.dot2;
		Circle dot3 = (Circle) triangle.dot3;
		boolean result = false;

		if (!dot1.isLineDrawn && isInsideDot(dot1, cordinateX, cordinateY)) {
			initCircle = dot1;
			result = true;
		} else if (!dot2.isLineDrawn && isInsideDot(dot2, cordinateX, cordinateY)) {
			initCircle = dot2;
			result = true;
		} else if (!dot3.isLineDrawn && isInsideDot(dot3, cordinateX, cordinateY)) {
			initCircle = dot3;
			result = true;
		}
		if (result) {
			lineDrag = true;
			currentLineObject = new Line();
			currentLineObject.setLinePosition(cordinateX, cordinateY, cordinateX + 5, cordinateY + 5);
			return result;
		}
		return result;
	}

	public boolean isInsideBar(Square square, int cordinateX, int cordinateY) {
		return Boundary.polygonCheck(square.getCoordinateX(), square.getCoordinateY(),
				square.getCoordinateX() + Square.BAR_WIDTH, square.getCoordinateY() + Square.BAR_HEIGHT, cordinateX,
				cordinateY);
	}

	public boolean isBarInSquare(Square square, int cordinateX, int cordinateY) {
		lineDrag = false;
		Square bar1 = square.bar1;
		Square bar2 = square.bar2;
		boolean result = false;
		
		if (isInsideBar(bar1, cordinateX, cordinateY) || isInsideBar(bar2, cordinateX, cordinateY)) {
			result = true;
		}
		if (result) {
			lineDrag = true;
			currentLineObject = new Line();
			currentLineObject.setLinePosition(cordinateX, cordinateY, cordinateX + 5, cordinateY + 5);
			return result;
		}
		return result;
	}

}
