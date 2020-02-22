import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kunal sharme
 * @created on 02-18-2020
 * @version 1.0
 */
public class Menu extends JFrame implements ActionListener {
	java.util.List<Point> displayList = new ArrayList<Point>();
	String pathName = "";
	JButton clearBtn = new JButton("Clear");
	Point initial = new Point(0, 0);
	JButton saveBtn = new JButton("Save");
	JButton restoreBtn = new JButton("Restore");
	JButton quitBtn = new JButton("Quit");
	public List<Point> circlePoint = new ArrayList<Point>();
	public List<Point> trianglePoint = new ArrayList<Point>();
	public List<Point> squarePoint = new ArrayList<Point>();
	public List<Point> pointsPoint = new ArrayList<Point>();
	public List<Point> squareBar = new ArrayList<Point>();
	public List<Lineconnection> LinePoint = new ArrayList<Lineconnection>();

	public Panel CreateMenu() {
		Panel pan = new Panel();
		clearBtn.addActionListener(this);
		pan.add(clearBtn);
		saveBtn.addActionListener(this);
		pan.add(saveBtn);
		restoreBtn.addActionListener(this);
		pan.add(restoreBtn);
		quitBtn.addActionListener(this);
		pan.add(quitBtn);
		add("North", pan);
		pan.setSize(100, 100);
		return pan;

	}

	public void LoadFileChooser() {
		try {
			JFileChooser selectFile = new JFileChooser();
			selectFile.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Data File", "dat");
			selectFile.addChoosableFileFilter(filter);
			selectFile.showOpenDialog(null);
			File f = selectFile.getSelectedFile();
			if (f.exists()) {

				if (!getFileExtension(f).equals("dat")) {
					JOptionPane.showMessageDialog(null, "Invalid File format");
				} else {
					pathName = f.getAbsolutePath();
					JOptionPane.showMessageDialog(null, "File Loaded Successfully");
				}

			} else {

			}

		} catch (Exception ex) {
		}
	}

	public void SaveFileChooser() {
		try {
			JFileChooser selectFile = new JFileChooser();

			selectFile.setDialogTitle("Save As");
			selectFile.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("dat", "dat");
			selectFile.addChoosableFileFilter(filter);
			int result = selectFile.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File f = selectFile.getSelectedFile();
				if (!getFileExtension(f).equals("dat")) {
					JOptionPane.showMessageDialog(null, "Invalid File format");
				} else if (getFileExtension(f).equals("dat")) {
					pathName = f.getAbsolutePath();
					JOptionPane.showMessageDialog(null, "File Saved Successfully");
				}

			}
		} catch (Exception ex) {

		}
	}

	private String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<List<Point>> list = new ArrayList<List<Point>>();
		if (e.getSource() == clearBtn) {
			ShapeLocation.circlePoint.clear();
			ShapeLocation.trianglePoint.clear();
			ShapeLocation.squarePoint.clear();
			ShapeLocation.dotPoint.clear();
			ShapeLocation.LinePoint.clear();
			ShapeLocation.squarebarpoints.clear();
			circlePoint.clear();
			trianglePoint.clear();
			squarePoint.clear();
			pointsPoint.clear();
			LinePoint.clear();
			new MouseListener().restore();
		} else if (e.getSource() == saveBtn) {
			try {
				SaveFileChooser();

				FileOutputStream fos = new FileOutputStream(new File(pathName));
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				circlePoint = ShapeLocation.circlePoint;
				trianglePoint = ShapeLocation.trianglePoint;
				squarePoint = ShapeLocation.squarePoint;
				pointsPoint = ShapeLocation.dotPoint;
				squareBar = ShapeLocation.squarebarpoints;
				List<Point> lines = new ArrayList<Point>();
				for (Lineconnection line : ShapeLocation.LinePoint) {
					lines.add(line.P1);
					lines.add(line.P2);
				}
				list.add(circlePoint);
				list.add(trianglePoint);
				list.add((ArrayList<Point>) squarePoint);
				list.add(pointsPoint);
				list.add(squareBar);

				oos.writeObject(list);
				oos.flush();
				oos.close();
				fos.close();
			} catch (Exception ex) {
				System.out.println("Trouble writing display list vector");
			}
		} else if (e.getSource() == restoreBtn) {
			try {
				LoadFileChooser();
				list.clear();
				FileInputStream fis = new FileInputStream(pathName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				list = (ArrayList<List<Point>>) ois.readObject();
				ShapeLocation.circlePoint = list.get(0);
				ShapeLocation.trianglePoint = list.get(1);
				ShapeLocation.squarePoint = list.get(2);
				ShapeLocation.dotPoint = list.get(3);
				List<Lineconnection> lineConnection = new ArrayList<Lineconnection>();
				List<Point> lines = list.get(4);
				for (int i = 0; i < lines.size() / 2; i = i + 2) {
					Lineconnection objLC = new Lineconnection(lines.get(i), lines.get(i + 1));
					lineConnection.add(objLC);
				}
				ShapeLocation.LinePoint = lineConnection;
				ShapeLocation.squarebarpoints = list.get(5);
				ois.close();
				fis.close();

				new MouseListener().restore();
			} catch (Exception ex) {
				System.out.println("Trouble reading display list vector");
			}
		} else if (e.getSource() == quitBtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
