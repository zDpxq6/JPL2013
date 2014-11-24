package ex14_09;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadHierarchyPrinter {
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

	private static final int INTERVAL = 1000;
	public void printThreadHierarchy(final ThreadGroup group) {
		printThreadHierarchy(group, INTERVAL);
	}

	private void printThreadHierarchy(final ThreadGroup group, final int period) {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println(ThreadHierarchyPrinter.this.dateFormat.format(ThreadHierarchyPrinter.this.date));
					print(group, 0);
					System.out.println();
					try {
						sleep(period);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private void print(ThreadGroup group, int depth) {

		// Print ThreadGroup
		System.out.println(getTabs(depth) + "ThreadGroup: " + group.getName());
		printThread(group,depth);
		printThreadGroup(group,depth);
	}

	private void printThread(ThreadGroup group, int depth){
		// Print Thread
		int threadCount = group.activeCount();
		Thread[] threads = new Thread[threadCount];
		group.enumerate(threads, false);
		for (Thread e : threads) {
			if (e != null) {
				System.out.println(getTabs(depth + 1) + "Thread: " + e.getName());
			}
		}
	}

	private void printThreadGroup(ThreadGroup group, int depth){
		int groupCount = group.activeGroupCount();
		ThreadGroup[] threadGroups = new ThreadGroup[groupCount];
		group.enumerate(threadGroups, false);
		for (ThreadGroup e : threadGroups) {
			if (e != null) {
				print(e, depth + 1);
			}
		}
	}

	private String getTabs(int width) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < width; i++) {
			buffer.append("\t");
		}
		return buffer.toString();
	}
}