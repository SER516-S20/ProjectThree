import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author Pradeep Relangi
 * @since 1-27-2020
 * @version 1.0
 **/
public class SelectionEvent implements ActionListener {
	private JButton shapeButton;
	private String shape;
	private SelectedShape select;

	public SelectionEvent(JButton button, String shape) {
		this.shapeButton = button;
		this.shapeButton.addActionListener(this);
		this.shape = shape;
		select = new SelectedShape();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		select.name = shape;
	}

}
