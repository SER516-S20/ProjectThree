import java.awt.Color;
import java.awt.Graphics;

/**
 * interface shape which is implemented by circle, triangle and square
 * @author Nachiappan Lakshmanan
 * @version 1.0
 * @since 01/29/2020
 */
public interface Shape {
    
	public void setLinePosition(int x, int y, int x1, int y1);
	public void setPosition(int x, int y);
	public void setColor(Color color);
	public void draw(Graphics g, boolean status, int width, int height);

}
