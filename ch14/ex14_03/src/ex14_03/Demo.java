//(C) 2014 zDpxq6
package ex14_03;

public class Demo {
	private static final int[] DEMO_ARRAY = {1,2,3,4,5};
	private static final Calculator DEMO_TARGET = new Calculator();

	public static void main(String[] args){
		for(int i = 0; i < DEMO_ARRAY.length; i++){
			new Thread(new ExecuterRunable(DEMO_TARGET, DEMO_ARRAY[i])).start();
		}
	}
}
