package drag;
import java.awt.Dimension;
import javax.swing.*;
//import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** 
 * @author Sheran
 * @since 01-29-2019
 */
public abstract class ObjectInterface extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectInterface(String label, int x, int y) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);
        setBounds(x, y, size.width, size.height);
//        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(new EmptyBorder(x, y, 5, 5));
        
        setContentAreaFilled(false);
    }
}
