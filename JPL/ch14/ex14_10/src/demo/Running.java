package demo;

import java.util.List;

import demo.ThreadPool.PooledThread;

public class Running implements IThreadPoolInterfaceState{
	
	private static class RunningHolder {
		private static Running INSTANCE = new Running();
	}
	
	private Running(){
	}
	
	public static Running getInstance(){
		return RunningHolder.INSTANCE;
	}

	@Override
	public void start(ThreadPool context) {
		throw new IllegalStateException();
	}

	@Override
	public void stop(ThreadPool context) {
		List <PooledThread> poolWorkerThread = context.getPoolWorkerThread();
		for(PooledThread element : poolWorkerThread){
			element.stop();
			try {
				element.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		context.setState(NotRunning.getInstance());
	}
	
}
