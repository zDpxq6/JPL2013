package demo;

import java.util.List;

import demo.ThreadPool.PooledThread;

public class NotRunning implements IThreadPoolInterfaceState{
	
	private static class NotRunningHolder {
		private static NotRunning INSTANCE = new NotRunning();
	}
	
	private NotRunning(){
	}
	
	public static NotRunning getInstance(){
		return NotRunningHolder.INSTANCE;
	}

	@Override
	public void start(ThreadPool context) {
		List <PooledThread> poolWorkerThread = context.getPoolWorkerThread();
		for(PooledThread element : poolWorkerThread){
			element.start();
		}
		context.setState(Running.getInstance());
	}

	@Override
	public void stop(ThreadPool context) {
		throw new IllegalStateException();
	}



}
