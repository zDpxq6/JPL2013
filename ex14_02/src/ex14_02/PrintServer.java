package ex14_02;

import java.util.NoSuchElementException;

import print.PrintQueue;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private final Thread myself;
	
	public PrintServer(){
		myself = new Thread(this);
		myself.start();
	}
	
	public void print(PrintJob job){
		requests.add(job);
	}
	@Override
	public void run() {
		if(Thread.currentThread() != myself){
			RuntimeException e = new RuntimeException("不正な呼び出し");
			e.printStackTrace();
			throw e;
		}
		for(;;){
			try{
				realPrint(requests.remove());
			}catch(NoSuchElementException e){
				//何もしない
			}
		}
	}
	private void realPrint(PrintJob job){
		job.print();
	}
	
}
