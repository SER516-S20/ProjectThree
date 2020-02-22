import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Karandeep Singh Grewal
 * @since 01-29-2020
 */

public class LeftPanelListeners {
    public void addLeftPanelListeners(JPanel panel) {
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                for (Shapes s : LeftPanel.shapesList) {
                    if (s.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                        LeftPanel.selectedShape = s;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }
}
