import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karandeep Singh Grewal
 * @author Aravind Thillai Villalan
 * @since 01-29-2020
 */

public class RightPanelListeners {
    MouseEvent one, two;
    List<Integer> offsetX = new ArrayList<Integer>();
    List<Integer> offsetY = new ArrayList<Integer>();
    List<Lines> linesList = new ArrayList<Lines>();
    List<Boolean> srcOrDest = new ArrayList<Boolean>();

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

                //Adds lines when user selects two dots or bars
                if (two != null) {
                    Lines line = new Lines(one.getX(), one.getY(), two.getX(), two.getY());
                    RightPanel.shapesList.add(line);
                    one = two = null;
                }

                //Adds the selected shape to right panel
                if (!isShapeClicked) {
                    createShape(mouseEvent);
                }

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
                for (Shapes s : RightPanel.shapesList
                ) {
                    if (s instanceof Lines) {
                        Point lineStart = ((Lines) s).getCoordinatesOne();
                        if (RightPanel.selectedShape.isInside(lineStart.x, lineStart.y)) {
                            linesList.add((Lines) s);
                            offsetX.add(lineStart.x - RightPanel.selectedShape.xCoordinate);
                            offsetY.add(lineStart.y - RightPanel.selectedShape.yCoordinate);
                            srcOrDest.add(true);
                        }
                        Point lineEnd = ((Lines) s).getCoordinatesTwo();
                        if (RightPanel.selectedShape.isInside(lineEnd.x, lineEnd.y)) {
                            linesList.add((Lines) s);
                            offsetX.add(lineEnd.x - RightPanel.selectedShape.xCoordinate);
                            offsetY.add(lineEnd.y - RightPanel.selectedShape.yCoordinate);
                            srcOrDest.add(false);
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                RightPanel.selectedShape = null;
                linesList.clear();
                offsetY.clear();
                offsetX.clear();
                srcOrDest.clear();
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
                for (int i = 0; i < linesList.size(); i++) {
                    if (srcOrDest.get(i))
                        linesList.get(i).changeSourceLocation(mouseLocationX + offsetX.get(i),
                                mouseLocationY + offsetY.get(i));
                    else
                        linesList.get(i).changeDestinationLocation(mouseLocationX + offsetX.get(i),
                                mouseLocationY + offsetY.get(i));
                }

                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
    }

    public void createShape(MouseEvent mouseEvent) {
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
}
