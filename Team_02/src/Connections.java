/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package saveLoadFile;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * @author Suryadeep
 * @created on 01-17-2020
 * @version 1.0
 */
class Connections extends JFrame {
	static ArrayList<Point> moves = new ArrayList<Point>();
	ShapeLocation objShape = new ShapeLocation();
	String Point1_id = new String();
	String Point2_id = new String();

	public Connections(int x1, int y1, int x2, int y2) {
		for (Point p : objShape.squarebarpoints) {
			if (x1 == p.x && y1 == p.y) {
				Point1_id = "bar";
			}
			if (x2 == p.x && y2 == p.y) {
				Point2_id = "bar";
			}
		}
		if (Point1_id.equals("")) {
			Point1_id = "dot";
		}
		if (Point2_id.equals("")) {
			Point2_id = "dot";
		}
		if (Point1_id.equals("bar") && Point2_id.equals("bar")) {
			this.BarToBarConnection(x1, y1, x2, y2);
		}
		if (Point1_id.equals("bar") && Point2_id.equals("dot")) {
			this.DotToBarConnection(x2, y2, x1, y1);
		}
		if (Point1_id.equals("dot") && Point2_id.equals("bar")) {
			this.DotToBarConnection(x1, y1, x2, y2);
		}
		if (Point1_id.equals("dot") && Point2_id.equals("dot")) {
			this.DotToDotConnection(x1, y1, x2, y2);
		}
	}

	public void DotToDotConnection(int x1, int y1, int x2, int y2) {
		boolean pointExitsInList = false;
		try {
			System.out.println("Dot to DOt");
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

		}
	}

	public void DotToBarConnection(int x1, int y1, int x2, int y2) {
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

		}
	}

	public void BarToBarConnection(int x1, int y1, int x2, int y2) {
		try {
			System.out.println("bar to bar");
			Lineconnection objLineConnect = new Lineconnection(new Point(x1, y1), new Point(x2, y2));
			ShapeLocation.LinePoint.add(objLineConnect);

		} catch (Exception ex) {

		}
	}

	void drawLines(Graphics g, int _x1, int _y1, int _x2, int _y2) {
		try {
			// Graphics2D g2d = (Graphics2D) g;

			g.drawLine(_x1, _y1, _x2, _y2);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
