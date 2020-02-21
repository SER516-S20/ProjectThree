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
    public void addRightPanelListeners(JPanel panel) {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                boolean isShapeClicked = false;
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                        isShapeClicked = true;
                        if (s instanceof Circle) {
                            System.out.println(((Circle) s).isDotClicked(mouseEvent));
                        } else if (s instanceof Triangle) {
                            System.out.println(((Triangle) s).isDotClicked(mouseEvent));
                        } else if (s instanceof Square) {
                            System.out.println(((Square) s).isBarClicked(mouseEvent));
                        }
                    }
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
                Lines testLine=new Lines(mouseEvent.getX(), mouseEvent.getY());
                testLine.setDestPointX(mouseEvent.getX()+50);
                testLine.setDestPointY(mouseEvent.getY()+50);
                RightPanel.shapesList.add(testLine);
                RightPanel.selectedLine=testLine;
                panel.repaint();
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                    else
                        RightPanel.selectedShape = null;
                }
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
                RightPanel.selectedLine.changeLocation(mouseLocationX, mouseLocationY);
                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
    }
}
