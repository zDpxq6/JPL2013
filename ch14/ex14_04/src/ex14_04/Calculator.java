package ex14_04;

public class Calculator {
	private static int value;
	
	public static synchronized void calculate(int value){
		Calculator.value += value;
		System.out.println("add: " + Calculator.value);
	}
}
