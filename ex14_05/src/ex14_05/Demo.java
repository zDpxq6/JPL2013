package ex14_05;

public class Demo {
	private static final int[] DEMO_ARRAY = {1,2,3,4,5};
	private static final IExecuterInterface DEMO_TARGET1 = new Adder();
	private static final IExecuterInterface DEMO_TARGET2 = new Subtractor();
	
	public static void main(String[] args){
		for(int i = 0; i < DEMO_ARRAY.length; i++){
			new Thread(new Executer(DEMO_TARGET1, DEMO_ARRAY[i])).start();
			new Thread(new Executer(DEMO_TARGET2, DEMO_ARRAY[(DEMO_ARRAY.length-1)-i])).start();
		}
	}
}
