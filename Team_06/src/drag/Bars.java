package drag;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

/**
 * @author Sheran, Somesh
 * @since 02-19-2019
 */

public class Bars extends JButton{
    public static int endx = 0;
    public static int endy = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;
    public static int startx = 0;
    public static int starty = 0;
    public static int lineflag = 0;

    public Bars(String label, int x, int y, boolean flag) {

        super(label);
        Dimension size = getPreferredSize();
        setPreferredSize(size);
        setBounds(x, y, 10, 55);
        setBorder(new EmptyBorder(0, 0, 55, 10));

        setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getSize().width-1, getSize().height-1);
    }
}
