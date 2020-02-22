import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
/**
 * 
 * @author Ashwath Reddy Koppala
 * @since  02-21-2020
 *
 */
public class SaveManager implements ActionListener {
	private String fileName;
	private DrawingCanvas canvas;

	public SaveManager(DrawingCanvas c) {
		canvas = c;
	}

	public void actionPerformed(ActionEvent e) {
		FileOutputStream fileOutStream = null;
		ObjectOutputStream objectOutStream = null;
		try {
			JFileChooser chosenFile = new JFileChooser();
			int showSaveDialog = chosenFile.showSaveDialog(null);
			if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
				fileName = chosenFile.getSelectedFile().getAbsolutePath().toString() + ".ser";
			}
			fileOutStream = new FileOutputStream(new File(fileName));
			objectOutStream = new ObjectOutputStream(fileOutStream);
			objectOutStream.writeObject(canvas.lineArray);
			objectOutStream.writeObject(canvas.shapeObject);
			fileOutStream.flush();
			if (objectOutStream != null) {
				objectOutStream.close();
			}
			if (fileOutStream != null) {
				fileOutStream.close();
			}
		} catch (IOException i) {
			i.printStackTrace();
		}

	}
}