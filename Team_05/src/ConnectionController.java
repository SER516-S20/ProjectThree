import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class ConnectionController implements MouseListener, MouseMotionListener{
	private static Connection tempconnection;
	private static List<Connection> connections = new ArrayList<Connection>();
	private RightPanel rightpanel;
	public ConnectionController(RightPanel rightpanel) {
		this.rightpanel = rightpanel;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setLocation(e.getX() + (int)e.getComponent().getX()-e.getComponent().getPreferredSize().width/2, 
				 e.getY() + (int)e.getComponent().getY()-e.getComponent().getPreferredSize().height/2);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		Box instance = Box.getInstance();
		int jX = e.getX();
		int jY = e.getY();
		boolean selected = false;
		if(obj instanceof RoundButton) {
			RoundButton btn = (RoundButton)obj;
			if(jX>=btn.getCenterPoint().x-3 && jX <= btn.getCenterPoint().x+3 && jY >= btn.getCenterPoint().y-3 && jY <= btn.getCenterPoint().y+3) {
				for(int i=0; i < connections.size(); i++) {
					Connection c = connections.get(i);
					if(btn.getBounds().getCenterX() == c.getSourceX() && btn.getBounds().getCenterY() == c.getSourceY()) {
						selected = true;
						tempconnection = null;
					}
					else if(btn.getBounds().getCenterX() == c.getDestX() && btn.getBounds().getCenterY() == c.getDestY()) {
						selected = true;
						tempconnection = null;
					}
				}
				if(!selected) {
					if(tempconnection == null) {
						tempconnection = new Connection();
						tempconnection.setSourceX((int)btn.getBounds().getCenterX());
						tempconnection.setSourceY((int)btn.getBounds().getCenterY());
					}
					else if (tempconnection != null) {
						tempconnection.setDestX((int)btn.getBounds().getCenterX());
						tempconnection.setDestY((int)btn.getBounds().getCenterY());
						rightpanel.setConnection(tempconnection);
						connections.add(tempconnection);
						tempconnection = null;
					}
					else {
						tempconnection = null;
					}
				}
			}
		}
		else if(obj instanceof TriangleButton) {
			TriangleButton btn = (TriangleButton)obj;
			Point []points = btn.getPointsPosition();
			for(int i = 0; i < 3; i++) {
				if(jX>=points[i].x-3 && jX <= points[i].x+3 && jY >= points[i].y-3 && jY <= points[i].y+3) {
					for(int j=0; j < connections.size(); j++) {
						Connection c = connections.get(j);
						if(btn.getBounds().x+points[i].x == c.getSourceX() && btn.getBounds().y+points[i].y == c.getSourceY()) {
							selected = true;
							tempconnection = null;
						}
						else if(btn.getBounds().x+points[i].x == c.getDestX() && btn.getBounds().y+points[i].y == c.getDestY()) {
							selected = true;
							tempconnection = null;
						}
					}
					if(!selected) {
						if(tempconnection == null) {
							tempconnection = new Connection();
							tempconnection.setSourceX(btn.getBounds().x+points[i].x);
							tempconnection.setSourceY(btn.getBounds().y+points[i].y);
						}
						else if (tempconnection != null) {
							tempconnection.setDestX(btn.getBounds().x+points[i].x);
							tempconnection.setDestY(btn.getBounds().y+points[i].y);
							rightpanel.setConnection(tempconnection);
							connections.add(tempconnection);
							tempconnection = null;
						}
						else {
							tempconnection = null;
						}
					}
				}
			}
		}
		else {
			RectangleButton btn = (RectangleButton)obj;
			Point []points = btn.getPointsPosition();
			if(jX == points[0].x || jX == points[2].x) {
				if(jY >= points[0].y && jY <= points[1].y) {
					if(tempconnection == null) {
						tempconnection = new Connection();
						tempconnection.setSourceX(btn.getBounds().x+jX);
						tempconnection.setSourceY(btn.getBounds().y+jY);
					}
					else if (tempconnection != null) {
						tempconnection.setDestX(btn.getBounds().x+jX);
						tempconnection.setDestY(btn.getBounds().y+jY);
						rightpanel.setConnection(tempconnection);
						connections.add(tempconnection);
						tempconnection = null;
					}
					else {
						tempconnection = null;
					}
				}
			}
		}

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
