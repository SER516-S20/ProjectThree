package drag;
import java.awt.*;
import javax.swing.*;

/**
 * author: Somesh, Suyog, Dhananjay
 * Date: 01/28/2020
 * Description: This is the abstract class for the two panels used in the FrameCLass. 
 * It extends JPanel and sets the background color for the panels.
 */
public abstract class PanelInterface extends JPanel
{
	private static final long serialVersionUID = 1L;

	//This is the constructor for the PanelInterface abstract class.
	PanelInterface(String s, int a, int b)
	{
		this.setBackground(Color.decode(s));
	}
}
