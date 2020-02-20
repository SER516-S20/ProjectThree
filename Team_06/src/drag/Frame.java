package drag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Frame extends JFrame{

	/**
	 * 
	 */
    // menubar 
    static JMenuBar mb; 
    // Jlabel to show the files user selects 
    static JLabel l; 
    // JMenu 
    static JMenu x; 
  
    // Menu items 
    static JMenuItem m1, m2;
	private static final long serialVersionUID = 1L;
	private static final String[] panelNames = {"drag.LeftPanel", "drag.RightPanel"};
	private JPanel[] panels = new JPanel[15];
	private JTextField dir = new JTextField();
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
	    
        // create a menubar 
        mb = new JMenuBar(); 
        // create a menu 
        x = new JMenu("Menu"); 
  
        // create menuitems 
        m1 = new JMenuItem("save"); 
        m2 = new JMenuItem("open"); 
        
        // set the label to its initial value 
        l = new JLabel("no file selected"); 
        // add ActionListener to menuItems 
        m1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Using this process to invoke the contructor, 
				// JFileChooser points to user's default directory 
				JFileChooser j = new JFileChooser(); 

				// invoke the showsSaveDialog function to show the save dialog 
	            int r = j.showSaveDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	                // set the label to the path of the selected file 
	                //l.setText(j.getSelectedFile().getAbsolutePath()); 
	                try(FileWriter fw = new FileWriter(j.getSelectedFile()+".txt")) {
	                    fw.write("asdas");
	                } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            } 
	            // if the user cancelled the operation 
	            else
	                l.setText("the user cancelled the operation"); 
			}
		});
        
        m2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Using this process to invoke the contructor, 
				// JFileChooser points to user's default directory 
				JFileChooser j = new JFileChooser(); 
				  
				// invoke the showsSaveDialog function to show the save dialog 
	            int r = j.showSaveDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	                // set the label to the path of the selected file 
	                l.setText(j.getSelectedFile().getAbsolutePath()); 
	            } 
	            // if the user cancelled the operation 
	            else
	                l.setText("the user cancelled the operation"); 
			}
		});
        // add menu items to menu 
        x.add(m1); 
        x.add(m2); 
  
        // add menu to menu bar 
        mb.add(x); 
  
        // add menubar to frame 
        this.setJMenuBar(mb); 

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
