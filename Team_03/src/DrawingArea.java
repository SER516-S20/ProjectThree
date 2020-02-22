import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Ashutosh Dey
 * @author Chandan Yadav
 * @version 1.0
 * @since 01/28/2020
 */
public class DrawingArea extends JPanel {

	static ArrayList<Shape> listOfShapes = new ArrayList<>();
	private static final int DRAWING_AREA_HEIGHT = 600;
	private static final int DRAWING_AREA_WIDTH = 800;

	static final int TRIANGLE_SIZE = 60;

	static final int SQUARE_HEIGHT = 50;
	static final int SQUARE_WIDTH = 50;

	static final int CIRCLE_HEIGHT = 50;
	static final int CIRCLE_WIDTH = 50;

	static final int LINE_HEIGHT = 0;
	static final int LINE_WIDTH = 0;

	DrawingArea() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(DRAWING_AREA_WIDTH, DRAWING_AREA_HEIGHT));
		MouseListener mouseListener = new MouseListener();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < listOfShapes.size(); i++) {
			Object object = listOfShapes.get(i);
			if (object instanceof Square) {

				Square square = (Square) object;
				square.setColor(Color.BLUE);
				square.draw(g, true, SQUARE_HEIGHT, SQUARE_WIDTH);

			} else if (object instanceof Triangle) {

				Triangle triangle = (Triangle) object;
				triangle.draw(g, true, TRIANGLE_SIZE, TRIANGLE_SIZE);

			} else if (object instanceof Circle) {

				Circle circle = (Circle) object;
				circle.setColor(Color.RED);
				circle.draw(g, true, CIRCLE_HEIGHT, CIRCLE_WIDTH);

			} else {
				
				Line line = (Line) object;
				line.setColor(Color.ORANGE);
				line.draw(g, true, LINE_HEIGHT, LINE_WIDTH);
			}
		}
	}
	
	
    public void save()
    {
    	try
        {
            FileOutputStream fos = new FileOutputStream("listData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfShapes);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    	JOptionPane.showMessageDialog(null, "File Saved");
    }
    
    public void load()
    {
    	try
        {
            FileInputStream fis = new FileInputStream("listData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listOfShapes = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        //Verify list data
        for (Shape employee : listOfShapes) {
        	if (employee instanceof Circle)
        	{
        		((Circle) employee).getCoordinateX();
        		((Circle) employee).getCoordinateY();
        	}
        	if (employee instanceof Square)
        	{
        		((Square) employee).getCoordinateX();
        		((Square) employee).getCoordinateY();
        	}
        	if (employee instanceof Triangle)
        	{
        		((Triangle) employee).getCoordinateX();
        		((Triangle) employee).getCoordinateY();
        	}
        }
        Frame.drawingArea.repaintOnDrag();
    }

	void addSquare(Square square) {
		listOfShapes.add(square);
		repaint();
	}

	void addTriangle(Triangle triangle) {
		listOfShapes.add(triangle);
		repaint();
	}

	void addCircle(Circle circle) {
		listOfShapes.add(circle);
		repaint();
	}

	void addLine(Line line) {
		DrawingArea.listOfShapes.remove(Dots.currentLineObject);
		listOfShapes.add(line);
		repaint();
	}

	void repaintOnDrag() {
		repaint();
	}

}
