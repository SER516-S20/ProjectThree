import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


/**
 * this class is to show the app
 * @author Hongqi Zhang
 */
public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final String title = "ProjectTwo-Team 5";
	private static final Color lBackground = new Color(255, 255, 240);
	//private static final Color rBackground = new Color(240, 255, 255);
	private RightPanel dragArea;
	private LeftPanel btnContainer;
//testing...
//	private TitledBorder titled;
	 
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
	
	private JScrollPane createLeftPanel() {
		btnContainer.setPreferredSize(new  Dimension(200, 600));
		btnContainer.setLocation(0, 0);
		btnContainer.setBackground(lBackground);
		//btnContainer.setRoundButtonMouseAdapter(new LeftPanelMouse(dragArea));
		//btnContainer.setTriangleButtonMouseAdapter(new LeftPanelMouse(dragArea));
		//btnContainer.setRectangleButtonMouseAdapter(new LeftPanelMouse(dragArea));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(btnContainer);
        scrollPane.setBounds(0, 0, 200, 480);
		return scrollPane;
	}
	
	private JPanel createRightPanel() {
		dragArea.setLocation(200, 0);
		dragArea.setSize(600, 500);
		dragArea.setBackground(Color.white);
//testing...		
//        titled = BorderFactory.createTitledBorder("123");
//        dragArea.setBorder(titled);
//        dragArea.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
//        addCompForBorder(titled,
//                "default titled border"
//                + " (default just., default pos.)",
//                dragArea);		
		return dragArea;
	}
	
	public void contentRepaint() {
		getContentPane().revalidate();
		getContentPane().repaint();	
	}
//testing...
//    void addCompForBorder(Border border,
//            String description,
//            Container container) {
//    		JPanel comp = new JPanel(new GridLayout(1, 1), false);
//    		JLabel label = new JLabel(description, JLabel.CENTER);
//    		comp.add(label);
//    		comp.setBorder(border);
//
//    		container.add(Box.createRigidArea(new Dimension(0, 10)));
//    		container.add(comp);
//    }
}
