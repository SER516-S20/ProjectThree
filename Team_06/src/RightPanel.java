import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 * @author: Suyog
 * @Date: 01/28/2020
 * @Description: Right Panel will have different shapes added which are selected in left panel.
 */
public class RightPanel extends JPanel{
	int shapeNumber = 0;
	private static RightPanel single_instance = null;
	
	ArrayList<Point> points = new ArrayList<Point>();;
	ArrayList<Point> circlePoints = new ArrayList<Point>();
	ArrayList<Point> squarePoints = new ArrayList<Point>();
	ArrayList<Point> trianglePoints = new ArrayList<Point>();
	
	static boolean selected = false;
	int startX = 0, startY = 0, endX = 0, endY = 0;
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	RightPanel(){
		SelectShape selectShape = new SelectShape();
		selectShape.release(this);
	}
	
	public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(startX, startY, endX, endY);
        g2.draw(lin);
    }
}