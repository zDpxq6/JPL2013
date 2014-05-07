package display;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class PositionChanger implements MouseListener, MouseMotionListener {
	JFrame frame;
	Point startDrag, startPos;

	public PositionChanger( JFrame flame) {
		this.frame = flame;
		flame.addMouseListener(this);
		flame.addMouseMotionListener(this);
	}

	Point getScreenLocation( MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.frame.getLocationOnScreen();
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
		this.startPos = this.frame.getLocation();
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
		this.frame.setLocation(this.startPos.x + xdiff, this.startPos.y+ ydiff);
	}
}
