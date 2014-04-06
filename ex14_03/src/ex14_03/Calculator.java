package ex14_03;

public class Calculator {
	private int value;
	
	public void add(int value){
		synchronized(this){
			this.value += value;
			System.out.println("add: " + this.value);
		}
	}
}
