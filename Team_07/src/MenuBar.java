/**
 * @author Praveen Kumar
 * @date 02/20/2020
 */
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar{

	RightPanel rightPanel;
	RightPanel olddata;
	List<Shapes> oldshapesList = new ArrayList<>();
	JMenuBar appMenuBar;

	public MenuBar() {
		appMenuBar = new JMenuBar();

		JMenu fileButton = new JMenu("File");
		appMenuBar.add(fileButton);
		JMenuItem openButton = new JMenuItem("Open");
		JMenuItem saveButton = new JMenuItem("Save");
		fileButton.add(openButton);
		fileButton.add(saveButton);        

		openButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("open pressed");
				open();
			}
		});
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("save pressed");
				save();
			}
		});
	}

	public void save()
	{	

		FileDialog dialog = new FileDialog(MainWindow.mainWindow,"Enter file name to Save");
		dialog.setMode(FileDialog.SAVE);
		dialog.setVisible(true);
		String file= dialog.getFile();
		if(file == null)
			return;
		FileOutputStream fos;
		ObjectOutputStream oos;
		rightPanel.bufferShapesList = RightPanel.shapesList;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(rightPanel);
			oos.close();
			fos.close();
			JOptionPane.showMessageDialog(MainWindow.mainWindow, "Saved as " + file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void open()
	{	
		FileDialog dialog = new FileDialog(MainWindow.mainWindow,"Select file to open");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		String file = dialog.getFile();
		if(file == null)
			return;
		System.out.println(file + " chosen.");

		RightPanel.shapesList.clear();
		rightPanel.repaint();

		try
		{
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);

			olddata = (RightPanel)oi.readObject();
			oldshapesList = olddata.bufferShapesList;
			oi.close();
			fi.close();

			for (Shapes s : oldshapesList) {
				RightPanel.shapesList.add(s);
			}

			rightPanel.repaint();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
