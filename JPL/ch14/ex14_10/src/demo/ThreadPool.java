package demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreadPool{

	private final List <PooledThread> poolWorkerThread = new LinkedList <PooledThread> ();
	private final Queue <Runnable> queue = new LinkedList <Runnable> ();
	private final int sizeOfQueue;
	private IThreadPoolInterfaceState state = NotRunning.getInstance();
	
	void setState(IThreadPoolInterfaceState newState){
		state = newState;
	}
	
	public IThreadPoolInterfaceState getState(){
		return state;
	}
	
	public ThreadPool(int sizeOfQueue, int numberOfThreads) {
		if(sizeOfQueue < 1 || numberOfThreads < 1){
			throw new IllegalArgumentException();
		}
		
		this.sizeOfQueue = sizeOfQueue;
		for(int i = 0;i < numberOfThreads; i++){
			this.poolWorkerThread.add(new PooledThread());
		}
	}
	
	public void start(){
		this.state.start(this);
	}
	
	public void stop(){
		this.state.stop(this);
	}
	
	public void dispatch(Runnable process){
		if(process == null){
			throw new NullPointerException();
		} else if(getState() instanceof NotRunning ){
			throw new IllegalStateException();
		}
		synchronized(queue){
			if(queue.size() < sizeOfQueue){
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			queue.add(process);
			queue.notifyAll();
		}
	}
	
	public class PooledThread{
		private Thread fieldThread = new Thread();
		
		public void stop(){
			synchronized (queue) {
				queue.notifyAll();
			}
		}
		
		
		
		public void start(){
			fieldThread.start();
		}
		
		public void join() throws InterruptedException{
			fieldThread.join();
		}
		
		public void run() {
			Runnable r;
			while (true) {
				synchronized(queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					r = queue.poll();
					if(r != null){
						queue.notifyAll();
					}
				}
				if(r != null){
					try {
						r.run();
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public List <PooledThread> getPoolWorkerThread() {
		return poolWorkerThread;
	}
}

