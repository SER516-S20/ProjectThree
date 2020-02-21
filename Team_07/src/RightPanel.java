import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karandeep Singh Grewal
 * @author Aditya Bajaj
 * @author Praveen
 * @since 01-29-2020
 */

//right panel where we create shapes
public class RightPanel extends JPanel {
    public static List<Shapes> shapesList = new ArrayList<>();
    public static Shapes selectedShape;

    RightPanel() {
        this.setBounds(200, 0, 800, 800);
        new RightPanelListeners().addRightPanelListeners(this);
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, 800, 800);
        for (Shapes s : shapesList
        ) {
            s.createShape(graphics);
        }
    }
}