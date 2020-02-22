import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author somesh
 * @since 02-28-2020
 */

public class Dot extends JButton{
	
	Dot(int x, int y){
		setBounds(x, y, 7, 7);
	    setBorder(new EmptyBorder(7, 7, 0, 0));
	    
	    //new DrawLine(this);
	}
	
	@Override
    protected void paintComponent(Graphics g){
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(getBackground());
        }
        
        g.fillOval(0, 0, getSize().width, getSize().height);
        super.paintComponent(g);        
    }

    protected void paintBorder(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, getSize().width, getSize().height);
    }
}
