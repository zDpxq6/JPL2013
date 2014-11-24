//(C) 2014 zDpxq6
package ex14_02;

import java.util.NoSuchElementException;

import print.PrintQueue;
//最初のバージョンのPrintServerを修正して、本文で述べたように、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい。

public class PrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();
	private final Thread myself;

	/**
	 * コンストラクタ
	 */
	public PrintServer(){
		this.myself = new Thread(this);
		this.myself.start();
	}

	/**
	 * このメソッドは、プリントキューにジョブを投入するメソッドである。
	 * @param job
	 */
	public void print(PrintJob job){
		this.requests.add(job);
	}

	/* (非 Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(Thread.currentThread() != this.myself){
			RuntimeException e = new RuntimeException("コンストラクタで生成されたスレッドではありません");
			e.printStackTrace();
			throw e;
		}
		for(;;){
			try{
				delegatePrint(this.requests.remove());
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}
		}
	}

	private void delegatePrint(PrintJob job){
		job.print();
	}

}
