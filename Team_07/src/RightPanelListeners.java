import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Karandeep Singh Grewal
 * @author Aravind Thillai Villalan
 * @since 01-29-2020
 */

public class RightPanelListeners {
    MouseEvent one, two;

    public void addRightPanelListeners(JPanel panel) {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                boolean isShapeClicked = false;
                for (Shapes s : RightPanel.shapesList
                )
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                        isShapeClicked = true;
                        if (s.isDotOrBarClicked(mouseEvent))
                            if (one == null)
                                one = mouseEvent;
                            else if (one != null)
                                two = mouseEvent;
                    }

                if (two != null) {
                    Lines line = new Lines(one.getX(), one.getY(), two.getX(), two.getY());
                    RightPanel.shapesList.add(line);
                    one = two = null;
                }
                if (!isShapeClicked) {
                    if (LeftPanel.selectedShape instanceof Triangle) {
                        RightPanel.shapesList.add(new Triangle(mouseEvent.getX(), mouseEvent.getY()));
                    }
                    if (LeftPanel.selectedShape instanceof Square) {
                        RightPanel.shapesList.add(new Square(mouseEvent.getX(), mouseEvent.getY()));
                    }
                    if (LeftPanel.selectedShape instanceof Circle) {
                        RightPanel.shapesList.add(new Circle(mouseEvent.getX(), mouseEvent.getY()));
                    }
                }

                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                    else
                        RightPanel.selectedShape = null;
                }
                System.out.println(RightPanel.shapesList);
                panel.repaint();
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
                RightPanel.selectedShape = null;
            }
        });
        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

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
