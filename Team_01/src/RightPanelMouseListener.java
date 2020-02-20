import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RightPanelMouseListener extends RightPanel implements MouseListener, MouseMotionListener {
	public RightPanelMouseListener() {
	}
	
	static Shapes selectedShape;
	List<DrawLine> linesList = new ArrayList<DrawLine> ();
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (selectedShape != null) {
			selectedShape.setX(e.getX());
			selectedShape.setY(e.getY());
		}
		ListIterator<DrawLine> linesListIter = linesList.listIterator();
		while (linesListIter.hasNext()) {
			DrawLine nextLine = linesListIter.next();
			if (nextLine.isSourceShape()) {
				nextLine.getLine().setSourceX(nextLine.getLineX() - (nextLine.getShapeX()- selectedShape.getX()));
				nextLine.getLine().setSourceY(nextLine.getLineY() - (nextLine.getShapeY() - selectedShape.getY()));
			} else if (nextLine.isDestShape()) {
				nextLine.getLine().setDestX(nextLine.getLineX() - (nextLine.getShapeX() - selectedShape.getX()));
				nextLine.getLine().setDestY(nextLine.getLineY() - (nextLine.getShapeY() - selectedShape.getY()));
			}
		}
		RightPanel.isSelected = false;
		Frame.rightPanel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!Dot.isDotClicked && !RightPanel.isMoved  &&!Dot.isBarClicked) {
			int x = e.getX();
			int y = e.getY();
			ShapesEnum selectedShape = LeftPanelMouseListener.getSelectedShape();
			if (selectedShape == ShapesEnum.SQUARE) {
				RightPanel.rightPanelShapes.add(new Square(x, y));
			} else if (selectedShape == ShapesEnum.TRIANGLE) {
				RightPanel.rightPanelShapes.add(new Triangle(x, y));
			} else if (selectedShape == ShapesEnum.CIRCLE) {
				Circle c = new Circle(x, y);
				RightPanel.rightPanelShapes.add(c);
			}
			Frame.rightPanel.repaint();
		}
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
	 

}
