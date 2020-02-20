import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Raghavan
 * @version 1.0
 */
public class Dot extends Shapes implements MouseListener, MouseMotionListener, Serializable {
	double x, y;
	static public boolean isBarClicked = false;
	static boolean isDotClicked = false, firstDotClicked = false;
	static int sourceX, sourceY, destinationX, destinationY;
	static Shapes firstShape, secondShape;
	Shape circle = null;

	public Dot(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Dot() {

	}

	/**
	 * Draws a Circle using Ellipse2D
	 * 
	 * @param graphic
	 * @param x       - x coordinate for the shape
	 * @param y       - y coordinate for the shape
	 */
	@Override
	public void drawShape(Graphics graphic) {
		circle = new Ellipse2D.Double(x, y, 10, 10);
		Graphics2D graphics2 = (Graphics2D) graphic;
		graphics2.fill(circle);

	}

	public boolean containsPoint(int x, int y) {
		return circle.contains(x, y);
	}

	@Override
	public int getX() {
		return (int) x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return (int) y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ( !RightPanel.isSelected && isDotClicked ) {
			Iterator<Shapes> shapeIterator = RightPanel.rightPanelShapes.iterator();
			while (shapeIterator.hasNext()) {
				Shapes shape = shapeIterator.next();
				if (shape.containsPoint(e.getX(), e.getY()) && !getIsLineDrawn(shape, e.getX(), e.getY())) {
					RightPanel.originShape = shape;
					firstShape = shape;
					sourceX = e.getX();
					sourceY = e.getY();
					isDotClicked = false;
					firstDotClicked = true;
					RightPanel.isMoved = true;
					Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
					Frame.rightPanel.setCursor(cursor);
					Frame.rightPanel.setVisible(true);
					break;
				}
			}
			RightPanel.isSelected = true;

		}
		
		else if ( !RightPanel.isSelected && isBarClicked ) {
			Iterator<Shapes> shapeIterator = RightPanel.rightPanelShapes.iterator();
			while (shapeIterator.hasNext()) {
				Shapes shape = shapeIterator.next();
				if (shape.containsPoint(e.getX(), e.getY()) && !getIsLineDrawn(shape, e.getX(), e.getY())) {
					RightPanel.originShape = shape;
					firstShape = shape;
					sourceX = e.getX();
					sourceY = e.getY();
					isBarClicked = false;
					firstDotClicked = true;
					RightPanel.isMoved = true;
					Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
					Frame.rightPanel.setCursor(cursor);
					Frame.rightPanel.setVisible(true);
					break;
				}
			}
			RightPanel.isSelected = true;

		}

	}

	private void setIsLineDrawn(Shapes shape, int x, int y) {
		if (shape instanceof Circle) {
			Circle circle = ((Circle) shape);
			circle.isLineDrawn = true;
		} else if (shape instanceof Triangle) {
			Triangle triangle = (Triangle) shape;
			if (triangle.dot1.containsPoint(x, y)) {
				triangle.isLineDrawnDot1 = true;
			} else if (triangle.dot2.containsPoint(x, y)) {
				triangle.isLineDrawnDot2 = true;
			} else if (triangle.dot3.containsPoint(x, y)) {
				triangle.isLineDrawnDot3 = true;
			}
		}
	}

	private boolean getIsLineDrawn(Shapes shape, int x, int y) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

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