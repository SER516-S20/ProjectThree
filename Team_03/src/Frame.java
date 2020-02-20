
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        
        JMenuItem openMenuItem = new JMenuItem("Open File");
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	
            	DrawingArea obj1 = new DrawingArea();
            	obj1.load();
            	obj1.repaintOnDrag();
            }
                // Open saved state
        });

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save current state
            	DrawingArea obj2 = new DrawingArea();
            	obj2.save();
            }
        });

        file.add(openMenuItem);
        file.add(saveMenuItem);
        menubar.add(file);
        setJMenuBar(menubar);
    }

}