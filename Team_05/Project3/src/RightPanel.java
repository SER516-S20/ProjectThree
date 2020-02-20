import java.awt.Point;
import java.awt.Rectangle;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Yijian Hu
 */
public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, JButton> shapes;
	private Frame frame;
	private int currentX, currentY;
	private int step;
	
	public RightPanel() {
		shapes = new Hashtable<Integer, JButton>();
		currentX = 0;
		currentY = 0;
		this.setLayout(null);
		step = 50;
	}
	
	public void addRound() {
		RoundButton round = new RoundButton("");
		round.addMouseListener(new RightPanelMouse(this) {});
		round.addMouseMotionListener(new RightPanelMouse(this) {});
		shapes.put(round.hashCode(),round);
		this.add(round);
		autoLocation(round);
		frame.contentRepaint();
	}
	
	public void addRound(int ID, Point position) {
		RoundButton round = new RoundButton("");
		round.addMouseListener(new RightPanelMouse(this) {});
		round.addMouseMotionListener(new RightPanelMouse(this) {});
		round.setLocation(position.x,position.y);
		round.setSize(round.getPreferredSize());
		shapes.put(ID,round);
		this.add(round);
		frame.contentRepaint();
	}
	
	public void addTriangle() {
		TriangleButton triangle = new TriangleButton("");
		triangle.addMouseListener(new RightPanelMouse(this) {});
		triangle.addMouseMotionListener(new RightPanelMouse(this) {});
		shapes.put(triangle.hashCode(),triangle);
		this.add(triangle);
		autoLocation(triangle);
		frame.contentRepaint();
	}
	
	public void addTriangle(int ID, Point position) {
		TriangleButton triangle = new TriangleButton("");
		triangle.addMouseListener(new RightPanelMouse(this) {});
		triangle.addMouseMotionListener(new RightPanelMouse(this) {});
		triangle.setLocation(position.x,position.y);
		triangle.setSize(triangle.getPreferredSize());
		shapes.put(ID,triangle);
		this.add(triangle);
		frame.contentRepaint();
	}
	
	public void addRectangle() {
		RectangleButton rectangle = new RectangleButton("");
		rectangle.addMouseListener(new RightPanelMouse(this) {});
		rectangle.addMouseMotionListener(new RightPanelMouse(this) {});
		shapes.put(rectangle.hashCode(),rectangle);
		this.add(rectangle);
		autoLocation(rectangle);
		frame.contentRepaint();
	}
	
	public void addRectangle(int ID, Point position) {
		RectangleButton rectangle = new RectangleButton("");
		rectangle.addMouseListener(new RightPanelMouse(this) {});
		rectangle.addMouseMotionListener(new RightPanelMouse(this) {});
		rectangle.setLocation(position.x,position.y);
		rectangle.setSize(rectangle.getPreferredSize());
		shapes.put(ID,rectangle);
		this.add(rectangle);
		frame.contentRepaint();
	}
	
	public void updateHashCode()
	{
		Hashtable<Integer, JButton> update = new Hashtable<Integer, JButton>();
		for(JButton shape:shapes.values()) {
			update.put(shape.hashCode(), shape);
		}
		shapes = update;
	}
	
	public void deleteShape(int hashCode) {
		this.remove(shapes.get(hashCode));
		shapes.remove(hashCode);
		frame.contentRepaint();
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public void setShapeLocation(int hashCode, int x, int y) {
		shapes.get(hashCode).setLocation(x,y);
		frame.contentRepaint();
	}
	
	public Hashtable<Integer, JButton> getShapes() {
		return shapes;
	}
	
	public void clear() {
		for(JButton shape:shapes.values()) {
			this.remove(shape);
		}
		shapes.clear();
		currentX = 0;
		currentY = 0;
	}
	
	private void autoLocation(JButton button) {
		Rectangle dimension = this.getBounds();
		button.setSize(button.getPreferredSize());
		if(currentX <= dimension.width - step) {
			button.setLocation(currentX, currentY);
			currentX += step;
			System.out.println("AutoLocation " + currentX + " " + currentY);
		}
		else {
			currentX = 0;
			currentY += step;
			button.setLocation(currentX, currentY);
			System.out.println("AutoLocation " + currentX + " " + currentY);
			currentX += step;
		}
	}
}
