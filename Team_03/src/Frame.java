
import javax.swing.*;
import java.awt.*;

/**
 * @author srinivasan sundar
 * @since 01/26/2020
 * @version 1.0
 */
public class Frame extends JFrame{

    static DrawingArea drawingArea = new DrawingArea();

    Frame(){
        int frameHeight = 600;
        int frameWidth = 800;
        this.setTitle("Project Two - Team 3");
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(new Dimension(frameWidth, frameHeight ));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(drawingArea);
        this.getContentPane().add(new ShapePanel(), BorderLayout.WEST);
    }

}