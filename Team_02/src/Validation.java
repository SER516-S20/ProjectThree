/**
 * @author Sarvansh Prasher
 * @created on 17th Feb 2020
 * @version 1.0
 */
public class Validation {
	public boolean isInsideSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x, int y) {
		int Xmax;
		int Xmin;
		int Ymax;
		int Ymin;
		Xmax = Math.max(Math.max(x3, x4), Math.max(x1, x2));
		Ymax = Math.max(Math.max(y3, y4), Math.max(y1, y2));
		Xmin = Math.min(Math.min(x3, x4), Math.min(x1, x2));
		Ymin = Math.min(Math.min(y3, y4), Math.min(y1, y2));
		if ((x >= Xmin && x <= Xmax) && (y >= Ymin && y <= Ymax)) {
			return false;
		}
		return true;
	}
}
