import javax.swing.*;
import java.awt.*;

/**
 * @author Somesh
 * @since 02-19-2020
 */
public class Frame extends JFrame
{
    
	Frame(){
		
		this.setTitle("Project");
	    this.setMinimumSize(new Dimension(800, 600));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JMenuBar menu = new Menu();
	    JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
	    getContentPane().add(addPanels());
	    
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
    
	//This method splits the frame into two panels.
	public JSplitPane addPanels(){
	    LeftPanel leftPanel = new LeftPanel();
	    RightPanel rightPanel = new RightPanel();
	    
	    try{
	        JSplitPane splitPane = new JSplitPane();
	        splitPane.setSize(800, 600);
	        splitPane.setDividerSize(0);
	        splitPane.setDividerLocation(150);
	        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	        splitPane.setLeftComponent(leftPanel);
	        splitPane.setRightComponent(rightPanel);
		    return splitPane;
		}
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public static void main(String[] args){
		new Frame();
	}
}
