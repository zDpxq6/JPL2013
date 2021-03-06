package CalculatorImpl;

import Calculator.Calculator;

public class ModCalculator extends Calculator {
	private ModCalculator(){}

	private static final class CalculatorHolder{
		private static final Calculator INSTANCE = new ModCalculator();
	}

	public static Calculator getInstance(){
		return CalculatorHolder.INSTANCE;
	}
	@Override
	protected boolean check2(String value){
		return check1(value) && "0".equals(value)==false;
	}
	@Override
	public double operate(double d1, double d2) {
		return d1 % d2;
	}
}
