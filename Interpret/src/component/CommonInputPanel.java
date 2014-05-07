package component;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CommonInputPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final GridLayout LABEL_INPUT_BUTTON_LAYOUT = new GridLayout(1, 3);

	public CommonInputPanel(JLabel label, JComponent inputComponent, String buttonLabel, ActionListener actionListener, boolean flag){
		super();
		this.setLayout(LABEL_INPUT_BUTTON_LAYOUT);
		this.add(label);
		this.add(inputComponent);
		if(flag == true) {
			this.add(makeCommonButton(buttonLabel, actionListener));
		}
	}

	public static JButton makeCommonButton(String buttonLabel, ActionListener i) {
		JButton result = new JButton(buttonLabel);
		result.addActionListener(i);
		return result;
	}
}
