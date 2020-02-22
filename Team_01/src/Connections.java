import java.io.Serializable;

/**
 * This class has line information that requires source and destination end
 * point
 * 
 * @author Mayank Kataruka
 * @version 1.0
 */

public class Connections implements Serializable {

	private static final long serialVersionUID = 1L;
	private int sourceX, sourceY, destX, destY;
	private Shapes originShape, destShape;

	public Shapes getOriginShape() {
		return originShape;
	}

	public void setOriginShape(Shapes originShape) {
		this.originShape = originShape;
	}

	public Shapes getDestShape() {
		return destShape;
	}

	public void setDestShape(Shapes destShape) {
		this.destShape = destShape;
	}

	public int getSourceX() {
		return sourceX;
	}

	public void setSourceX(int sourceX) {
		this.sourceX = sourceX;
	}

	public int getSourceY() {
		return sourceY;
	}

	public void setSourceY(int sourceY) {
		this.sourceY = sourceY;
	}

	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}

}
