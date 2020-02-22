import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Karandeep Singh Grewal
 * @author Aravind Thillai Villalan
 * @since 01-29-2020
 */

public class RightPanelListeners {

	boolean srcDotClicked = false;
	boolean destDotClicked = false;
	String srcShapeId, destShapeId;
	List<Dot> connectedDots = new ArrayList<Dot>();
	Dot srcDot;
	Dot destDot;

	public void addRightPanelListeners(JPanel panel) {
		panel.addMouseListener(new MouseListener() {

			public boolean checkIfDotPresent(List<Dot> list, Dot d) {
				for (Dot dot : list) {
					if (dot.xCoordinate == d.xCoordinate) {
						if (dot.yCoordinate == d.yCoordinate) {
							return true;
						}
					}
				}
				return false;
			}

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				boolean isShapeClicked = false;
				for (Shapes s : RightPanel.shapesList) {
					if (s.isInside(mouseEvent.getX(), mouseEvent.getY())) {
						isShapeClicked = true;
						if (s instanceof Circle) {
							if (((Circle) s).isDotClicked(mouseEvent)) {

								if (srcDotClicked) {
									srcDotClicked = false;
									destDotClicked = true;
									destShapeId = s.toString();
									destDot = ((Circle) s).getClickedDot(mouseEvent);
								} else {
									srcDotClicked = true;
									srcShapeId = s.toString();
									destDotClicked = false;
									srcDot = ((Circle) s).getClickedDot(mouseEvent);
								}

							}
						} else if (s instanceof Triangle) {

							if (((Triangle) s).isDotClicked(mouseEvent)) {

								if (srcDotClicked) {
									srcDotClicked = false;
									destDotClicked = true;
									destShapeId = s.toString();
									destDot = ((Triangle) s).getClickedDot(mouseEvent);
								} else {
									srcDotClicked = true;
									srcShapeId = s.toString();
									destDotClicked = false;
									srcDot = ((Triangle) s).getClickedDot(mouseEvent);
								}

							}

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

				if (destDotClicked) {
					System.out.println("destShapeId" + destShapeId);
					System.out.println("srcShapeId" + srcShapeId);
					if (!(destShapeId.contentEquals(srcShapeId))) {
						System.out.println("Src Dot" + checkIfDotPresent(connectedDots, srcDot));
						System.out.println("Dest dot" + checkIfDotPresent(connectedDots, destDot));
						System.out.println("Actual Src Dot" + srcDot.isConnected);
						System.out.println("Dest src dot" + destDot.isConnected);
						if (!checkIfDotPresent(connectedDots, srcDot) && !checkIfDotPresent(connectedDots, destDot)) {
							// if(!srcDot.isConnected && !destDot.isConnected) {
							Lines testLine = new Lines(srcDot.xCoordinate, srcDot.yCoordinate);
							testLine.setDestPointX(destDot.xCoordinate);
							testLine.setDestPointY(destDot.yCoordinate);
							RightPanel.shapesList.add(testLine);
							RightPanel.selectedLine = testLine;
							destDotClicked = false;
							srcShapeId = destShapeId = "";
							srcDot.isConnected = true;
							destDot.isConnected = true;
							connectedDots.add(srcDot);
							connectedDots.add(destDot);
						}
						System.out.println("Printing Array List" + Arrays.toString(connectedDots.toArray()));
					}
				}
				panel.repaint();
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
				RightPanel.selectedShape.changeLocation(mouseLocationX, mouseLocationY);
				RightPanel.selectedLine.changeLocation(mouseLocationX, mouseLocationY);
				panel.repaint();
			}

			@Override
			public void mouseMoved(MouseEvent mouseEvent) {

			}
		});
	}
}
