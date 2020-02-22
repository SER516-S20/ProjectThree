import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Sheran
 * @since 02-28-2020
 */

public class Bar extends JButton{
	
	Bar(int x, int y){
		setBounds(x, y, 10, 60);
	    setBorder(new EmptyBorder(10, 60, 0, 0));
	    
	    new DrawLine(this);
	}
	
	@Override
    protected void paintComponent(Graphics g){
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(getBackground());
        }
        
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.fillRect(10, 7, 10, 60);
        g.fillRect(55, 7, 10, 60);
        super.paintComponent(g);        
    }

    protected void paintBorder(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.drawRect(10, 7, 10, 60);
        g.drawRect(55, 7, 10, 60);
    }
}
