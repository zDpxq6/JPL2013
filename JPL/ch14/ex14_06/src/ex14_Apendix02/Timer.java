package ex14_Apendix02;

public class Timer implements Runnable {
	private static final long INTERVAL = 1000;
	private long counter = 0;
	private final Object lock = new Object();

	@Override
	public void run() {
		method();
	}
	
	private void method(){
		for(;;){
			try {
				Thread.sleep(INTERVAL);
				
				synchronized(lock){
					lock.notifyAll();
					incrimentCounter();//notifyAll()synchronizedブロックから出るまでは実行される
					System.out.print("\n" + counter);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Object getLock(){
		return lock;
	}
	
	private Timer(){}
	private static final class Holder{
		private static final Timer INSTANCE = new Timer();
	}
	public static final Timer getInstance(){
		return Holder.INSTANCE;
	}
	
	private void incrimentCounter(){
		if(counter < 0){
			counter = 0;
		}
		counter++;
	}

}
