import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class ButtonBox extends JPanel implements MouseListener, MouseMotionListener{

	private JLabel description;
	private static final long serialVersionUID = 1L;
	private final Color LIGHTBLUE = new Color(117, 218, 255);
	private final int labelWidth = 20;
	private final int labelHeight =10;
	private String text;
	public ButtonBox(String symbol) {
		this.setPreferredSize(new Dimension(120, 60));
		this.setBackground(LIGHTBLUE);
		this.setText("");
		addDescription(symbol);
	}
	public void setText(String title) {
		this.text = title;
		this.setBorder(BorderFactory.createTitledBorder(text));
	}
	
	public JOptionPane showOptionPane() {
		return new JOptionPane();
	}
	private void addDescription(String symbol) {
		Dimension size = this.getPreferredSize();
		description = new JLabel(symbol);
		description.setSize(new Dimension(20, 10));
		description.setLocation((size.width - labelWidth) / 2, (size.height - labelHeight) / 2);
		this.add(description);
	}
	abstract public void drawContent();
}
