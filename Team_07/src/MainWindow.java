import javax.swing.*;

/**
 * @author Karandeep Singh Grewal, Praveen Kumar
 * @since 02-18-2020
 */

public class MainWindow extends JFrame {
    static JFrame mainWindow;

    public static void main(String[] args) {
        final int WINDOW_WIDTH = 1000;
        final int WINDOW_HEIGHT = 800;

        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();

        MenuBar menubar = new MenuBar();
        menubar.rightPanel = rightPanel;
        mainWindow = new JFrame("SER516-Project-Team07");
        mainWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainWindow.add(leftPanel);
        mainWindow.add(rightPanel);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setJMenuBar(menubar.appMenuBar);
    }
}