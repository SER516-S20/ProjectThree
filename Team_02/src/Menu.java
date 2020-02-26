/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kunal sharma
 * @created on 02-18-2020
 * @version 1.0
 */
public class Menu extends JPanel implements ActionListener {

	private String pathName = "";
	private JButton clearBtn = new JButton("Clear");
	private JButton saveBtn = new JButton("Save");
	private JButton restoreBtn = new JButton("Restore");
	private JButton quitBtn = new JButton("Quit");
	private List<Point> circlePoint = new ArrayList<Point>();
	private List<Point> trianglePoint = new ArrayList<Point>();
	private List<Point> squarePoint = new ArrayList<Point>();
	private List<Point> pointsPoint = new ArrayList<Point>();
	private List<Point> squareBar = new ArrayList<Point>();
	private List<Lineconnection> LinePoint = new ArrayList<Lineconnection>();
	private ArrayList<List<Point>> list;

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
					JOptionPane.showMessageDialog(null, "Invalid File format. Please add file extension-.dat");
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
		list = new ArrayList<List<Point>>();
		SystemFileManager objSFM = new SystemFileManager();
		if (e.getSource() == clearBtn) {
			clearDrawingBoard();
		} else if (e.getSource() == saveBtn) {
			SaveFileChooser();
			objSFM.saveShape(pathName, circlePoint, trianglePoint, squarePoint, pointsPoint, squareBar, list);
		} else if (e.getSource() == restoreBtn) {
			LoadFileChooser();
			objSFM.restoreShape(pathName);
		} else if (e.getSource() == quitBtn) {
			MainWindow.CloseApplication();
		}
	}

	public void clearDrawingBoard() {
		try {
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
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
