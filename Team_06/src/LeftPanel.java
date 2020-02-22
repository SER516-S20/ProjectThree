import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	LeftPanel(){
		
		this.setBackground(Color.decode("#ffffff"));
		
		Triangle triangle = new Triangle("", 0, 0, false);     
		this.add(triangle);
		this.add(Box.createVerticalStrut(140)); 
		
		Circle circle = new Circle("", 0, 0, false);
		this.add(circle);               
		this.add(Box.createVerticalStrut(250));
		
		Square square = new Square("", 0, 0, false);          
		this.add(square);     
		
		SelectShape ss = new SelectShape();
		ss.select(triangle, 1);
		ss.select(circle, 2);
		ss.select(square, 3);
	}
	
	
	
}
