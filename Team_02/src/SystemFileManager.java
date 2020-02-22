/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunal Sharma
 * @created 02-18-2020
 * @version 1.0
 */
public class SystemFileManager {

	public void restoreShape(String pathName) {
		try {

			FileInputStream fis = new FileInputStream(pathName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<List<Point>> list = (ArrayList<List<Point>>) ois.readObject();

			ShapeLocation.circlePoint = list.get(0);
			ShapeLocation.trianglePoint = list.get(1);
			ShapeLocation.squarePoint = list.get(2);
			ShapeLocation.dotPoint = list.get(3);
			List<Lineconnection> lineConnection = new ArrayList<Lineconnection>();
			List<Point> lines = list.get(5);
			for (int i = 0; i <= lines.size() / 2; i = i + 2) {
				Lineconnection objLC = new Lineconnection(lines.get(i), lines.get(i + 1));
				lineConnection.add(objLC);
			}
			ShapeLocation.LinePoint = lineConnection;
			ShapeLocation.squarebarpoints = list.get(4);
			ois.close();
			fis.close();

			new MouseListener().restore();
		} catch (Exception ex) {
			System.out.println("Trouble reading display list vector");
		}
	}

	public void saveShape(String pathName, List<Point> circlePoint, List<Point> trianglePoint, List<Point> squarePoint,
			List<Point> pointsPoint, List<Point> squareBar, ArrayList<List<Point>> list) {
		try {

			FileOutputStream fos = new FileOutputStream(new File(pathName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			circlePoint = ShapeLocation.circlePoint;
			trianglePoint = ShapeLocation.trianglePoint;
			squarePoint = ShapeLocation.squarePoint;
			pointsPoint = ShapeLocation.dotPoint;
			squareBar = ShapeLocation.squarebarpoints;
			List<Point> lines = new ArrayList<Point>();
			for (Lineconnection line : ShapeLocation.LinePoint) {
				lines.add(line.P1);
				lines.add(line.P2);
			}
			list.add(circlePoint);
			list.add(trianglePoint);
			list.add(squarePoint);
			list.add(pointsPoint);
			list.add(squareBar);
			list.add(lines);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception ex) {
			System.out.println("Trouble writing display list vector");
		}
	}

}
