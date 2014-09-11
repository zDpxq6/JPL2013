package Calculator;

public abstract class Calculator {
	public final String calculate(String operand1, String operand2){
		if(check1(operand1)==false||check2(operand2)==false){
			System.out.println("引数が不正");
		}
		double convertedOperand1 = Double.valueOf(operand1);
		double convertedOperand2 = Double.valueOf(operand2);
		return Double.valueOf(operate(convertedOperand1, convertedOperand2)).toString();
	}

	protected final boolean check1(String value){
		return value != null && "".equals(value) == false;
	}

	protected boolean check2(String value){
		return check1(value);
	}

	public abstract double operate(double operand1, double operand2);
}
