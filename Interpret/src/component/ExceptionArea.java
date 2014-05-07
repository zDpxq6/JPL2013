package component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExceptionArea extends JScrollPane{

	private static final long serialVersionUID = 1L;
	private final JTextArea textArea = new JTextArea();

	public ExceptionArea(){
		super();
		this.initTextArea();
		this.setViewportView(this.textArea);
		this.setOpaque(false);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	private void initTextArea(){
		this.textArea.setEditable(false);
		this.textArea.setLineWrap(true);
		this.textArea.setOpaque(false);
	}

	public void writeException(Throwable e){
		if(e.getCause() == null){
			this.textArea.append(e.toString());
		}else{
			this.textArea.append(e.getCause().toString());
		}
		this.textArea.append("\n");
	}
}
