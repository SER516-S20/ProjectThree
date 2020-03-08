import javax.swing.JFrame;

//import javax.swing.JMenuBar;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		MenuBar menuBar = new MenuBar();
		frame.setJMenuBar(menuBar.createMenuBar());
		frame.setVisible(true);
	}
}
