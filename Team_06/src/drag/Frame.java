package drag;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] panelNames = {"drag.LeftPanel", "drag.RightPanel"};
	private JPanel[] panels = new JPanel[15];
	// This is the constructor for the FrameClass class
	Frame(String name) {
		System.out.println("Inside Frame Constructor");

		this.setTitle(name);
	    this.setMinimumSize(new Dimension(800, 600));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().add(addPanels());
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);

	}
	//This method splits the frame into two panels. It is basically adding two panels with a division pre-defined as per user's desire.
	public JSplitPane addPanels(){
		System.out.println("Inside Add Panels");
//	    Class<?> panelClass1;
//	    Class<?> panelClass2;
	    for(int thePanel = 0; thePanel < panelNames.length; thePanel++) {

		   try {

			   Class<?> panelClass = Class.forName(panelNames[thePanel]);
			   JPanel panel = (JPanel) panelClass.getDeclaredConstructor().newInstance();
			   panels[thePanel] = panel;

		   }
		   catch(Exception e) {

			   addError(panelNames[thePanel]);

		   }
	    }
	    try {
	    	System.out.println(panels);
	        JSplitPane splitPane = new JSplitPane();
	        splitPane.setSize(800, 600);
	        splitPane.setDividerSize(0);
	        splitPane.setDividerLocation(150);
	        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	        splitPane.setLeftComponent(panels[0]);
	        splitPane.setRightComponent(panels[1]);
	        System.out.println("Done");
		    return splitPane;

			}
	    catch (Exception e) {

	    	e.printStackTrace();

	    }
	    return null;

	}
	// This method is used to throw error message for a specific case where the two panels are not defined in the PANEL_NAMES list.
	private void addError(String panelNumber) {
		System.out.println("ERROR");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Panel " + panelNumber + " Error");
		panel.add(label);
		add(panel);

	}
	

}
