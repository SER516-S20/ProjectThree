import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	LeftPanel(){
		
		this.setBackground(Color.decode("#ffffff"));
		
		JButton triangle = new Triangle("", 50, 50, false);     
		this.add(triangle);
		this.add(Box.createVerticalStrut(130)); 
		
		JButton circle = new Circle("", 50, 50, false);
		this.add(circle);               
		this.add(Box.createVerticalStrut(200));
		
		JButton square = new Square("", 50, 50, false);          
		this.add(square);     
		
		SelectShape ss = new SelectShape();
		ss.select(triangle, 1);
		ss.select(circle, 2);
		ss.select(square, 3);
	}
	
	
	
}
