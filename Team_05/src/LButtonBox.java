import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class LButtonBox extends ButtonBox {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton []dots; 
	public LButtonBox() {
		super("<");
		//drawContent();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource().getClass().getName());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawContent() {
		// TODO Auto-generated method stub
		int width = this.getPreferredSize().width;
		int height = this.getPreferredSize().height / 5;
		dots = new JButton[3];
		for( int i = 0; i < dots.length; i++) {
			dots[i] = new JButton();
			dots[i].setSize(height, height);
		}
		dots[0].setLocation(1, (this.getPreferredSize().height - height) / 2);
		dots[1].setLocation(width - height - 2, (this.getPreferredSize().height / 2 - height) / 2);
		dots[2].setLocation(width - height - 2, (this.getPreferredSize().height / 2 + height * 4) / 2);
		for(int i = 0; i < dots.length; i++) {
			this.add(dots[i]);
		}
	}

}
