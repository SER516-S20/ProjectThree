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
	// boolean bothDotClicked=false;
	int srcDotX, srcDotY;
	int destDotX, destDotY;
	String srcShapeId,destShapeId;
	List<Dot> connectedDots=new ArrayList<Dot>();
	Dot actualSrcDot;
	Dot actualDestDot;

	public void addRightPanelListeners(JPanel panel) {
		panel.addMouseListener(new MouseListener() {
			
			public boolean checkIfDotPresent(List<Dot> list,Dot d) {
				for(Dot dot:list) {
					if(dot.xCoordinate==d.xCoordinate) {
						if(dot.yCoordinate==d.yCoordinate) {
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
							System.out.println(((Circle) s).isDotClicked(mouseEvent));
							if (((Circle) s).isDotClicked(mouseEvent)) {

								if (srcDotClicked) {
//                            		Lines testLine=new Lines(srcDotX,srcDotY);
//                                    testLine.setDestPointX(mouseEvent.getX());
//                                    testLine.setDestPointY(mouseEvent.getY());
//                            		RightPanel.shapesList.add(testLine);
//                                    RightPanel.selectedLine=testLine;

									srcDotClicked = false;
									destDotClicked = true;
									destShapeId=s.toString();
//									destDotX = mouseEvent.getX();
//									destDotY = mouseEvent.getY();
									actualDestDot=((Circle) s).getClickedDot(mouseEvent);
								} else {
									srcDotClicked = true;
									srcShapeId=s.toString();
									destDotClicked = false;
//									srcDotX = mouseEvent.getX();
//									srcDotY = mouseEvent.getY();
									actualSrcDot=((Circle) s).getClickedDot(mouseEvent);
								}

							}
						} else if (s instanceof Triangle) {
							System.out.println(((Triangle) s).isDotClicked(mouseEvent));
							
							if (((Triangle) s).isDotClicked(mouseEvent)) {

								if (srcDotClicked) {
									srcDotClicked = false;
									destDotClicked = true;
									destShapeId=s.toString();
//									destDotX = mouseEvent.getX();
//									destDotY = mouseEvent.getY();
									actualDestDot=((Triangle) s).getClickedDot(mouseEvent);
								} else {
									srcDotClicked = true;
									srcShapeId=s.toString();
									destDotClicked = false;
//									srcDotX = mouseEvent.getX();
//									srcDotY = mouseEvent.getY();
									actualSrcDot=((Triangle) s).getClickedDot(mouseEvent);
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
					System.out.println("destShapeId"+destShapeId);
					System.out.println("srcShapeId"+srcShapeId);
					if(!(destShapeId.contentEquals(srcShapeId))) {
						Dot srcDot=new Dot(actualSrcDot.xCoordinate,actualSrcDot.yCoordinate);
						Dot destDot=new Dot(actualDestDot.xCoordinate,actualDestDot.yCoordinate);
						
						System.out.println("Src Dot"+checkIfDotPresent(connectedDots, srcDot));
						System.out.println("Dest dot"+checkIfDotPresent(connectedDots, destDot));
						System.out.println("Actual Src Dot"+actualSrcDot.isConnected);
						System.out.println("Dest src dot"+actualDestDot.isConnected);
						if(!checkIfDotPresent(connectedDots, srcDot) && !checkIfDotPresent(connectedDots, destDot)) {
						//if(!actualSrcDot.isConnected && !actualDestDot.isConnected) {
//							Lines testLine = new Lines(srcDotX,srcDotY);
//							testLine.setDestPointX(destDotX);
//							testLine.setDestPointY(destDotY);
							Lines testLine = new Lines(actualSrcDot.xCoordinate,actualSrcDot.yCoordinate);
							testLine.setDestPointX(actualDestDot.xCoordinate);
							testLine.setDestPointY(actualDestDot.yCoordinate);
							RightPanel.shapesList.add(testLine);
							RightPanel.selectedLine = testLine;
							destDotClicked=false;
							srcShapeId=destShapeId="";
							actualSrcDot.isConnected=true;
							actualDestDot.isConnected=true;
							connectedDots.add(srcDot);
							connectedDots.add(destDot);
						}
						System.out.println("Printing Array List"+Arrays.toString(connectedDots.toArray()));
					}					
				}
//                Lines testLine=new Lines(mouseEvent.getX(), mouseEvent.getY());
//                testLine.setDestPointX(mouseEvent.getX()+50);
//                testLine.setDestPointY(mouseEvent.getY()+50);
//                RightPanel.shapesList.add(testLine);
//                RightPanel.selectedLine=testLine;
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
