package component;

import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListPane extends JScrollPane{
	private final JList jl;
	private final MouseListener i;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ListPane(JList jl, MouseListener i){
		super();
		this.jl = jl;
		this.i = i;
		jl.addMouseListener(this.i);
		this.getViewport().setView(this.jl);
	}

}
