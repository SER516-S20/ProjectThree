import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Relocate.java - a class for resizing the lines drawn between shapes (circle,
 * triangle, square) on drag
 * 
 * @author Nachiappan Lakshmanan
 * @version 1.1
 *
 */
public class Relocate {

	static final int LINE_START_KEY = 0;
	static final int LINE_END_KEY = 1;

	static final int TRIANGLE_DOT_ONE_INDEX = 0;
	static final int TRIANGLE_DOT_TWO_INDEX = 1;
	static final int TRIANGLE_DOT_THREE_INDEX = 2;

	static final int TOTAL_LINE_AXIS = 2;
	static final int TOTAL_BARS_IN_SQUARE = 2;
	static final int TOTAL_DOTS_IN_TRIANGLE = 3;

	/*
	 * Check whether a line is inside the circle
	 */
	public void isLineInsideCircle(Line line, Circle circle, Map<Integer, List<Line>> mapLines) {
		if (Boundary.polygonCheck(circle.getCoordinateX(), circle.getCoordinateY(),
				circle.getCoordinateX() + DrawingArea.CIRCLE_WIDTH, circle.getCoordinateY() + DrawingArea.CIRCLE_HEIGHT,
				line.startCoordinateX, line.startCoordinateY)) {
			mapLines.get(LINE_START_KEY).add(line);

		} else if (Boundary.polygonCheck(circle.getCoordinateX(), circle.getCoordinateY(),
				circle.getCoordinateX() + DrawingArea.CIRCLE_WIDTH, circle.getCoordinateY() + DrawingArea.CIRCLE_HEIGHT,
				line.endCoordinateX, line.endCoordinateY)) {
			mapLines.get(LINE_END_KEY).add(line);
		}
	}

	/*
	 * Find all the lines connecting to the cicle
	 */
	public Map<Integer, List<Line>> findLinesConnectingToCircle(Circle circle) {
		Map<Integer, List<Line>> mapLines = new HashMap<>();
		for (int i = 0; i < TOTAL_LINE_AXIS; i++) {
			List<Line> temp = new ArrayList<>();
			mapLines.put(i, temp);
		}
		for (int i = 0; i < DrawingArea.listOfShapes.size(); i++) {
			Object object = DrawingArea.listOfShapes.get(i);
			if (object instanceof Line) {
				Line line = (Line) object;
				isLineInsideCircle(line, circle, mapLines);
			}
		}
		return mapLines;

	}

	/*
	 * update the co-ordinates of the line drawn from and to circle
	 */
	public void updateLinesDrawnToCircle(Circle circle, int cordinateX, int cordinateY) {
		Map<Integer, List<Line>> lines = findLinesConnectingToCircle(circle);
		for (Integer key : lines.keySet()) {
			for (Line line : lines.get(key)) {
				if (key == LINE_START_KEY) {
					line.setLinePosition(cordinateX, cordinateY, line.endCoordinateX, line.endCoordinateY);
				} else {
					line.setLinePosition(line.startCoordinateX, line.startCoordinateY, cordinateX, cordinateY);
				}
			}
		}

	}

	/*
	 * Check whether a line is inside triangle
	 */
	public void isLineInsideTriangle(Line line, Triangle triangle, Map<Integer, Map<Integer, List<Line>>> mapLines) {
		Circle dot1 = triangle.dot1;
		Circle dot2 = triangle.dot2;
		Circle dot3 = triangle.dot3;

		if (Boundary.polygonCheck(triangle.getCoordinateX() - DrawingArea.TRIANGLE_SIZE, triangle.getCoordinateY(),
				triangle.getCoordinateX() + DrawingArea.TRIANGLE_SIZE,
				triangle.getCoordinateY() + DrawingArea.TRIANGLE_SIZE, line.startCoordinateX, line.startCoordinateY)) {

			if (Boundary.polygonCheck(dot1.getCoordinateX(), dot1.getCoordinateY(),
					dot1.getCoordinateX() + Circle.DOT_WIDTH, dot1.getCoordinateY() + Circle.DOT_HEIGHT,
					line.startCoordinateX, line.startCoordinateY)) {
				mapLines.get(LINE_START_KEY).get(TRIANGLE_DOT_ONE_INDEX).add(line);

			} else if (Boundary.polygonCheck(dot2.getCoordinateX(), dot2.getCoordinateY(),
					dot2.getCoordinateX() + Circle.DOT_WIDTH, dot2.getCoordinateY() + Circle.DOT_HEIGHT,
					line.startCoordinateX, line.startCoordinateY)) {
				mapLines.get(LINE_START_KEY).get(TRIANGLE_DOT_TWO_INDEX).add(line);

			} else if (Boundary.polygonCheck(dot3.getCoordinateX(), dot3.getCoordinateY(),
					dot3.getCoordinateX() + Circle.DOT_WIDTH, dot3.getCoordinateY() + Circle.DOT_HEIGHT,
					line.startCoordinateX, line.startCoordinateY)) {
				mapLines.get(LINE_START_KEY).get(TRIANGLE_DOT_THREE_INDEX).add(line);

			}

		} else if (Boundary.polygonCheck(triangle.getCoordinateX() - DrawingArea.TRIANGLE_SIZE,
				triangle.getCoordinateY(), triangle.getCoordinateX() + DrawingArea.TRIANGLE_SIZE,
				triangle.getCoordinateY() + DrawingArea.TRIANGLE_SIZE, line.endCoordinateX, line.endCoordinateY)) {

			if (Boundary.polygonCheck(dot1.getCoordinateX(), dot1.getCoordinateY(),
					dot1.getCoordinateX() + Circle.DOT_WIDTH, dot1.getCoordinateY() + Circle.DOT_HEIGHT,
					line.endCoordinateX, line.endCoordinateY)) {
				mapLines.get(LINE_END_KEY).get(TRIANGLE_DOT_ONE_INDEX).add(line);

			} else if (Boundary.polygonCheck(dot2.getCoordinateX(), dot2.getCoordinateY(),
					dot2.getCoordinateX() + Circle.DOT_WIDTH, dot2.getCoordinateY() + Circle.DOT_HEIGHT,
					line.endCoordinateX, line.endCoordinateY)) {
				mapLines.get(LINE_END_KEY).get(TRIANGLE_DOT_TWO_INDEX).add(line);

			} else if (Boundary.polygonCheck(dot3.getCoordinateX(), dot3.getCoordinateY(),
					dot3.getCoordinateX() + Circle.DOT_WIDTH, dot3.getCoordinateY() + Circle.DOT_HEIGHT,
					line.endCoordinateX, line.endCoordinateY)) {
				mapLines.get(LINE_END_KEY).get(TRIANGLE_DOT_THREE_INDEX).add(line);

			}

		}

	}

	/*
	 * Find all the lines connecting to a triangle
	 */
	public Map<Integer, Map<Integer, List<Line>>> findLinesConnectingToTriangle(Triangle triangle) {
		Map<Integer, Map<Integer, List<Line>>> mapLines = new HashMap<>();
		for (int i = 0; i < TOTAL_LINE_AXIS; i++) {
			Map<Integer, List<Line>> mapDots = new HashMap<>();
			for (int j = 0; j < TOTAL_DOTS_IN_TRIANGLE; j++) {
				List<Line> temp = new ArrayList<>();
				mapDots.put(j, temp);

			}
			mapLines.put(i, mapDots);
		}
		for (int i = 0; i < DrawingArea.listOfShapes.size(); i++) {
			Object object = DrawingArea.listOfShapes.get(i);
			if (object instanceof Line) {
				Line line = (Line) object;
				isLineInsideTriangle(line, triangle, mapLines);

			}
		}
		return mapLines;

	}

	/*
	 * update the co-ordinates of the line drawn from and to triangle
	 */
	public void updateLinesDrawnToTriangle(Triangle triangle) {
		Map<Integer, Map<Integer, List<Line>>> lines = findLinesConnectingToTriangle(triangle);
		for (Integer key : lines.keySet()) {

			if (key == LINE_START_KEY) {
				Map<Integer, List<Line>> mapDots = lines.get(key);
				for (Integer dot : mapDots.keySet()) {
					List<Line> line = mapDots.get(dot);

					for (Line eachLine : line) {
						if (dot == TRIANGLE_DOT_ONE_INDEX) {
							eachLine.setLinePosition(triangle.dot1.getCoordinateX(), triangle.dot1.getCoordinateY(),
									eachLine.endCoordinateX, eachLine.endCoordinateY);
						} else if (dot == TRIANGLE_DOT_TWO_INDEX) {
							eachLine.setLinePosition(triangle.dot2.getCoordinateX(), triangle.dot2.getCoordinateY(),
									eachLine.endCoordinateX, eachLine.endCoordinateY);
						} else {
							eachLine.setLinePosition(triangle.dot3.getCoordinateX(), triangle.dot3.getCoordinateY(),
									eachLine.endCoordinateX, eachLine.endCoordinateY);
						}
					}
				}
			} else {
				Map<Integer, List<Line>> mapDots = lines.get(key);
				for (Integer dot : mapDots.keySet()) {
					List<Line> line = mapDots.get(dot);

					for (Line eachLine : line) {
						if (dot == TRIANGLE_DOT_ONE_INDEX) {
							eachLine.setLinePosition(eachLine.startCoordinateX, eachLine.startCoordinateY,
									triangle.dot1.getCoordinateX(), triangle.dot1.getCoordinateY());
						} else if (dot == TRIANGLE_DOT_TWO_INDEX) {
							eachLine.setLinePosition(eachLine.startCoordinateX, eachLine.startCoordinateY,
									triangle.dot2.getCoordinateX(), triangle.dot2.getCoordinateY());
						} else {
							eachLine.setLinePosition(eachLine.startCoordinateX, eachLine.startCoordinateY,
									triangle.dot3.getCoordinateX(), triangle.dot3.getCoordinateY());
						}
					}
				}

			}

		}

	}

	/*
	 * find all the lines connected to square
	 */
	public void isLineInsideSquare(Line line, Square square, Map<Integer, Map<Integer, List<Line>>> mapLines) {
		Square bar1 = square.bar1;
		Square bar2 = square.bar2;

		if (Boundary.polygonCheck(square.getCoordinateX(), square.getCoordinateY(),
				square.getCoordinateX() + DrawingArea.SQUARE_WIDTH, square.getCoordinateY() + DrawingArea.SQUARE_HEIGHT,
				line.startCoordinateX, line.startCoordinateY)) {

			if (Boundary.polygonCheck(bar1.getCoordinateX(), bar1.getCoordinateY(),
					bar1.getCoordinateX() + Square.BAR_WIDTH, bar1.getCoordinateY() + Square.BAR_HEIGHT,
					line.startCoordinateX, line.startCoordinateY)) {
				mapLines.get(LINE_START_KEY).get(TRIANGLE_DOT_ONE_INDEX).add(line);

			} else if (Boundary.polygonCheck(bar2.getCoordinateX(), bar2.getCoordinateY(),
					bar2.getCoordinateX() + Square.BAR_WIDTH, bar2.getCoordinateY() + Square.BAR_HEIGHT,
					line.startCoordinateX, line.startCoordinateY)) {
				mapLines.get(LINE_START_KEY).get(TRIANGLE_DOT_TWO_INDEX).add(line);

			}

		} else if (Boundary.polygonCheck(square.getCoordinateX(), square.getCoordinateY(),
				square.getCoordinateX() + DrawingArea.SQUARE_WIDTH, square.getCoordinateY() + DrawingArea.SQUARE_HEIGHT,
				line.endCoordinateX, line.endCoordinateY)) {

			if (Boundary.polygonCheck(bar1.getCoordinateX(), bar1.getCoordinateY(),
					bar1.getCoordinateX() + Square.BAR_WIDTH, bar1.getCoordinateY() + Square.BAR_HEIGHT,
					line.endCoordinateX, line.endCoordinateY)) {
				mapLines.get(LINE_END_KEY).get(TRIANGLE_DOT_ONE_INDEX).add(line);

			} else if (Boundary.polygonCheck(bar2.getCoordinateX(), bar2.getCoordinateY(),
					bar2.getCoordinateX() + Square.BAR_WIDTH, bar2.getCoordinateY() + Square.BAR_HEIGHT,
					line.endCoordinateX, line.endCoordinateY)) {
				mapLines.get(LINE_END_KEY).get(TRIANGLE_DOT_TWO_INDEX).add(line);

			}

		}

	}

	public Map<Integer, Map<Integer, List<Line>>> findLinesConnectingToSquare(Square square) {
		Map<Integer, Map<Integer, List<Line>>> mapLines = new HashMap<>();
		for (int i = 0; i < TOTAL_LINE_AXIS; i++) {
			Map<Integer, List<Line>> mapBars = new HashMap<>();
			for (int j = 0; j < TOTAL_BARS_IN_SQUARE; j++) {
				List<Line> temp = new ArrayList<>();
				mapBars.put(j, temp);

			}
			mapLines.put(i, mapBars);
		}
		for (int i = 0; i < DrawingArea.listOfShapes.size(); i++) {
			Object object = DrawingArea.listOfShapes.get(i);
			if (object instanceof Line) {
				Line line = (Line) object;
				isLineInsideSquare(line, square, mapLines);

			}
		}
		return mapLines;
	}

	/*
	 * update the co-ordinates of the line drawn from and to square
	 */
	public void updateLinesDrawnToSquare(Square square) {
		Map<Integer, Map<Integer, List<Line>>> lines = findLinesConnectingToSquare(square);

		for (Integer key : lines.keySet()) {

			if (key == LINE_START_KEY) {
				Map<Integer, List<Line>> mapDots = lines.get(key);
				for (Integer bar : mapDots.keySet()) {
					List<Line> line = mapDots.get(bar);

					for (Line eachLine : line) {
						if (bar == TRIANGLE_DOT_ONE_INDEX) {
							eachLine.setLinePosition(square.bar1.getCoordinateX(), square.bar1.getCoordinateY(),
									eachLine.endCoordinateX, eachLine.endCoordinateY);
						} else if (bar == TRIANGLE_DOT_TWO_INDEX) {
							eachLine.setLinePosition(square.bar2.getCoordinateX(), square.bar2.getCoordinateY(),
									eachLine.endCoordinateX, eachLine.endCoordinateY);
						}
					}
				}
			} else {
				Map<Integer, List<Line>> mapDots = lines.get(key);
				for (Integer dot : mapDots.keySet()) {
					List<Line> line = mapDots.get(dot);

					for (Line eachLine : line) {
						if (dot == TRIANGLE_DOT_ONE_INDEX) {
							eachLine.setLinePosition(eachLine.startCoordinateX, eachLine.startCoordinateY,
									square.bar1.getCoordinateX(), square.bar1.getCoordinateY());
						} else if (dot == TRIANGLE_DOT_TWO_INDEX) {
							eachLine.setLinePosition(eachLine.startCoordinateX, eachLine.startCoordinateY,
									square.bar2.getCoordinateX(), square.bar2.getCoordinateY());
						}
					}
				}

			}

		}
	}

}
