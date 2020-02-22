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
    final int LEFT_PANEL_SHAPES_X = 100;
    final int[] LEFT_PANEL_SHAPES_Y = {100, 250, 400};

    LeftPanel() {
        this.setBounds(0, 0, 200, 800);
        shapesList.add(new Triangle(LEFT_PANEL_SHAPES_X, LEFT_PANEL_SHAPES_Y[0]));
        shapesList.add(new Circle(LEFT_PANEL_SHAPES_X, LEFT_PANEL_SHAPES_Y[1]));
        shapesList.add(new Square(LEFT_PANEL_SHAPES_X, LEFT_PANEL_SHAPES_Y[2]));
        new LeftPanelListeners().addLeftPanelListeners(this);
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 200, 800);
        for (Shapes s : shapesList) {
            s.createShape(graphics);
        }
    }
}