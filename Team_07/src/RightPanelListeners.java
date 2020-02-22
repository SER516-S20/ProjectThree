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
    final int RIGHT_PANEL_WIDTH = 700;
    final int RIGHT_PANEL_HEIGHT = 670;
    MouseEvent firstClick, secondClick;
    List<Integer> clickOffSetX = new ArrayList<Integer>();
    List<Integer> clickOffSetY = new ArrayList<Integer>();
    List<Lines> linesList = new ArrayList<Lines>();

    //checks if the user is moving the source end or destination end of the line
    List<Boolean> isSrcOrDest = new ArrayList<Boolean>();

    public void addRightPanelListeners(JPanel panel) {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                boolean isShapeClicked = false;
                for (Shapes s : RightPanel.shapesList)
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                        isShapeClicked = true;
                        if (s.isDotOrBarClicked(mouseEvent))
                            if (firstClick == null)
                                firstClick = mouseEvent;
                            else if (firstClick != null)
                                secondClick = mouseEvent;
                    }

                //Adds lines when user selects two dots or bars
                if (secondClick != null) {
                    Lines line = new Lines(firstClick.getX(), firstClick.getY(),
                            secondClick.getX(), secondClick.getY());
                    RightPanel.shapesList.add(line);
                    firstClick = secondClick = null;
                }

                //Adds the selected shape to right panel
                if (!isShapeClicked) {
                    createShape(mouseEvent);
                }

                for (Shapes s : RightPanel.shapesList) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                    else
                        RightPanel.selectedShape = null;
                }
                panel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                for (Shapes s : RightPanel.shapesList) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY()))
                        RightPanel.selectedShape = s;
                }
                for (Shapes s : RightPanel.shapesList) {
                    if (s instanceof Lines) {
                        Point lineStart = ((Lines) s).getCoordinatesOne();
                        if (RightPanel.selectedShape.isInside(lineStart.x, lineStart.y)) {
                            linesList.add((Lines) s);
                            clickOffSetX.add(lineStart.x - RightPanel.selectedShape.xCoordinate);
                            clickOffSetY.add(lineStart.y - RightPanel.selectedShape.yCoordinate);
                            isSrcOrDest.add(true);
                        }
                        Point lineEnd = ((Lines) s).getCoordinatesTwo();
                        if (RightPanel.selectedShape.isInside(lineEnd.x, lineEnd.y)) {
                            linesList.add((Lines) s);
                            clickOffSetX.add(lineEnd.x - RightPanel.selectedShape.xCoordinate);
                            clickOffSetY.add(lineEnd.y - RightPanel.selectedShape.yCoordinate);
                            isSrcOrDest.add(false);
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                RightPanel.selectedShape = null;
                linesList.clear();
                clickOffSetY.clear();
                clickOffSetX.clear();
                isSrcOrDest.clear();
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
                if (mouseLocationX > RIGHT_PANEL_HEIGHT) {
                    mouseLocationX = RIGHT_PANEL_HEIGHT;
                } else if (mouseLocationX < 0) {
                    mouseLocationX = 0;
                }
                if (mouseLocationY > RIGHT_PANEL_WIDTH) {
                    mouseLocationY = RIGHT_PANEL_WIDTH;
                } else if (mouseLocationY < 0) {
                    mouseLocationY = 0;
                }
                RightPanel.selectedShape.changeLocation(mouseLocationX,
                        mouseLocationY);
                for (int i = 0; i < linesList.size(); i++) {
                    if (isSrcOrDest.get(i))
                        linesList.get(i).changeSourceLocation(mouseLocationX + clickOffSetX.get(i),
                                mouseLocationY + clickOffSetY.get(i));
                    else
                        linesList.get(i).changeDestinationLocation(mouseLocationX + clickOffSetX.get(i),
                                mouseLocationY + clickOffSetY.get(i));
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
