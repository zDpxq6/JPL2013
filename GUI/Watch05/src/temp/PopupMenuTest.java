package temp;
import java.applet.Applet;
import java.awt.AWTEvent;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

    public class PopupMenuTest extends Applet implements ActionListener {

	/**
		 *
		 */
		private static final long serialVersionUID = 1L;
	PopupMenu popup;

	public void init() {
            MenuItem mi;

	    this.popup = new PopupMenu("Edit");

            mi = new MenuItem("Cut");
            mi.addActionListener(this);
	    this.popup.add(mi);

            mi = new MenuItem("Copy");
            mi.addActionListener(this);
	    this.popup.add(mi);

	    this.popup.addSeparator();

            mi = new MenuItem("Paste");
            mi.addActionListener(this);
	    this.popup.add(mi);

	    add(this.popup); // add popup menu to applet

            enableEvents(AWTEvent.MOUSE_EVENT_MASK);

	    resize(200, 200);
        }

	public void processMouseEvent(MouseEvent e) {

	    if (e.isPopupTrigger()) {
	        this.popup.show(e.getComponent(), e.getX(), e.getY());
	    }
	    super.processMouseEvent(e);
        }

        @Override
		public void actionPerformed(ActionEvent e) {
	    String command = e.getActionCommand();

            if (command.equals("Cut")) {
	        // perform cut operation
            } else if (command.equals("Copy")) {
                // perform copy operation
            } else if (command.equals("Paste")) {
                // perform paste operation
            }
        }
    }