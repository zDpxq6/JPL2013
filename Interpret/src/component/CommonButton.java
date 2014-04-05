package component;

import java.awt.event.ActionListener;

import javax.swing.JButton;



public class CommonButton extends JButton{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CommonButton(String buttonLabel, ActionListener actionListener){
		super(buttonLabel);
		addActionListener(actionListener);
	}
}
