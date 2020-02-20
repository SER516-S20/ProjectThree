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
 * @author: Suyog, Dhananjay
 * @Date: 01/28/2020
 */
public class RightPanel extends PanelInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int finalFlag = 0;
	private static RightPanel single_instance = null;

	public static RightPanel getInstance() {
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}

	public ArrayList<Point> points;
	public ArrayList<Point> circlePoints = new ArrayList<Point>();
	public ArrayList<Point> squarePoints = new ArrayList<Point>();
	public ArrayList<Point> trianglePoints = new ArrayList<Point>();

	public RightPanel() {

		super("#666666", 150, 20);
		this.circlePoints = new ArrayList<Point>();
		System.out.println("Inside Left Panel");
		points = new ArrayList<Point>();
		/*
		 * JButton circle = new Circle("Circle", 0, 0); this.add(circle);
		 * System.out.println(this); JButton circle1 = new Circle("Circle", 0, 0);
		 * this.add(circle1);
		 */

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Right panel click");
				points.add(new Point(e.getX(), e.getY()));

				finalFlag = RightPanel.getInstance().finalFlag;
				System.out.println("finalFlag " + finalFlag);
				if (finalFlag == 1) {
					System.out.println("Inside Circle Button");
					JButton circle = new Circle("", e.getX(), e.getY(), true);
					Object rp = e.getComponent();
					//System.out.println("rp " + rp);
					((RightPanel) rp).add(circle);
					RightPanel.getInstance().circlePoints.add(new Point( e.getX(), e.getY()));
					
					repaint();
				}
				else if (finalFlag == 2) {
					System.out.println("Inside Square Button");
					JButton square = new Square("", e.getX(), e.getY(), true);
					Object rp = e.getComponent();
					((PanelInterface) rp).add(square);
					RightPanel.getInstance().squarePoints.add(new Point( e.getX(), e.getY()));
					repaint();
				}
				else if(finalFlag == 3) {	        	
	        		System.out.println("Inside Triangle Button");
	        		JButton triangle = new Triangle("", e.getX(), e.getY(), true);
	          		Object rp = e.getComponent();
	          		((PanelInterface) rp).add(triangle); 
	          		RightPanel.getInstance().trianglePoints.add(new Point( e.getX(), e.getY()));
	          		repaint();
	     	    }

				/*
				 * System.out.println(circlePoints); System.out.println(squarePoints);
				 * System.out.println(trianglePoints); // repaint(); System.out.println(points);
				 * System.out.println(finalFlag);
				 * System.out.println(RightPanel.getInstance().finalFlag);
				 */
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int temp = points.size() - 1;
		finalFlag = RightPanel.getInstance().finalFlag;
		
		  if (finalFlag == 1) 
		  { 
			  //circlePoints.add(new Point(points.get(temp).x,points.get(temp).y)); 
			  System.out.println(circlePoints); 
		  } 
		  else if (finalFlag== 2) 
		  { 
			  squarePoints.add(new Point(points.get(temp).x, points.get(temp).y));
		  } 
		  else if (finalFlag == 3) 
		  { 
			  trianglePoints.add(new Point(points.get(temp).x,points.get(temp).y)); 
		  }
		  
}
}
