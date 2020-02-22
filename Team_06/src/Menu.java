import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * 
 * @author Suyog
 * @since 02-18-2020
 */
public class Menu extends JMenuBar{
	Menu(){
		JMenu menu = new JMenu("Menu");
		JMenuItem save = new JMenuItem("save");
		JMenuItem open = new JMenuItem("open");
		
		new FileManager(save, open);
		
		this.add(menu);
		menu.add(save); 
		menu.add(open);  
	}
}
