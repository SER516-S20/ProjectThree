import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Suryadeep
 * @created on 01-17-2020
 * @version 1.0
 */
class Connections extends JFrame {
	static ArrayList<Point> moves = new ArrayList<Point>();
	ShapeLocation objShape = new ShapeLocation();
	String point1_id = new String();
	String point2_id = new String();

	public Connections(int x1, int y1, int x2, int y2) {
		for (Point p : objShape.squarebarpoints) {
			if (x1 == p.x && y1 == p.y) {
				point1_id = "bar";
			}
			if (x2 == p.x && y2 == p.y) {
				point2_id = "bar";
			}
		}
		if (point1_id.equals("")) {
			point1_id = "dot";
		}
		if (point2_id.equals("")) {
			point2_id = "dot";
		}
		if (point1_id.equals("bar") && point2_id.equals("bar")) {
			this.barToBarConnection(x1, y1, x2, y2);
		}
		if (point1_id.equals("bar") && point2_id.equals("dot")) {
			this.dotToBarConnection(x2, y2, x1, y1);
		}
		if (point1_id.equals("dot") && point2_id.equals("bar")) {
			this.dotToBarConnection(x1, y1, x2, y2);
		}
		if (point1_id.equals("dot") && point2_id.equals("dot")) {
			this.dotToDotConnection(x1, y1, x2, y2);
		}
	}

	public void dotToDotConnection(int x1, int y1, int x2, int y2) {
		boolean pointExitsInList = false;
		try {
			if (moves.size() == 0) {
				moves.add(new java.awt.Point(x1, y1));
				moves.add(new java.awt.Point(x2, y2));
				Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
				ShapeLocation.LinePoint.add(objLineConnect);

			} else {
				for (int i = 0; i < moves.size(); i++) {
					if ((moves.get(i).x == x1 && moves.get(i).y == y1)
							|| (moves.get(i).x == x2 && moves.get(i).y == y2)) {
						System.out.println("Already available");
						pointExitsInList = true;
						break;
					}

				}
				if (pointExitsInList == false) {
					moves.add(new java.awt.Point(x1, y1));
					moves.add(new java.awt.Point(x2, y2));
					Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
					ShapeLocation.LinePoint.add(objLineConnect);
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception in dot to dot");
		}
	}

	public void dotToBarConnection(int x1, int y1, int x2, int y2) {
		boolean pointExitsInList = false;
		try {
			System.out.println("Dot to Bar");
			if (moves.size() == 0) {
				moves.add(new java.awt.Point(x1, y1));
				Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
				ShapeLocation.LinePoint.add(objLineConnect);

			} else {
				for (int i = 0; i < moves.size(); i++) {
					if (moves.get(i).x == x1 && moves.get(i).y == y1) {
						System.out.println("Already available");
						pointExitsInList = true;
						break;
					}

				}
				if (pointExitsInList == false) {
					moves.add(new java.awt.Point(x1, y1));
					Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
					ShapeLocation.LinePoint.add(objLineConnect);
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception in dot to bar");
		}
	}

	public void barToBarConnection(int x1, int y1, int x2, int y2) {
		try {
			Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
			ShapeLocation.LinePoint.add(objLineConnect);

		} catch (Exception ex) {
			System.out.println("Exception in bar to bar");
		}
	}

	void drawLines(Graphics g, int x1, int y1, int x2, int y2) {
		try {
			g.drawLine(x1, y1, x2, y2);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
