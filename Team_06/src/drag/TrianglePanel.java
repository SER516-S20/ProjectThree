package drag;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Path2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class TrianglePanel extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Line2D.Double(10, 10, 40, 40));
	}



	public static void main (String [] args)
	{
		TrianglePanel component = new TrianglePanel();
	    JFrame frame = new JFrame ();
	    final int FRAME_WIDTH = 250;
	    final int FRAME_HEIGHT = 250;
	    frame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("A Test Frame");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.add(component);
	}
}

/*
 * public class TrianglePanel extends JButton {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * public TrianglePanel() {
 * 
 * super(""); Dimension size = getPreferredSize(); size.width = size.height =
 * Math.max(size.width, size.height); setPreferredSize(size);
 * setContentAreaFilled(false); }
 * 
 * protected void paintComponent(Graphics g) { if (getModel().isArmed()) {
 * g.setColor(Color.lightGray); } else { g.setColor(getBackground()); } int
 * xPoints[] = {getSize().width/2, 0, getSize().width}; int yPoints[] = {0,
 * getSize().height, getSize().height}; g.fillPolygon(xPoints, yPoints,
 * xPoints.length); super.paintComponent(g); } protected void
 * paintBorder(Graphics g) { g.setColor(getForeground()); int xPoints[] =
 * {getSize().width/2, 0, getSize().width}; int yPoints[] = {0,
 * getSize().height, getSize().height}; g.drawPolygon(xPoints, yPoints,
 * xPoints.length); } Polygon polygon; public boolean contains(int x, int y) {
 * if (polygon == null || !polygon.getBounds().equals(getBounds())) { int
 * xPoints[] = {getSize().width/2, 0, getSize().width}; int yPoints[] = {0,
 * getSize().height, getSize().height}; polygon = new Polygon(xPoints,yPoints,
 * xPoints.length); } return polygon.contains(x, y); } }
 */