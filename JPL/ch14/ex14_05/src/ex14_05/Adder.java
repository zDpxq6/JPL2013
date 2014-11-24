package ex14_05;

public class Adder implements IExecuterInterface{
	
	public void calculate(int value){
		synchronized(IExecuterInterface.Target.class){
			IExecuterInterface.Target.set(IExecuterInterface.Target.get() + value);
			System.out.println("add: " + IExecuterInterface.Target.get());
		}
	}
}
