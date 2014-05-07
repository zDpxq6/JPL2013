package component;

import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListPane extends JScrollPane{
	private final JList list;
	private final MouseListener mouseListner;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ListPane(JList list, MouseListener mouseListner){
		super();
		this.list = list;
		this.mouseListner = mouseListner;
		list.addMouseListener(this.mouseListner);
		this.getViewport().setView(this.list);
	}

}
