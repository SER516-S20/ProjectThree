
import java.awt.*;

/**
 * This class is used to identify which shape has been selected by the user
 * @author ashwin srinivasan
 * @version 1.0
 * @since 01/29/2020
 */
public class JButtonActionListener {

	static boolean isCirclePanelClicked = false, isTrianglePanelClicked = false, isSquarePanelClicked = false;

	public void addActionListener() {
		addCircleButtonActionListener();
		addSquareButtonActionListener();
		addTriangleButtonActionListener();
	}

	private void activateCirclePanel() {
		isCirclePanelClicked = true;
		ShapePanel.circleButton.setBackground(Color.YELLOW);
		ShapePanel.circleButton.setOpaque(true);
	}

	private void deActivateCirclePanel() {
		isCirclePanelClicked = false;
		ShapePanel.circleButton.setBackground(Color.GRAY);
		ShapePanel.circleButton.setOpaque(true);
	}

	private void activateSquarePanel() {
		isSquarePanelClicked = true;
		ShapePanel.squareButton.setBackground(Color.YELLOW);
		ShapePanel.squareButton.setOpaque(true);
	}

	private void deActivateSquarePanel() {
		isSquarePanelClicked = false;
		ShapePanel.squareButton.setBackground(Color.GRAY);
		ShapePanel.squareButton.setOpaque(true);
	}

	private void activateTrianglePanel() {
		isTrianglePanelClicked = true;
		ShapePanel.triangleButton.setBackground(Color.YELLOW);
		ShapePanel.triangleButton.setOpaque(true);
	}

	private void deActivateTrianglePanel() {
		isTrianglePanelClicked = false;
		ShapePanel.triangleButton.setBackground(Color.GRAY);
		ShapePanel.triangleButton.setOpaque(true);
	}

	private void addCircleButtonActionListener() {
		ShapePanel.circleButton.addActionListener(e -> {
			if (!isCirclePanelClicked) {
				activateCirclePanel();
				deActivateSquarePanel();
				deActivateTrianglePanel();
			} else {
				deActivateCirclePanel();
			}
		});
	}

	private void addSquareButtonActionListener() {
		ShapePanel.squareButton.addActionListener(e -> {
			if (!isSquarePanelClicked) {
				activateSquarePanel();
				deActivateCirclePanel();
				deActivateTrianglePanel();
			} else {
				deActivateSquarePanel();
			}
		});
	}

	private void addTriangleButtonActionListener() {
		ShapePanel.triangleButton.addActionListener(e -> {
			if (!isTrianglePanelClicked) {
				activateTrianglePanel();
				deActivateSquarePanel();
				deActivateCirclePanel();
			} else {
				deActivateTrianglePanel();
			}
		});
	}

}
