import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.abs;

/**
 * @author Aravind Thillai Villalan
 * @since 02-20-2020
 */

public class Triangle extends Shapes implements Serializable {
    int[] verticesX;
    int[] verticesY;
    int NUMBER_OF_POINTS = 3;

    public Triangle(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        verticesX = new int[]{this.xCoordinate, 100 + this.xCoordinate, 50 + this.xCoordinate};
        verticesY = new int[]{86 + this.yCoordinate, 86 + this.yCoordinate, this.yCoordinate};
    }

    public void createShape(Graphics graphics) {

        Color lightRed = new Color(200, 9, 0, 100);
        graphics.setColor(lightRed);
        graphics.fillPolygon(verticesX, verticesY, NUMBER_OF_POINTS);
        new Dot(50 + this.xCoordinate, 20 + this.yCoordinate, graphics);
        new Dot(20 + this.xCoordinate, 72 + this.yCoordinate, graphics);
        new Dot(80 + this.xCoordinate, 72 + this.yCoordinate, graphics);
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

    private float area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (float) abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

}
