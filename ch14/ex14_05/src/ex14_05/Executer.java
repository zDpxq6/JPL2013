package ex14_05;

public class Executer implements Runnable{
	private static final int MAX = 100;
	private final int value;
	private final IExecuterInterface target;
	
	public Executer(IExecuterInterface target, int value){
		this.value = value;
		this.target = target;
	}

	@Override
	public void run() {
		for(int i = 0; i < MAX; i++){
			target.calculate(value);
		}
		
	}

}
