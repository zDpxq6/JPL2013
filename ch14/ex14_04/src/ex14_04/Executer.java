package ex14_04;

public class Executer implements Runnable{
	private static final int MAX = 100;
	private final int value;
	
	public Executer(Calculator target, int value){
		this.value = value;
	}

	@Override
	public void run() {
		for(int i = 0; i < MAX; i++){
			Calculator.calculate(value);
		}
		
	}

}
