import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineDraw {
    /*
    * Draws a line on canvas
    * */
    public void drawLineOnCanvas(Scene scene, GraphicsContext gc) {

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        scene.setOnMousePressed(e -> {
            gc.beginPath();
            gc.lineTo((int) e.getX(), (int) e.getY());
            gc.stroke();

        });
        scene.setOnMouseDragged(e -> {
            gc.lineTo((int) e.getX(), (int) e.getY());
            gc.stroke();

        });
    }
}
