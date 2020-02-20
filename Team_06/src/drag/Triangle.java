package drag;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/** 
 * @author Rahul Sheran
 * @since 01-29-2019
 * @Description: The class creates a button component with triangle.
 */
public  class Triangle extends ObjectInterface 
{
	private static final long serialVersionUID = 1L;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;

	/**
	 * @param x - x coordinate for triangle.
	 * @param y - y coordinate for triangle.
	 */
	public Triangle(String label, int x, int y, boolean flag) 
	{
        super(label, x, y);
        Dot dot1 = new Dot("",32,15,true);
		this.add(dot1);		
		Dot dot2 = new Dot("",15,55,true);
		this.add(dot2);		
		Dot dot3 = new Dot("",50,55,true);
		this.add(dot3);
        
        if (flag) 
        {
        	addMouseListener(new MouseListener() 
        	{
    			@Override
    			public void mouseClicked(MouseEvent e) {
    			}

    			@Override
    			public void mousePressed(MouseEvent e) 
    			{
    				screenX = e.getXOnScreen();
    				screenY = e.getYOnScreen();
    				myX     = getX();
    				myY     = getY();
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

    		});
        	
    		addMouseMotionListener(new MouseMotionListener() 
    		{
    			@Override
    			public void mouseDragged(MouseEvent e) 
    			{
    				int deltaX = e.getXOnScreen() - screenX;
    				int deltaY = e.getYOnScreen() - screenY;
    				setLocation(myX + deltaX, myY + deltaY);
    			}

    			@Override
    			public void mouseMoved(MouseEvent e) {
    			}
    		});
        }      
    }
	
    @Override
    protected void paintComponent(Graphics g) 
    {
        if (getModel().isArmed()) 
        {
            g.setColor(Color.lightGray);
        } 
        else 
        {
            g.setColor(getBackground());
        }
        
        g.fillPolygon(new int[] {0, (getSize().width-1)/2 , getSize().width-1},
        			  new int[] {getSize().height-1, 0,  getSize().height-1}, 3);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawPolygon(new int[] {0, (getSize().width-1)/2 , getSize().width-1},
        			  new int[] {getSize().height-1, 0,  getSize().height-1}, 3);
    }
}
