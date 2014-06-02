package ex14_05;

public class Subtractor implements IExecuterInterface{
	
	public synchronized void calculate(int value){
		synchronized(IExecuterInterface.class){
			IExecuterInterface.Target.set(IExecuterInterface.Target.get() - value);
			System.out.println("sub: " + IExecuterInterface.Target.get());
		}
	}
	
}
