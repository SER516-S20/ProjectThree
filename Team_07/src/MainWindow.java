import javax.swing.*;

/**
 * @author Karandeep Singh Grewal, Praveen Kumar
 * @since 02-18-2020
 */

public class MainWindow extends JFrame {
    static JFrame mainWindow;

    public static void main(String[] args) {

        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();

        mainWindow = new JFrame("SER516-Project-Team07");
        mainWindow.setSize(1000, 800);
        mainWindow.add(leftPanel);
        mainWindow.add(rightPanel);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}