import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is to show the app
 * @author Hongqi Zhang
 */
public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final String title = "ProjectTwo-Team 5";
	private static final Color lBackground = new Color(255, 255, 240);
	private static final Color rBackground = new Color(240, 255, 255);
	private RightPanel dragArea;
	private LeftPanel btnContainer;
	 
	public Frame() {
		this.setTitle(title);
		this.setMinimumSize(new Dimension(800, 500));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		dragArea = new RightPanel();
		btnContainer = new LeftPanel();
		dragArea.setFrame(this);
		this.getContentPane().add(createLeftPanel());
		this.getContentPane().add(createRightPanel());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		MenuBar menuBar = new MenuBar();
		this.setJMenuBar(menuBar.createMenuBar());
		this.setVisible(true);
	}
	
	private JPanel createLeftPanel() {
		btnContainer.setSize(200, 500);
		btnContainer.setLocation(0, 0);
		btnContainer.setBackground(lBackground);
		//btnContainer.setRoundButtonMouseAdapter(new LeftPanelMouse(dragArea));
		//btnContainer.setTriangleButtonMouseAdapter(new LeftPanelMouse(dragArea));
		//btnContainer.setRectangleButtonMouseAdapter(new LeftPanelMouse(dragArea));
		return btnContainer;
	}
	
	private JPanel createRightPanel() {
		dragArea.setLocation(200, 0);
		dragArea.setSize(600, 500);
		dragArea.setBackground(rBackground);
		return dragArea;
	}
	
	public void contentRepaint() {
		getContentPane().revalidate();
		getContentPane().repaint();	
	}
}
