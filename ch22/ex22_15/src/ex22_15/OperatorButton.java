package ex22_15;

import java.awt.Button;

import buttonInterface.Operator;

@SuppressWarnings("serial")
public class OperatorButton extends Button implements Operator{
	public OperatorButton(String str){
		super(str);
	}

	@Override
	public String getValue() {
		return getLabel();
	}



}
