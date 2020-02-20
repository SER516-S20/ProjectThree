package drag;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Suyog, Dhananjay, Somesh
 * @Date: 01/28/2020
 * @Description: This panel will have different figures.
 */
public class LeftPanel extends PanelInterface 
{
	private static final long serialVersionUID = 1L;
	
	//Defining x, y coordinates of shapes in left panel.
	LeftPanel() 
	{
		super("#ffffff",1,20);
		JButton circle = new Circle("", 50, 50, false);
		this.add(circle);               
		this.add(Box.createVerticalStrut(100));

		circle.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
		        if (circle.isEnabled()) 
		        {
		        	RightPanel.getInstance().finalFlag = 1;
		        }				
			}
		});
		
		JButton square = new Square("", 50, 50, false);          
		this.add(square);                       
		this.add(Box.createVerticalStrut(200)); 	
		
		square.addActionListener(new ActionListener() 
		{			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
		        if (square.isEnabled()) 
		        {
		        	RightPanel.getInstance().finalFlag = 2;
		        }				
			}
		});
		
		JButton Triangle = new Triangle("", 50, 50, false);     
		this.add(Triangle);   
		
		Triangle.addActionListener(new ActionListener() 
		{			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
		        if (Triangle.isEnabled()) 
		        {
		        	RightPanel.getInstance().finalFlag = 3;
		        }		        			
			}
		});						
	}
}
