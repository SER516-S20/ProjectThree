package drag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Suyog, Somesh, Dhananjay, Rahul, Sheran
 * @since 02-19-2019
 */
public class Frame extends JFrame
{
    static JMenuBar mb; 
    static JLabel l;  
    static JMenu x; 
 
    static JMenuItem m1, m2;
    private static final long serialVersionUID = 1L;
    private static final String[] panelNames = {"drag.LeftPanel", "drag.RightPanel"};
    private JPanel[] panels = new JPanel[15];
    private JTextField dir = new JTextField();

    Frame(String name) 
    { 
        mb = new JMenuBar();  
        x = new JMenu("Menu"); 
        m1 = new JMenuItem("save"); 
        m2 = new JMenuItem("open");  
        l = new JLabel("no file selected"); 
 
        m1.addActionListener(new ActionListener() 
        {			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList shapeList = RightPanel.getInstance().shapesList;
//				ArrayList<Point> circlepoints = RightPanel.getInstance().circlePoints;
//				ArrayList<Point> trianglepoints = RightPanel.getInstance().trianglePoints;
//				ArrayList<Point> squarepoints = RightPanel.getInstance().squarePoints;
				JFileChooser j = new JFileChooser(); 

				// invoke the showsSaveDialog function to show the save dialog 
	            int r = j.showSaveDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	            { 
	                // set the label to the path of the selected file  
	                try(FileWriter fw = new FileWriter(j.getSelectedFile()+".txt")) 
	                {
	                	fw.write(String.valueOf(shapeList));
//	                	for(Point point: circlepoints)
//	                	{
//		      			    fw.write("Circle " + point.x +" " + point.y + System.lineSeparator());
//	                    }
//	                	for(Point point: trianglepoints)
//	                	{
//		      			    fw.write("Triangle " + point.x +" " + point.y + System.lineSeparator());
//	                    }
//	                	for(Point point: squarepoints)
//	                	{
//		      			    fw.write("Square " + point.x +" " + point.y + System.lineSeparator());
//	                    }

	                	fw.close();
	                }
	                catch (IOException e1) {
	                	e1.printStackTrace();
					}
	            } 
	            // if the user cancelled the operation 
	            else
	                l.setText("the user cancelled the operation"); 
			}
		});
        
        m2.addActionListener(new ActionListener() 
        {			
			@Override
			public void actionPerformed(ActionEvent e) 
			{ 
				JFileChooser j = new JFileChooser();  
	            int r = j.showSaveDialog(null); 
	   
	            if (r == JFileChooser.APPROVE_OPTION) 
	            {  
	                l.setText(j.getSelectedFile().getAbsolutePath()); 
	            }  
	            else
	                l.setText("the user cancelled the operation"); 
			}
		});
 
        x.add(m1); 
        x.add(m2);  
        mb.add(x); 
 
        this.setJMenuBar(mb); 
		this.setTitle(name);
	    this.setMinimumSize(new Dimension(800, 600));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().add(addPanels());
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
    
	//This method splits the frame into two panels.
	public JSplitPane addPanels()
	{
	    for(int thePanel = 0; thePanel < panelNames.length; thePanel++) 
	    {
		   try 
		   {
			   Class<?> panelClass = Class.forName(panelNames[thePanel]);
			   JPanel panel = (JPanel) panelClass.getDeclaredConstructor().newInstance();
			   panels[thePanel] = panel;
		   }
		   catch(Exception e) 
		   {
			   addError(panelNames[thePanel]);
		   }
	    }
	    try 
	    {
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
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	    
	    return null;
	}
	
	private void addError(String panelNumber) 
	{
		System.out.println("ERROR");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Panel " + panelNumber + " Error");
		panel.add(label);
		add(panel);
	}
}
