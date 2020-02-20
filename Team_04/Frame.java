import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;

/**
 * @author Nikitha
 * @Since 1-26-2020
 * @version 1.0
 */
/**
 * 
 * @author Ashwath
 *@Since 2-19-2020
 * @version 1.0.2
 */
/**
 * 
 * @author Tarun Snehith Kishore Reddy Karna
 *@Since 2-19-2020
 * @version 1.0.2
 */

public class Frame extends JFrame {
	private static final String FRAME_TITLE = "Team4";
	JFrame frame = new JFrame("Swing Tester");
	public static DrawingCanvas canvas;
	public static OptionsPanel options;

	public Frame() {

		this.setTitle(FRAME_TITLE);
		this.setMinimumSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = this.getContentPane();
		JMenuBar menubar = new JMenuBar();
		menubar.setMinimumSize(new Dimension(60, 40));
		final JLabel label = new JLabel();
		this.setJMenuBar(menubar);
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(new OpenL());
		save.addActionListener(new SaveL());
		menu.add(save);
		menu.add(load);

		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		options = new OptionsPanel();
		content.add(options);
		canvas = new DrawingCanvas();
		content.add(canvas);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	class OpenL implements ActionListener {
		public String fileName;

		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			FileInputStream fileIn = null;
			ObjectInputStream in = null;
			try {
				JFileChooser chosenFile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("SER516", "ser");
				chosenFile.setFileFilter(filter);
				int showOpenDialog = chosenFile.showOpenDialog(null);
				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					fileName = chosenFile.getSelectedFile().getAbsolutePath();
					fileIn = new FileInputStream(fileName);
					in = new ObjectInputStream(fileIn);
					canvas.lineArray = (ArrayList<Point[]>) in.readObject();
					canvas.shapeObject = (ArrayList<Object>) in.readObject();
					canvas.load();
					canvas.repaint();
				}
			} catch (IOException i) {
				i.printStackTrace();
			} catch (ClassNotFoundException e1) {
			}

			finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (fileIn != null) {
					try {
						fileIn.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}


	class SaveL implements ActionListener {
		public String fileName;

		public void actionPerformed(ActionEvent e) {
			FileOutputStream fileOut = null;
			ObjectOutputStream out = null;
			try {
				JFileChooser chosenFile = new JFileChooser();
				int showSaveDialog = chosenFile.showSaveDialog(null);
				if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
					fileName = chosenFile.getSelectedFile().getAbsolutePath().toString() + ".ser";
				}
				fileOut = new FileOutputStream(new File(fileName));
				out = new ObjectOutputStream(fileOut);

				// out.writeObject(canvas);
				out.writeObject(canvas.lineArray);
				out.writeObject(canvas.shapeObject);
				fileOut.flush();
			} catch (IOException i) {
				i.printStackTrace();
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (fileOut != null) {
					try {
						fileOut.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Frame();
	}
}
