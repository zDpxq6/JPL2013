package counter;
import consta.Const;


public class Counter implements Runnable{

	private final InterfaceForCounterClient service;

	public Counter(InterfaceForCounterClient service){
		super();
		this.service = service;
	}


	@Override
	public void run( ) {
		while (true) {

			this.service.execute();
			try
			{
				Thread.sleep(Const.REFRESH_INTERVAL);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
