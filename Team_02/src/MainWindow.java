/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 * @author Kunal Sharma
 * @created on 01-27-2020
 * @version 1.0
 * @author Kunal Sharma
 * @created on 02-19-2020
 * @version 2.0
 */
public class MainWindow {
	public static void CloseApplication() {

		try {
			System.exit(0);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {

		try {
			Menu objMenu = new Menu();
			JFrame frame = new JFrame("Main Window");
			frame.setVisible(true);
			frame.setSize(1000, 1000);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.add(objMenu.CreateMenu());

			JSplitPane splitPane2 = new JSplitPane();
			splitPane2.setSize(900, 900);
			splitPane2.setDividerSize(0);
			splitPane2.setDividerLocation(200);
			splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

			splitPane2.setTopComponent(new PanelToolkit());
			splitPane2.setBottomComponent(new DrawBoardPanel());
			JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, splitPane2);
			frame.add(splitPane1);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
