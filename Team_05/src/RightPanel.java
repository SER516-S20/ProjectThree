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
import javax.swing.SwingUtilities;

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
	private ValuePane vPane;
	private TitledBorder titled;
	boolean isAlreadyOneClick=false;
	public RightPanel() {
		//valuePane = new ValuePane();
		this.setBackground(Color.red);
		shapes = new Hashtable<Integer, JButton>();
		
		//this.setLayout(null);
		//step = 50;
		addMouseListener(this);
		//addMouseMotionListener(this);
	}
	
	public void addButton(String btnCommand, int x, int y) {
		System.out.println("get in to the panel...." + btnCommand);
		ButtonBox btn = ButtonBoxFactory.buildButtonBox(btnCommand);
		addActionAndMouseMotionListener(btn);
		this.add(btn);
		this.autoLocation(btn,x-btn.getPreferredSize().width/2,y-btn.getPreferredSize().height/2);
		this.repaint();
		
	}
	private void addActionAndMouseMotionListener(ButtonBox button) {
		//JButton btn =  (JButton) button;
		//button.addActionListener(this);
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
	
	private void autoLocation(ButtonBox button,int x, int y) {
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
		System.out.println("....."+e.getSource());
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
	/*
	public String getTitleVal() {
		return valuePane.getvalue();
	}*/
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("=====" + e.getSource().getClass().getName() + ", " + e.getX() + ", " + e.getY());
		if(e.getSource().equals(this)) {
			Box instance = Box.getInstance();
			if(instance.text == null) {
				return;
			}
			addButton(instance.text,e.getX(),e.getY());
			System.out.println("====" + this.getComponentCount());
		}else {
			if (e.getClickCount() == 2) {
				Object source = e.getComponent();
				if(source instanceof JPanel){
					//JPanel panelPressed = (JPanel) source;
					ButtonBox panelPressed = (ButtonBox) source;
					if(vPane == null) {
						vPane = panelPressed.createJOptionPane();
						panelPressed.setTitle(vPane.getvalue());
					}else {
						vPane.setValue(panelPressed.getTitle());
						panelPressed.setTitle(vPane.getvalue());
					}
					/*
					panelPressed.putClientProperty("content", vPane.getValue());
					if(panelPressed.getClientProperty("content") == null) {
						panelPressed.putClientProperty("content", vPane.getvalue());
						panelPressed.setTitle(vPane.getvalue());
					}else {
				  		vPane.setValue((String)panelPressed.getClientProperty("content"));
				  		//valuePane.setValue(panelPressed.getTitle());
				  		//System.out.println("====" + panelPressed.getClientProperty("content"));
					}*/
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
	public void setConnection(Connection tempconnection) {
		connections.add(tempconnection);
		this.repaint();
	}
    public void paint(Graphics g) {
    	super.paint(g);
    	System.out.print("paint");
        for(int i = 0; i < this.connections.size(); i++) {
        	Connection finishedconnection = connections.get(i);
        	Line line = new Line();
        	line.setSource(finishedconnection.getSourceX(), finishedconnection.getSourceY());
        	line.setDest(finishedconnection.getDestX(), finishedconnection.getDestY());
        	line.draw(g);
        }
    }
}
