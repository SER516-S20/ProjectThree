import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/** 
 * @author Rahul, Sheran
 * @since 01-29-2019
 * @Description: The class creates a button component with square.
 */
public class Square extends JButton{

	/**
	 * @param x - x coordinate for circle.
	 * @param y - y coordinate for circle.
	 */
	public Square(String label, int x, int y, boolean flag) 
	{
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
    protected void paintComponent(Graphics g){
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getSize().width, getSize().height);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
    }
}
