import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import static java.lang.Math.abs;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Triangle extends Shapes implements Serializable {
    int[] verticesX = {0, 100, 50};
    int[] verticesY = {86, 86, 0};
    int HEIGHT = 86;
    int WIDTH = 100;
    int NUMBER_OF_POINTS = 3;
    Dot[] dots = new Dot[3];
    int[] dotCoordinatesX = {50, 20, 80};
    int[] dotCoordinatesY = {20, 72, 72};

    public Triangle(int x, int y) {
        this.xCoordinate = x - (WIDTH / 2);
        this.yCoordinate = y - (HEIGHT / 2);
        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            verticesX[i] += x - (WIDTH / 2);
            verticesY[i] += y - (HEIGHT / 2);
        }
    }

    public void createShape(Graphics graphics) {
        Color lightRed = new Color(200, 9, 0, 100);
        graphics.setColor(lightRed);
        graphics.fillPolygon(verticesX, verticesY, NUMBER_OF_POINTS);
        dots[0] = new Dot(dotCoordinatesX[0] + this.xCoordinate,
                dotCoordinatesY[0] + this.yCoordinate, graphics);
        dots[1] = new Dot(dotCoordinatesX[1] + this.xCoordinate,
                dotCoordinatesY[1] + this.yCoordinate, graphics);
        dots[2] = new Dot(dotCoordinatesX[2] + this.xCoordinate,
                dotCoordinatesY[2] + this.yCoordinate, graphics);
    }

    @Override
    public boolean isInside(int x, int y) {
        float A = area(verticesX[0], verticesY[0], verticesX[1], verticesY[1], verticesX[2], verticesY[2]);
        float A1 = area(x, y, verticesX[1], verticesY[1], verticesX[2], verticesY[2]);
        float A2 = area(verticesX[0], verticesY[0], x, y, verticesX[2], verticesY[2]);
        float A3 = area(verticesX[0], verticesY[0], verticesX[1], verticesY[1], x, y);
        return (A == A1 + A2 + A3);
    }

    @Override
    public void changeLocation(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        verticesX = new int[]{this.xCoordinate, 100 + this.xCoordinate, 50 + this.xCoordinate};
        verticesY = new int[]{86 + this.yCoordinate, 86 + this.yCoordinate, this.yCoordinate};
    }

    @Override
    public Shapes getClickedDotOrBar(MouseEvent mouseEvent) {
        for (Dot dot : dots) {
            if (dot.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                return dot;
            }
        }
        return null;
    }

    @Override
    public boolean isDotOrBarClicked(MouseEvent mouseEvent) {
        boolean tempFlag = false;
        for (int i = 0; i < dots.length; i++) {
            if (dots[i].isInside(mouseEvent.getX(), mouseEvent.getY())) {
                tempFlag = true;
            }
        }
        return tempFlag;
    }


    private float area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (float) abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

}
