import javax.swing.JOptionPane;
/**
 * this class is to pop out a dialog for user to input values
 * @author KaiRui Hsu
 */
public class ValuePane extends JOptionPane{
	private static final long serialVersionUID = 1L;
	private static String value = "";
	
	public String getvalue() {
		return value;
	}
	
	public void setValue(String val) {
		if(val == "") {
			String m = JOptionPane.showInputDialog("Input a value:");
			value = m;
		}else {
			JOptionPane.showMessageDialog(null,"Value = " + val);
		}
	}
}
