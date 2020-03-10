import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileBrowser fileBrowser;
	private FileManager fileManager;
	
	public JMenuBar createMenuBar() {
		fileBrowser = new FileBrowser();
		fileManager = new FileManager();
		JMenu fileMenu =  new JMenu("File");
		JMenuBar menuBar = new JMenuBar();
		JMenuItem itemSave = new JMenuItem("Save File");
		itemSave.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
				if(fileBrowser.browser("Save file")) {
					//fileManager.save(fileBrowser.getCurrentFile(), dragArea.getShapes());
				}
			}
		});
		fileMenu.add(itemSave);
		fileMenu.addSeparator();
		JMenuItem itemOpen = new JMenuItem("Open File");
		itemOpen.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(fileBrowser.browser("Open file")) {
					ShapeInfo[] shapeList = fileManager.open(fileBrowser.getCurrentFile());
				//	dragArea.load(shapeList);
				}
			}
		});
		fileMenu.add(itemOpen);
		menuBar.add(fileMenu);
		JMenu NewSpace = new JMenu("New Space");
		menuBar.add(NewSpace);
		JMenu Compiler = new JMenu("Compiler");
		menuBar.add(Compiler);
		return menuBar;
	}
}
