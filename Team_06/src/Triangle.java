import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/** 
 * @author Rahul Sheran
 * @since 01-29-2019
 * @Description: The class creates a button component with triangle.
 */
public  class Triangle extends JButton {
	Triangle(String label, int x, int y, boolean rightPanel){
		super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);
        setBounds(x, y, size.width, size.height);
        setBorder(new EmptyBorder(x, y, 5, 5));       
        setContentAreaFilled(false);
        
        if (rightPanel){
        	Dot dot1 = new Dot(8,64);
            this.add(dot1);
            Dot dot2 = new Dot(33,10);
            this.add(dot2);
            Dot dot3 = new Dot(60,64);
            this.add(dot3);
        	
        	new Drag(this);	
        }
	}

    @Override
    protected void paintComponent(Graphics g)  {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(getBackground());
        }
        g.fillPolygon(new int[] {0, (getSize().width-1)/2 , getSize().width-1},
        			  new int[] {getSize().height-1, 0,  getSize().height-1}, 3);
        g.fillOval(8, 64, 7, 7);
        g.fillOval(33, 10, 7, 7);
        g.fillOval(60, 64, 7, 7);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawPolygon(new int[] {0, (getSize().width)/2 , getSize().width},
        			  new int[] {getSize().height, 0,  getSize().height}, 3);
        g.drawOval(8, 64, 7, 7);
        g.drawOval(33, 10, 7, 7);
        g.drawOval(60, 64, 7, 7);
    }
}
