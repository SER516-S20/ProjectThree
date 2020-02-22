import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
/**
 * 
 * @author Suyog
 * @Since 02-16-2020
 */
public class FileManager {
	
	FileManager(JMenuItem save,JMenuItem open){
		
		JLabel file = new JLabel("no file selected");
		
		save.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<Point> circlePoints = RightPanel.getInstance().circlePoints;
				ArrayList<Point> trianglePoints = RightPanel.getInstance().trianglePoints;
				ArrayList<Point> squarePoints = RightPanel.getInstance().squarePoints;
				JFileChooser fileChooser = new JFileChooser(); 
				
				// invoke the showsSaveDialog function to show the save dialog 
	            int r = fileChooser.showSaveDialog(null);
	            
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION){ 
	                // set the label to the path of the selected file  
	                try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile()+".txt")) {
	                	for(Point point: circlePoints){
		      			    fw.write("Circle " + point.x +" " + point.y + System.lineSeparator());
	                    }
	                	for(Point point: trianglePoints){
		      			    fw.write("Triangle " + point.x +" " + point.y + System.lineSeparator());
	                    }
	                	for(Point point: squarePoints){
		      			    fw.write("Square " + point.x +" " + point.y + System.lineSeparator());
	                    }
	                	fw.close();
	                }
	                catch (IOException e1) {
	                	e1.printStackTrace();
					}
	            } 
	            // if the user cancelled the operation 
	            else
	                file.setText("the user cancelled the operation"); 
			}
		});
    
		open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){ 
				JFileChooser j = new JFileChooser();  
				int r = j.showOpenDialog(null); 
				
				if (r == JFileChooser.APPROVE_OPTION) {  
                file.setText(j.getSelectedFile().getAbsolutePath()); 
				}  
				else
					file.setText("the user cancelled the operation"); 
			}
		});

		 
	}
}
