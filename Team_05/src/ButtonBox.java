import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class ButtonBox extends JPanel{

	private JLabel description;
	private static final long serialVersionUID = 1L;
	private final Color LIGHTBLUE = new Color(117, 218, 255);
	private final int labelWidth = 20;
	private final int labelHeight =20;
	private String text;
	private JButton []btnDots;
	public JButton[] getBtnDots() {
		return btnDots;
	}
	public void setBtnDots(JButton[] btnDots) {
		this.btnDots = btnDots;
	}
	public ButtonBox(String symbol, int num) {
		this.setPreferredSize(new Dimension(120, 60));
		this.setBackground(LIGHTBLUE);
		this.setText("");
		addDescription(symbol);
		generateBtnDot(num);
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
		description.setSize(new Dimension(labelWidth, labelHeight));
		description.setLocation((size.width - labelWidth) / 2, (size.height - labelHeight) / 2);
		this.add(description);
	}
	private void generateBtnDot(int num) {
		int height = this.getPreferredSize().height / 5;
		btnDots = new JButton[num];
		for( int i = 0; i < btnDots.length; i++) {
			btnDots[i] = new JButton();
			btnDots[i].setSize(height, height);
		}
	}
	abstract public void drawContent();
}
