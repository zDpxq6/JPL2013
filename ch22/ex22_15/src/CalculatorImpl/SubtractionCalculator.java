package CalculatorImpl;

import Calculator.Calculator;

public class SubtractionCalculator extends Calculator {
	private SubtractionCalculator(){}

	private static final class CalculatorHolder{
		private static final Calculator INSTANCE = new SubtractionCalculator();
	}

	public static Calculator getInstance(){
		return CalculatorHolder.INSTANCE;
	}
	@Override
	public double operate(double d1, double d2) {
		return d1 - d2;
	}
}
