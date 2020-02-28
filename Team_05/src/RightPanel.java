import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Yijian Hu
 */
public class RightPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, JButton> shapes;
	private Frame frame;
	private int currentX, currentY;
	//private int step;
	//private Box btnInstance;
	
	public RightPanel() {
		this.setBackground(Color.red);
		shapes = new Hashtable<Integer, JButton>();
		currentX = 0;
		currentY = 0;
		//this.setLayout(null);
		//step = 50;
		addMouseListener(this);
		//addMouseMotionListener(this);
	}
	
	public void addButton(String className, int x, int y) {
		System.out.println("get in to the panel...." + className);
		
		if(className.equals("TriangleButton")) {
			TriangleButton triangle = new TriangleButton("");
			addActionAndMouseMotionListener(triangle);
			//triangle.addMouseMotionListener(this);
			//points = triangle.getPointsPosition();
			this.add(triangle);
			this.autoLocation(triangle,x,y);
			
		}else if(className.equals("RoundButton")) {
			RoundButton round = new RoundButton("");
			addActionAndMouseMotionListener(round);
			this.add(round);
			this.autoLocation(round,x-round.getWidth()/2,y-round.getHeight()/2);
		}else if(className.equals("RectangleButton")) {
			RectangleButton rect = new RectangleButton("");
			addActionAndMouseMotionListener(rect);
			this.add(rect);
			this.autoLocation(rect,x,y);
			//points = rect.getPointsPosition();
		}
		this.repaint();
		
	}
	
	private void addActionAndMouseMotionListener(JButton button) {
		//JButton btn =  (JButton) button;
		button.addActionListener(this);
		button.addMouseMotionListener(this);
	}
	/*
	public void addRound() {
		RoundButton round = new RoundButton("");
		shapes.put(round.hashCode(),round);
		this.add(round);
		autoLocation(round);
		frame.contentRepaint();
	}
	
	public void addTriangle() {
		TriangleButton triangle = new TriangleButton("");
		shapes.put(triangle.hashCode(),triangle);
		this.add(triangle);
		autoLocation(triangle);
		frame.contentRepaint();
	}
	
	public void addRectangle() {
		RectangleButton rectangle = new RectangleButton("");
		shapes.put(rectangle.hashCode(),rectangle);
		this.add(rectangle);
		autoLocation(rectangle);
		frame.contentRepaint();
	}*/
	/*
	public void addShape(ShapeInfo shapeInfo){
		JButton shape;
		switch(shapeInfo.getType()){
			case "round":
				shape = new RoundButton("");
				break;
			case "triangle":
				shape = new TriangleButton("");
				break;
			default:
				shape = new RectangleButton("");
		}
		shape.setLocation(shapeInfo.getPosition());
		shape.setSize(shape.getPreferredSize());
		shapes.put(shapeInfo.getId(),shape);
		this.add(shape);
		frame.contentRepaint();
	}
	
	public void deleteShape(int hashCode) {
		this.remove(shapes.get(hashCode));
		shapes.remove(hashCode);
		frame.contentRepaint();
	}*/
	
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
	
	/*
	public void load(ShapeInfo[] shapeList){
		clear();
		for(ShapeInfo shape:shapeList){
			addShape(shape);
		}
		updateHashCode();
	}*/
	
	private void autoLocation(JButton button,int x, int y) {
		Rectangle dimension = this.getBounds();
		System.out.println("dimension: " + dimension);
		button.setSize(button.getPreferredSize());
		button.setLocation(x, y);
	}
	
	private void updateHashCode(){
		Hashtable<Integer, JButton> update = new Hashtable<Integer, JButton>();
		for(JButton shape:shapes.values()) {
			update.put(shape.hashCode(), shape);
		}
		shapes = update;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj instanceof RoundButton) {
			RoundButton btn = (RoundButton)obj;
			System.out.println("....." + btn.getCenterPoint() );
		}
		//System.out.println("....." + );
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//e.getComponent()
		// TODO Auto-generated method stub
		e.getComponent().setLocation(e.getX() + e.getComponent().getX(), 
				 e.getY() + e.getComponent().getY());
		System.out.println("mouse drag: " + e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("=====" + e.getSource().getClass().getName() + ", " + e.getX() + ", " + e.getY());
		Box instance = Box.getInstance();
		if(instance.instanceOfClass == null)
			return;
		addButton(instance.instanceOfClass,e.getX(),e.getY());
		currentX = e.getX();
		currentY = e.getY();
		System.out.println("====" + this.getComponentCount());
		//Graphics g = this.getGraphics();
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        for(int i = 0; i < this.getComponentCount(); i++) {
        	g.drawLine(currentX + 37, currentY + 37 ,150,20*i+150);
        }
    }*/
    
    public void paint(Graphics g) {
        //super.paint(g);
        super.paint(g);
        for(int i = 0; i < this.getComponentCount(); i++) {
        	g.drawLine(currentX + 37, currentY + 37 ,150,20*i+150);
        }
    }
}
