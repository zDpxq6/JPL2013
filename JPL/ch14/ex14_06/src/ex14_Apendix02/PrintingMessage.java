package ex14_Apendix02;

public class PrintingMessage implements Runnable {
	private final String name;
	private final long timing;
	private final Timer timer = Timer.getInstance();
	private long counter;
	
	public PrintingMessage(String name, long timing){
		if(name == null){
			throw new NullPointerException();
		} else if(timing < 1){
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.timing = timing;
	}

	@Override
	public void run() {
		for(;;){
			try {
				while(counter != timing){
					synchronized(timer.getLock()){
						timer.getLock().wait();
					}
					counter++;
				}
				System.out.print("\t" + name);
				counter = 0;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
