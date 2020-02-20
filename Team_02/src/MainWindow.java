import javax.swing.*;

/**
 * @author Kunal Sharma
 * @created on 01-27-2020
 * @version 1.0
 */
public class MainWindow {
    java.util.List<Point> displayList = new ArrayList<Point>();
    String pathname = "data.dat";
      JButton clearBtn = new JButton("Clear");
  JButton saveBtn = new JButton("Save");
  JButton restoreBtn = new JButton("Restore");
  JButton quitBtn = new JButton("Quit");
  
   
    
    public static void main(String[] args)
    {
       
    
        Menu objMenu = new Menu();
        JFrame frame = new JFrame("Main Window");
        //JPanel frame = new JPanel();
        frame.setVisible(true);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.add(objMenu.CreateMenu());
        
        JSplitPane splitPane2 = new JSplitPane();
        splitPane2.setSize(900, 900);
        splitPane2.setDividerSize(0);
        splitPane2.setDividerLocation(200);
        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
      
        splitPane2.setTopComponent(new PanelToolkit());
        splitPane2.setBottomComponent(new DrawBoardPanel());
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel,splitPane2);      
        frame.add(splitPane1);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
    }
}
