import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Kartik
 * @version 1.0
 */
public class SourcePanel extends Application {

    private int shapeCount = 0;
    private Canvas canvas;
    private Color currentColor = Color.WHITE;
    private Shape[] shapes = new Shape[1000];
    public Shape currentShape;
    private boolean dragging = false;
    private Shape shapeBeingDragged = null;
    private int prevDragX;
    private int prevDragY;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        canvas = makeCanvas();
        LineDraw lineDraw = new LineDraw();
        paintCanvas();
        StackPane canvasHolder = new StackPane(canvas);
        canvasHolder.setStyle("-fx-border-width: 2px; -fx-border-color: #444");
        BorderPane root = new BorderPane(canvasHolder);
        root.setStyle("-fx-border-width: 1px; -fx-border-color: black");
        root.setLeft(makeToolPanel(canvas));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Project03 Team 08");
        stage.setResizable(false);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        lineDraw.drawLineOnCanvas(scene, gc);
    }

    private Canvas makeCanvas() {
        Canvas canvas = new Canvas(800, 600);
        canvas.setOnMousePressed(this::mousePressed);
        canvas.setOnMouseReleased(this::mouseReleased);
        canvas.setOnMouseClicked(this::mouseClicked);
        canvas.setOnMouseDragged(this::mouseDragged);
        return canvas;
    }

    private VBox makeToolPanel(Canvas canvas) {
        SaveUserCanvas saveFile = new SaveUserCanvas();
        FileInputStream circleImage = null, squareImage = null, triangleImage = null;
        try {
            circleImage = new FileInputStream("Team_08/src/Image/circle.png");
            squareImage = new FileInputStream("Team_08/src/Image/square.png");
            triangleImage = new FileInputStream("Team_08/src/Image/triangle.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(circleImage);
        ImageView imageView = new ImageView(image);
        Button ovalButton = new Button("", imageView);
        ovalButton.setOnAction((e) -> addShape(new CircleShapeWithDot(), 10, 50, 75, 75));

        image = new Image(squareImage);
        imageView = new ImageView(image);
        Button squareButton = new Button("", imageView);
        squareButton.setOnAction((e) -> addShape(new SquareShapeWithBars(), 10, 250, 75, 75));

        image = new Image(triangleImage);
        imageView = new ImageView(image);
        Button triangleButton = new Button("", imageView);
        triangleButton.setOnAction((e) -> addShape(new TriangleShape(), 90, 450, 100, 50));

        Button saveButton = new Button("Save Canvas File", null);
        saveButton.setOnAction((e) -> saveFile.saveCanvasSnapshot(canvas));

        ComboBox<String> combobox = new ComboBox<>();
        combobox.setEditable(false);
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN,
                Color.MAGENTA, Color.YELLOW, Color.BLACK, Color.WHITE};
        String[] colorNames = {"Red", "Green", "Blue", "Cyan",
                "Magenta", "Yellow", "Black", "White"};
        combobox.getItems().addAll(colorNames);
        combobox.setValue("White");
        combobox.setOnAction(e -> currentColor = colors[combobox.getSelectionModel().getSelectedIndex()]);
        VBox tools = new VBox(20);
        tools.getChildren().add(combobox);
        tools.getChildren().add(ovalButton);
        tools.getChildren().add(squareButton);
        tools.getChildren().add(triangleButton);
        tools.getChildren().add(saveButton);

        tools.setStyle("-fx-border-width: 3px; -fx-border-color: transparent; -fx-background-color: white");
        return tools;
    }

    private void paintCanvas() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < shapeCount; i++) {
            Shape s = shapes[i];
            s.draw(g);
        }
    }

    private void addShape(Shape shape, int left, int top, int width, int height) {
        shape.setColor(currentColor);
        shape.reshape(left, top, width, height);
        shapes[shapeCount] = shape;
        shapeCount++;
        paintCanvas();
    }

    private void mouseClicked(MouseEvent evt) {

        if (dragging) {
            dragging = false;
            //return;
        }
        if (currentShape.toString().contains("Circle"))
            addShape(new CircleShapeWithDot(), (int) evt.getX(), (int) evt.getY(), 75, 75);
        else if (currentShape.toString().contains("Square"))
            addShape(new SquareShapeWithBars(), (int) evt.getX(), (int) evt.getY(), 75, 75);
        else if (currentShape.toString().contains("Ellipse"))
            addShape(new EllipseShape(), (int) evt.getX(), (int) evt.getY(), 100, 50);
        else if (currentShape.toString().contains("Triangle")) {
            addShape(new TriangleShape(), (int) evt.getX(), (int) evt.getY(), 100, 50);
        } else
            System.out.println("No user input detected");
    }

    private void mouseDragged(MouseEvent evt) {
        int x = (int) evt.getX();
        int y = (int) evt.getY();
        if (shapeBeingDragged != null) {
            dragging = true;
            shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
            prevDragX = x;
            prevDragY = y;
            paintCanvas();

        }
    }

    private void mousePressed(MouseEvent evt) {

        int x = (int) evt.getX();
        int y = (int) evt.getY();
        for (int i = shapeCount - 1; i >= 0; i--) {
            Shape s = shapes[i];
            currentShape = shapes[shapeCount - 1];
            if (s.containsPoint(x, y)) {
                shapeBeingDragged = s;
                prevDragX = x;
                prevDragY = y;
                if (evt.isShiftDown()) {
                    for (int j = i; j < shapeCount - 1; j++) {

                        shapes[j] = shapes[j + 1];
                    }
                    shapes[shapeCount - 1] = s;
                    paintCanvas();
                }
                return;
            }
        }
    }



    private void mouseReleased(MouseEvent evt) {
        shapeBeingDragged = null;
    }


}
