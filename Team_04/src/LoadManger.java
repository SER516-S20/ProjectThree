import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * 
 * @author Tarun Snehith Kishore Reddy Karna
 *
 */
class LoadManager implements ActionListener {
	private String fileName;
	private DrawingCanvas canvas;

	public LoadManager(DrawingCanvas c) {
		canvas = c;
	}

	public void actionPerformed(ActionEvent e) {
		FileInputStream fileInStream = null;
		ObjectInputStream objectInStream = null;
		try {
			JFileChooser chosenFile = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("SER516", "ser");
			chosenFile.setFileFilter(filter);
			int showOpenDialog = chosenFile.showOpenDialog(null);
			if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
				fileName = chosenFile.getSelectedFile().getAbsolutePath();
				fileInStream = new FileInputStream(fileName);
				objectInStream = new ObjectInputStream(fileInStream);
				canvas.lineArray = (ArrayList<Point[]>) objectInStream.readObject();
				canvas.shapeObject = (ArrayList<Object>) objectInStream.readObject();
				canvas.load();
				canvas.repaint();
			}
			if (objectInStream != null) {
				objectInStream.close();
			}
			if (fileInStream != null) {
				fileInStream.close();
			}
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e1) {
		}
	}
}