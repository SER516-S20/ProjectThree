import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * @author Yijian Hu
 * @modified by Hongqi Zhang
 */
public class LeftPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private RoundButton roundButton = new RoundButton("Round");
	private TriangleButton triangleButton = new TriangleButton("Triangle");
	private RectangleButton rectangleButton = new RectangleButton("Rectangle");
	private Dimension buttonSize = new Dimension(100,100);
	//private RightPanel dragArea;
	public LeftPanel() {
		//this.dragArea = dragArea;
		roundButton.setPreferredSize(buttonSize);
		triangleButton.setPreferredSize(buttonSize);
		rectangleButton.setPreferredSize(buttonSize);
		roundButton.addActionListener(this);
		triangleButton.addActionListener(this);
		rectangleButton.addActionListener(this);
		add(roundButton);
		add(triangleButton);
		add(rectangleButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String className = e.getSource().getClass().getName();
		Box instance = Box.getInstance();
		instance.instanceOfClass = className;
		//dragArea.addButton(className);
		System.out.println("the pressed button is: " + className);
		
	}
}