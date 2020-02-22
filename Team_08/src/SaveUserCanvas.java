import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Date;

/**
 * @author Kartik
 * @version 1.0
 */

public class SaveUserCanvas {
//This class is used to take screenshot of canvas
    public void saveCanvasSnapshot(Canvas canvas) {
        WritableImage wim = new WritableImage(800, 800);
        File file = new File("Team_08/src/SavedCanvases/CanvasImage_" + new Date().getTime() + ".png");
        canvas.snapshot(null, wim);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", file);
            System.out.println("File ->" + file + " saved successfully!!!");
        } catch (Exception e) {
            System.out.println("Exception Occurred while saving File!!!!! " + e.getStackTrace());
        }
    }
}