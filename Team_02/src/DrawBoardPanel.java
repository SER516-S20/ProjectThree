import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Rohit
 * @created 02-18-2020
 * @version 1.0
 */
public class DrawBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public DrawBoardPanel() {

		try {
			add(new MouseListener());
			setVisible(true);
			Border blackline = BorderFactory.createLineBorder(Color.black);
			setBorder(blackline);
			setSize(1600, 800);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
