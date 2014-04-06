package ex14_03;

public class Executer implements Runnable{
	private static final int MAX = 100;
	private final Calculator target;
	private final int value;
	
	public Executer(Calculator target, int value){
		this.target = target;
		this.value = value;
	}

	@Override
	public void run() {
		for(int i = 0; i < MAX; i++){
			target.add(value);
		}
		
	}

}
