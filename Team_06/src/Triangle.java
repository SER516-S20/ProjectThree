import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/** 
 * @author Rahul Sheran
 * @since 01-29-2019
 * @Description: The class creates a button component with triangle.
 */
public  class Triangle extends JButton {
	Triangle(String label, int x, int y, boolean flag){
		super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);
        setBounds(x, y, size.width, size.height);
        setBorder(new EmptyBorder(x, y, 5, 5));       
        setContentAreaFilled(false);
        
        if (flag){
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
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawPolygon(new int[] {0, (getSize().width)/2 , getSize().width},
        			  new int[] {getSize().height, 0,  getSize().height}, 3);
    }
}
