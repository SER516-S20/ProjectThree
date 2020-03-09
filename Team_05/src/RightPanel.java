import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author Yijian Hu
 */
public class RightPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, JButton> shapes;
	private Frame frame;
	//private int step;
	//private Box btnInstance;
	RoundButton tempround = null;
	TriangleButton temptri = null;
	RectangleButton temrect = null;
	private Connection tempconnection = null;
	private static List<Connection> connections = new ArrayList<Connection>();
	private static int originX, originY, destinationX, destinationY;
	private static boolean isMoved = false;
	private ValuePane valuePane;
	private TitledBorder titled;

	public RightPanel() {
		valuePane = new ValuePane();
		this.setBackground(Color.red);
		shapes = new Hashtable<Integer, JButton>();
		
		
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
			this.autoLocation(triangle,x-triangle.getPreferredSize().width/2,y-triangle.getPreferredSize().height/2);
			
		}else if(className.equals("RoundButton")) {
			RoundButton round = new RoundButton("");
			addActionAndMouseMotionListener(round);
			this.add(round);
			this.autoLocation(round,x-round.getPreferredSize().width/2,y-round.getPreferredSize().height/2);
		}else if(className.equals("RectangleButton")) {
			RectangleButton rect = new RectangleButton("");
			addActionAndMouseMotionListener(rect);
			this.add(rect);
			this.autoLocation(rect,x-rect.getPreferredSize().width/2,y-rect.getPreferredSize().height/2);
			//points = rect.getPointsPosition();
		}
		this.repaint();
		
	}
	
	private void addActionAndMouseMotionListener(JButton button) {
		//JButton btn =  (JButton) button;
		button.addActionListener(this);
		button.addMouseMotionListener(this);
		button.addMouseListener(this);
		
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
		
	}
	
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
//		// TODO Auto-generated method stub
//		//
//		System.out.println("....."+e.getSource());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//e.getComponent()
		// TODO Auto-generated method stub
		e.getComponent().setLocation(e.getX() + e.getComponent().getX(), 
				 e.getY() + e.getComponent().getY());
		isMoved = true;
		destinationX = e.getX() + e.getComponent().getX();
		destinationY = e.getY() + e.getComponent().getY();
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public String getTitleVal() {
		return valuePane.getvalue();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("=====" + e.getSource().getClass().getName() + ", " + e.getX() + ", " + e.getY());
		if(e.getSource().equals(this)) {
			Box instance = Box.getInstance();
			if(instance.instanceOfClass == null) {
				if (e.getClickCount() == 2) {
					valuePane.setValue(valuePane.getvalue());
					//titled = BorderFactory.createTitledBorder(valuePane.getvalue());
					//this.setBorder(valuePane.getvalue());
				}
				return;
			}
			addButton(instance.instanceOfClass,e.getX(),e.getY());
			System.out.println("====" + this.getComponentCount());
		}
		else {
			if (e.getClickCount() == 2) {
				valuePane.setValue(valuePane.getvalue());
				//titled.setTitle(valuePane.getvalue());
			}
			Object obj = e.getSource();
			Box instance = Box.getInstance();
			int jX = e.getX();
			int jY = e.getY();
			boolean selected = false;
			if(obj instanceof RoundButton) {
				RoundButton btn = (RoundButton)obj;
				if(jX>=btn.getCenterPoint().x-3 && jX <= btn.getCenterPoint().x+3 && jY >= btn.getCenterPoint().y-3 && jY <= btn.getCenterPoint().y+3) {
					for(int i=0; i < connections.size(); i++) {
						Connection c = connections.get(i);
						if(btn.getBounds().getCenterX() == c.getSourceX() && btn.getBounds().getCenterY() == c.getSourceY()) {
							selected = true;
							tempconnection = null;
						}
						else if(btn.getBounds().getCenterX() == c.getDestX() && btn.getBounds().getCenterY() == c.getDestY()) {
							selected = true;
							tempconnection = null;
						}
					}
					if(!selected) {
						if(tempconnection == null) {
							tempconnection = new Connection();
							tempconnection.setSourceX((int)btn.getBounds().getCenterX());
							tempconnection.setSourceY((int)btn.getBounds().getCenterY());
						}
						else if (tempconnection != null) {
							tempconnection.setDestX((int)btn.getBounds().getCenterX());
							tempconnection.setDestY((int)btn.getBounds().getCenterY());
							connections.add(tempconnection);
							tempconnection = null;
							this.repaint();
						}
						else {
							tempconnection = null;
						}
					}
				}
			}
			else if(obj instanceof TriangleButton) {
				TriangleButton btn = (TriangleButton)obj;
				Point []points = btn.getPointsPosition();
				for(int i = 0; i < 3; i++) {
					if(jX>=points[i].x-3 && jX <= points[i].x+3 && jY >= points[i].y-3 && jY <= points[i].y+3) {
						for(int j=0; j < connections.size(); j++) {
							Connection c = connections.get(j);
							if(btn.getBounds().x+points[i].x == c.getSourceX() && btn.getBounds().y+points[i].y == c.getSourceY()) {
								selected = true;
								tempconnection = null;
							}
							else if(btn.getBounds().x+points[i].x == c.getDestX() && btn.getBounds().y+points[i].y == c.getDestY()) {
								selected = true;
								tempconnection = null;
							}
						}
						if(!selected) {
							if(tempconnection == null) {
								tempconnection = new Connection();
								tempconnection.setSourceX(btn.getBounds().x+points[i].x);
								tempconnection.setSourceY(btn.getBounds().y+points[i].y);
							}
							else if (tempconnection != null) {
								tempconnection.setDestX(btn.getBounds().x+points[i].x);
								tempconnection.setDestY(btn.getBounds().y+points[i].y);
								connections.add(tempconnection);
								tempconnection = null;
								this.repaint();
							}
							else {
								tempconnection = null;
							}
						}
					}
				}
			}
			else {
				RectangleButton btn = (RectangleButton)obj;
				Point []points = btn.getPointsPosition();
				System.out.println(points[0]);
				System.out.println(points[1]);
				System.out.println(jX);
				if(jX == points[0].x || jX == points[2].x) {
					if(jY >= points[0].y && jY <= points[1].y) {
						if(tempconnection == null) {
							tempconnection = new Connection();
							tempconnection.setSourceX(btn.getBounds().x+jX);
							tempconnection.setSourceY(btn.getBounds().y+jY);
						}
						else if (tempconnection != null) {
							tempconnection.setDestX(btn.getBounds().x+jX);
							tempconnection.setDestY(btn.getBounds().y+jY);
							connections.add(tempconnection);
							tempconnection = null;
							this.repaint();
						}
						else {
							tempconnection = null;
						}
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		isMoved = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < this.connections.size(); i++) {
        		Connection finishedconnection = connections.get(i);
            	Line2D shape = new Line2D.Double();
            	originX = finishedconnection.getSourceX();
            	originY = finishedconnection.getSourceY();
    			shape.setLine(finishedconnection.getSourceX(), finishedconnection.getSourceY(), finishedconnection.getDestX(), finishedconnection.getDestY());
    			Graphics2D g2 = (Graphics2D) g;
    			g2.draw(shape);
        }
        if(isMoved) {
        	Line2D shape = new Line2D.Double();
			shape.setLine(originX, originY, destinationX, destinationY);
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(shape);
        }
    }
}
