import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Praveen Kumar
 * @since 02-20-2020
 */

public class LeftPanel extends JPanel {
    public static Shapes selectedShape = null;
    public static List<Shapes> shapesList = new ArrayList<>();

    LeftPanel() {
        this.setBounds(0, 0, 200, 800);
        shapesList.add(new Triangle(50, 50));
        shapesList.add(new Circle(50, 200));
        shapesList.add(new Square(50, 350));
        new LeftPanelListeners().addLeftPanelListeners(this);
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 200, 800);
        for (Shapes s : shapesList
        ) {
            s.createShape(graphics);
        }
    }
}