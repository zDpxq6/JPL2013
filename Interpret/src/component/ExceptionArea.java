package component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExceptionArea extends JScrollPane{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JTextArea textArea;

	public ExceptionArea(){
		super();
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.textArea.setLineWrap(true);
		this.textArea.setOpaque(false);
		this.setViewportView(this.textArea);
		this.setOpaque(false);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	public void writeException(Throwable e){
		if(e.getCause() == null){
			this.textArea.append(e.toString());
			System.out.println(e.toString());
		}else{
			this.textArea.append(e.getCause().toString());
			System.out.println(e.getCause().toString());
		}
		this.textArea.append("\n");
	}
}
