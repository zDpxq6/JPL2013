package temp;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpListener implements MouseListener {
	Window window;
	MyPopupMenu myPopupMenu;
	Point startDrag, startPos;

	public PopUpListener( Window window, MyPopupMenu myPopupMenu) {
		this.window = window;
		this.myPopupMenu = myPopupMenu;
		window.addMouseListener(this);
	}

	Point getScreenLocation( MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.window.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public void mouseClicked( MouseEvent e) {
		int btn = e.getButton();

		if (btn == MouseEvent.BUTTON3) {
			this.myPopupMenu.popup.show(e.getComponent(), e.getX(), e.getY());
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
//		this.startDrag = getScreenLocation(e);
//		this.startPos = this.window.getLocation();
	}

	@Override
	public void mouseReleased( MouseEvent e) {
	}

}
