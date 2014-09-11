package CalculatorImpl;

import Calculator.Calculator;

public class AdditionCalculator extends Calculator{
	private AdditionCalculator(){}

	private static final class CalculatorHolder{
		private static final Calculator INSTANCE = new AdditionCalculator();
	}

	public static Calculator getInstance(){
		return CalculatorHolder.INSTANCE;
	}

	@Override
	public double operate(double d1, double d2) {
		return d1 + d2;
	}
}
