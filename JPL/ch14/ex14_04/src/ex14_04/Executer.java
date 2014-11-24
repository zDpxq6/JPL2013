//(C) 2014 zDpxq6
package ex14_04;

public class Executer implements Runnable{
	private static final int MAX = 100;
	private final int value;

	/**
	 * コンストラクタ
	 * @param target
	 * @param value
	 */
	public Executer(Calculator target, int value){
		this.value = value;
	}

	/* (非 Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i = 0; i < MAX; i++){
			Calculator.add(this.value);
		}

	}

}
