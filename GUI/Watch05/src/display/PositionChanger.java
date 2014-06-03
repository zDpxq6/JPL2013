package display;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PositionChanger implements MouseListener, MouseMotionListener {
	Window window;
	Point startDrag, startPos;

	public PositionChanger( Window window) {
		this.window = window;
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
	}

	Point getScreenLocation( MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.window.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public void mouseClicked( MouseEvent e) {
		int btn = e.getButton();

		if (btn == MouseEvent.BUTTON1) {
			//何もしない
		}
	}

	@Override
	public void mouseEntered( MouseEvent e) {
	}

	@Override
	public void mouseExited( MouseEvent e) {
	}

	@Override
	public void mousePressed( MouseEvent e) {
		this.startDrag = getScreenLocation(e);
		this.startPos = this.window.getLocation();
	}

	@Override
	public void mouseReleased( MouseEvent e) {
	}

	@Override
	public void mouseMoved( MouseEvent e) {
	}

	@Override
	public void mouseDragged( MouseEvent e) {
		Point cursor = getScreenLocation(e);
		int xdiff = cursor.x - this.startDrag.x;
		int ydiff = cursor.y - this.startDrag.y;
		this.window.setLocation(this.startPos.x + xdiff, this.startPos.y+ ydiff);
	}
}
