import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Ashutosh Dey
 * @version 1.0
 * @since 01/28/2020
 */
public class DrawingArea extends JPanel {

	static ArrayList<Shape> listOfShapes = new ArrayList<>();
	private static final int DRAWING_AREA_HEIGHT = 600;
	private static final int DRAWING_AREA_WIDTH = 800;

	static final int TRIANGLE_SIZE = 60;

	static final int SQUARE_HEIGHT = 50;
	static final int SQUARE_WIDTH = 50;

	static final int CIRCLE_HEIGHT = 50;
	static final int CIRCLE_WIDTH = 50;

	static final int LINE_HEIGHT = 0;
	static final int LINE_WIDTH = 0;

	DrawingArea() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(DRAWING_AREA_WIDTH, DRAWING_AREA_HEIGHT));
		MouseListener mouseListener = new MouseListener();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < listOfShapes.size(); i++) {
			Object object = listOfShapes.get(i);
			if (object instanceof Square) {

				Square square = (Square) object;
				square.setColor(Color.BLUE);
				square.draw(g, true, SQUARE_HEIGHT, SQUARE_WIDTH);

			} else if (object instanceof Triangle) {

				Triangle triangle = (Triangle) object;
				triangle.draw(g, true, TRIANGLE_SIZE, TRIANGLE_SIZE);

			} else if (object instanceof Circle) {

				Circle circle = (Circle) object;
				circle.setColor(Color.RED);
				circle.draw(g, true, CIRCLE_HEIGHT, CIRCLE_WIDTH);

			} else {
				
				Line line = (Line) object;
				line.setColor(Color.ORANGE);
				line.draw(g, true, LINE_HEIGHT, LINE_WIDTH);
			}
		}
	}

	void addSquare(Square square) {
		listOfShapes.add(square);
		repaint();
	}

	void addTriangle(Triangle triangle) {
		listOfShapes.add(triangle);
		repaint();
	}

	void addCircle(Circle circle) {
		listOfShapes.add(circle);
		repaint();
	}

	void addLine(Line line) {
		DrawingArea.listOfShapes.remove(Dots.currentLineObject);
		listOfShapes.add(line);
		repaint();
	}

	void repaintOnDrag() {
		repaint();
	}

}
