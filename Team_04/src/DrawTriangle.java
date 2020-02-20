import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

/**
 * This class implements the drawing of shapes drag and drop within canvas.
 * 
 * @author Ashwath Reddy Koppala, Sree Pradeep Kumar Relangi
 * 
 * @created on 1-29-2020
 * @updated on 2-15-2020
 * @version 1.0.2
 *
 */
public class DrawTriangle extends DrawShape implements MouseListener, MouseMotionListener {
	private int currentX;
	private int currentY;
	private int relativeX;
	private int relativeY;
	private String shapeName;
	private int HEIGHT = 100;
	private int WIDTH = 100;
	Shape shape;

	public DrawTriangle(int posX, int posY, DrawingCanvas c) {
		super(c, "Triangle", posX, posY);
		currentX = posX;
		currentY = posY;
		Dimension size = new Dimension(HEIGHT, WIDTH);
		this.setPreferredSize(size);
		this.setBounds(currentX, currentY, 100, 100);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		int xPoints[] = { WIDTH / 2, 1, WIDTH - 1 };
		int yPoints[] = { 1, HEIGHT - 1, HEIGHT - 1 };
		g.fillPolygon(xPoints, yPoints, xPoints.length);
		g.setColor(Color.BLACK);
		g.fillOval(WIDTH / 2 - 5, 25, 10, 10);
		g.setColor(Color.BLACK);
		g.fillOval(25, HEIGHT - 26, 10, 10);
		g.setColor(Color.BLACK);
		g.fillOval(WIDTH - 31, HEIGHT - 26, 10, 10);
	}

	private boolean contain(int x, int y) {
		System.out.println(x);
		System.out.println(y);
		System.out.println(WIDTH / 2);
		System.out.println(30);
		int ans = ((x - (WIDTH / 2)) * (x - (WIDTH / 2)) + (y - (30)) * (y - (30))) - 25;
		System.out.println(ans);
		if (ans <= 0)
			return true;

		ans = ((x - (30)) * (x - (30)) + (y - (HEIGHT - 21)) * (y - (HEIGHT - 21))) - 25;
		if (ans <= 0)
			return true;

		ans = ((x - (WIDTH - 26)) * (x - (WIDTH - 26)) + (y - (HEIGHT - 21)) * (y - (HEIGHT - 21))) - 25;
		if (ans <= 0)
			return true;

		return false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		relativeX = currentX - e.getX();
		relativeY = currentY - e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x1 = e.getX();
		int y1 = e.getY();
		setLocation(x1 + relativeX, y1 + relativeY);
		currentX = x1 + relativeX;
		currentY = y1 + relativeY;
		for (int i = 0; i < super.connections.size(); i++) {
			Point[] shapePoints = super.connections.get(i);
			for (int j = 0; j < super.canvas.lineArray.size(); j++) {
				Point[] linePoints = super.canvas.lineArray.get(j);
				if (linePoints[0].equals(shapePoints[0])) {
					linePoints[0].x = currentX + shapePoints[1].x;
					linePoints[0].y = currentY + shapePoints[1].y;
					shapePoints[0].x = currentX + shapePoints[1].x;
					shapePoints[0].y = currentY + shapePoints[1].y;
				} else if (linePoints[1].equals(shapePoints[0])) {
					linePoints[1].x = currentX + shapePoints[1].x;
					linePoints[1].y = currentY + shapePoints[1].y;
					shapePoints[0].x = currentX + shapePoints[1].x;
					shapePoints[0].y = currentY + shapePoints[1].y;
				}
			}
			super.canvas.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.contain(e.getX(), e.getY())) {
			System.out.print("clicked triangle");
			Click c1 = new Click(e.getX() + currentX, e.getY() + currentY, this);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}