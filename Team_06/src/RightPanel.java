import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 * @author: Suyog, Dhananjay, Somesh
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
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	RightPanel(){
		SelectShape selectShape = new SelectShape();
		selectShape.release(this);
	}
}