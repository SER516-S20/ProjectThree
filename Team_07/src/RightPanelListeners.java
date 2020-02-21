import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Karandeep Singh Grewal
 * @since 01-29-2020
 */

public class RightPanelListeners {
    public void addRightPanelListeners(JPanel panel) {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (LeftPanel.selectedShape instanceof Triangle) {
                    RightPanel.shapesList.add(new Triangle(mouseEvent.getX() - 50, mouseEvent.getY() - 43));
                }
                if (LeftPanel.selectedShape instanceof Square) {
                    RightPanel.shapesList.add(new Square(mouseEvent.getX() - 50, mouseEvent.getY() - 50));
                }
                if (LeftPanel.selectedShape instanceof Circle) {
                    RightPanel.shapesList.add(new Circle(mouseEvent.getX() - 50, mouseEvent.getY() - 50));
                }
                panel.repaint();
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                RightPanel.selectedShape = null;
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                }
                int mouseLocationX = mouseEvent.getX() - 50;
                int mouseLocationY = mouseEvent.getY() - 50;
                if (mouseLocationX > 700) {
                    mouseLocationX = 700;
                } else if (mouseLocationX < 0) {
                    mouseLocationX = 0;
                }
                if (mouseLocationY > 670) {
                    mouseLocationY = 670;
                } else if (mouseLocationY < 0) {
                    mouseLocationY = 0;
                }
                RightPanel.selectedShape.changeLocation(mouseLocationX,
                        mouseLocationY);
                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
    }
}
