package drag;

import java.awt.Dimension;
import javax.swing.*;
//import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** 
 * @author Suyog, Dhananjay, Somesh
 * @since 01-29-2019
 * @Description: This is abstract class for all the panels
 */
public abstract class ObjectInterface extends JButton 
{
	private static final long serialVersionUID = 1L;
	
	/** 
	 * @param x  - x coordinate for the shape
	 * @param y  - y coordinate for the shape
	 */
	public ObjectInterface(String label, int x, int y) 
	{
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);
        setBounds(x, y, size.width, size.height);
        setBorder(new EmptyBorder(x, y, 5, 5));       
        setContentAreaFilled(false);
    }
}
