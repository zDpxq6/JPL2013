package ex22_15;

import java.awt.Button;

import buttonInterface.Operand;

@SuppressWarnings("serial")
public class OperandButton extends Button implements Operand{
	public OperandButton(String str){
		super(str);
	}
	@Override
	public String getValue() {
		return getLabel();
	}

}
