//(C) 2014 zDpxq6
package ex14_03;

public class ExecuterRunable implements Runnable{
	private static final int MAX = 100;
	private final Calculator target;
	private final int value;

	/**
	 * コンストラクタ
	 * @param target Calculator型オブジェクト。加算数。
	 * @param value 被加算数。
	 */
	public ExecuterRunable(Calculator target, int value){
		super();
		this.target = target;
		this.value = value;
	}

	/* (非 Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i = 0; i < MAX; i++){
			this.target.add(this.value);
		}

	}

}
