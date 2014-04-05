package openingScreen;


//参考 http://d.hatena.ne.jp/kya-zinc/20121216
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import component.ExceptionArea;

import createingConstructor.ListScreen;

public class OSMakingObjectButtonListener implements ActionListener {

	private final JTextField tf;
	private final Models mdls;
	private final ExceptionArea ea;

	public OSMakingObjectButtonListener(JTextField classNameField, Models mdls, ExceptionArea ea) {
		this.tf = classNameField;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			String className= this.tf.getText();
			Class <?> selectedClass = Class.forName(className);
			@SuppressWarnings("unused")
			ListScreen cui = new ListScreen(selectedClass, this.mdls, this.ea);
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}
}