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
	private String title;
	private ValuePane vDialog;
	//private JLabel title;
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
		//addTitle("11");
		addDescription(symbol);
		generateBtnDot(num);
		this.setTitle(" ");
	}
	public void setTitle(String text) {
		this.title = text;
		this.setBorder(BorderFactory.createTitledBorder(title));
	}
	public String getTitle() {
		return this.title;
	}
	private void addDescription(String symbol) {
		Dimension size = this.getPreferredSize();
		description = new JLabel(symbol);
		description.setSize(new Dimension(labelWidth, labelHeight));
		description.setLocation((size.width - labelWidth) / 2, (size.height - labelHeight) / 2);
		this.add(description);
	}
	/*
	private void addTitle(String text) {
		title = new JLabel(text);
		title.setSize(new Dimension(labelWidth, labelHeight));
		title.setLocation(1, 1);
		this.add(title);
	}*/
	private void generateBtnDot(int num) {
		int height = this.getPreferredSize().height / 5;
		btnDots = new JButton[num];
		for( int i = 0; i < btnDots.length; i++) {
			btnDots[i] = new JButton();
			btnDots[i].setSize(height, height);
			btnDots[i].addMouseListener(new ConnectionController(this));
		}
	}
	public ValuePane createJOptionPane() {
		vDialog =  new ValuePane();
		vDialog.setValue("");
		return vDialog;
	}
	abstract public void drawContent();
}
