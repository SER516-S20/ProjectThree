package drag;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Suyog, Dhananjay
 * @Date: 01/28/2020
 */
public class LeftPanel extends PanelInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LeftPanel() {
		super("#ffffff",1,20);
		
		
		/*
		 * TrianglePanel tp = new TrianglePanel(); this.add(tp);
		 */
		
		
		
		System.out.println("Inside Left Panel");
		JButton circle = new Circle("", 50, 50, false);
		this.add(circle);               
		this.add(Box.createVerticalStrut(100));

		circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        if (circle.isEnabled()) {
		        	System.out.println("Button is pressed");
		        	RightPanel.getInstance().finalFlag = 1;
		        }				
			}
		});
		
		JButton square = new Square("", 50, 50, false);          
		this.add(square);                       
		this.add(Box.createVerticalStrut(200)); 	
		
		square.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        if (square.isEnabled()) {
		        	System.out.println("Button is pressed");
		        	RightPanel.getInstance().finalFlag = 2;
		        }				
			}
		});
		
		JButton Triangle = new Triangle("", 50, 50, false);     
		this.add(Triangle);   
		
		Triangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        if (Triangle.isEnabled()) {
		        	System.out.println("Button is pressed");
		        	RightPanel.getInstance().finalFlag = 3;
		        }
		        
				
			}
		});
		
		
		
	}

}