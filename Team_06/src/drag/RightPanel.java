package drag;
import java.io.*;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.FileWriter;

import javax.swing.JButton;

/**
 * @author: Suyog, Dhananjay, Somesh
 * @Date: 01/28/2020
 * @Description: Right Panel will have different shapes which are selected in left panel.
 */
public class RightPanel extends PanelInterface 
{
	private static final long serialVersionUID = 1L;
	public int finalFlag = 0;
	private static RightPanel single_instance = null;

	public static RightPanel getInstance() 
	{
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}

	public ArrayList<Point> points;
	public ArrayList<Point> circlePoints = new ArrayList<Point>();
	public ArrayList<Point> squarePoints = new ArrayList<Point>();
	public ArrayList<Point> trianglePoints = new ArrayList<Point>();

	public RightPanel() 
	{
		super("#666666", 150, 20);
		this.circlePoints = new ArrayList<Point>();
		points = new ArrayList<Point>();

		addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				points.add(new Point(e.getX(), e.getY()));
				finalFlag = RightPanel.getInstance().finalFlag;

				if (finalFlag == 1) 
				{
					JButton circle = new Circle("", e.getX(), e.getY(), true);
					Object rp = e.getComponent();
					((RightPanel) rp).add(circle);
					RightPanel.getInstance().circlePoints.add(new Point( e.getX(), e.getY()));					
					repaint();
				}
				else if (finalFlag == 2) 
				{
					JButton square = new Square("", e.getX(), e.getY(), true);
					Object rp = e.getComponent();
					((PanelInterface) rp).add(square);
					RightPanel.getInstance().squarePoints.add(new Point( e.getX(), e.getY()));
					repaint();
				}
				else if(finalFlag == 3) 
				{	        	
	        		JButton triangle = new Triangle("", e.getX(), e.getY(), true);
	          		Object rp = e.getComponent();
	          		((PanelInterface) rp).add(triangle); 
	          		RightPanel.getInstance().trianglePoints.add(new Point( e.getX(), e.getY()));
	          		repaint();
	     	    }
			}
		});
	}
}
