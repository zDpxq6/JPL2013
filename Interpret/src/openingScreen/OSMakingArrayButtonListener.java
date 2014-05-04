package openingScreen;


//éQçl http://d.hatena.ne.jp/kya-zinc/20121216
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JTextField;

import component.ExceptionArea;
import component.Models;
import creatingArray.MakingArrayScreen;

public class OSMakingArrayButtonListener implements ActionListener {

	private final JSpinner sp;
	private final JTextField tf;
	private final Models mdls;
	private final ExceptionArea ea;

	public OSMakingArrayButtonListener(JSpinner arrayLengthSpinner, JTextField classNameField, Models mdls, ExceptionArea ea){
		this.sp = arrayLengthSpinner;
		this.tf = classNameField;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			String className= this.tf.getText();
			Class<?> selectedClass  = null;
			selectedClass = Class.forName(className);
			@SuppressWarnings("unused")
			MakingArrayScreen aui = new MakingArrayScreen (selectedClass, this.sp, this.mdls ,this.ea);
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}
}