package drag;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

public class Dot extends JButton {
	
	public static int endx = 0;
	public static int endy = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;
	public static int startx = 0;
	public static int starty = 0;
	public static int lineflag = 0; 
	
	
	public Dot(String label, int x, int y, boolean flag) {   
		
	        super(label);
	        Dimension size = getPreferredSize();
	        setPreferredSize(size);
	        setBounds(x, y, 10, 10);
	        setBorder(new EmptyBorder(0, 0, 10, 10));
	        
	        setContentAreaFilled(false);
	        
//	        if (flag) {
//				addMouseListener(new MouseListener() {
//
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						
//
//						myX = getX();
//						myY = getY();
//						
//						if(lineflag == 0) {
//							startx = e.getXOnScreen();
//							starty = e.getYOnScreen();
//							lineflag = 1;
//							System.out.println("clicked store");
//							System.out.printf("x1 : %d \n y1 : %d ",startx,starty );
//						}
//						else if(lineflag == 1)  {
//							endx = e.getXOnScreen();
//							endy = e.getYOnScreen();
//							
////							//DrawLine a =  new DrawLine(startx,starty,endx,endy);
////							TrianglePanel tp = new TrianglePanel();
////							
////							
////			          		System.out.println(e.getComponent().getParent().getParent()); 
////			          		Object rp = e.getComponent().getParent().getParent();
////			          		((RightPanel) rp).add(tp);
////			          		((RightPanel) rp).repaint();
//			          		
//			          	
////							lineflag = 0;
////					
////							System.out.println("clicked release");
////							System.out.printf("x2 : %d \n y2 : %d ",endx,endy );
//						}
//						
//					}
//
//					@Override
//					public void mousePressed(MouseEvent e) {
//						
//					}
//
//					@Override
//					public void mouseReleased(MouseEvent e) {
//						
//					}
//
//					@Override
//					public void mouseEntered(MouseEvent e) {
//					}
//
//					@Override
//					public void mouseExited(MouseEvent e) {
//					}
//
//				});
//				
//
//			}
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else {
            g.setColor(Color.BLUE);
        }
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
        
//        if (lineflag == 2) {
//        	Graphics2D g2 = (Graphics2D) g;
//        	g2.draw(new Line2D.Double(startx, starty, endx, endy));
//        	//g.drawLine(startx, starty, endx, endy);repaint();
//        	System.out.printf("x1 : %d \n y1 : %d ",startx,starty );
//        	System.out.printf("x2 : %d \n y2 : %d ",endx,endy );
//        	System.out.println("inside Line draw");
//        	lineflag = 0;
//        }
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);
    }
}
