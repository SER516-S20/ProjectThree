import java.awt.Point;

/**
 * @author Yijian Hu
 */
public class ShapeInfo {
	private int id;
	private String type;
	private Point position;
	
	ShapeInfo(int id, String type, Point position){
		this.id = id;
		this.type = type;
		this.position = position;
	}
	
	public int getId(){
		return id;
	}
	
	public String getType(){
		return type;
	}
	
	public Point getPosition(){
		return position;
	}
}
