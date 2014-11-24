package ex14_09;

public class Demo{
	public static void main(String[] args){
		ThreadGroup thg1 = new ThreadGroup("Group1");

		Thread th1 = new Thread(thg1, new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread1");
		th1.start();

		ThreadGroup thg2 = new ThreadGroup(thg1,"Group2");
		Thread th2 = new Thread(thg2, new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread2");
		th2.start();

		ThreadHierarchyPrinter thp = new ThreadHierarchyPrinter();
		thp.printThreadHierarchy(thg1);
	}
}