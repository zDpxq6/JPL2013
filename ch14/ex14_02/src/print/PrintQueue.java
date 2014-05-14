package print;

import java.util.LinkedList;
import java.util.Queue;

import ex14_02.PrintJob;

public class PrintQueue{
	private Queue <PrintJob> innerQueue = new LinkedList<PrintJob>();

	public synchronized boolean add(PrintJob arg0) {
		return innerQueue.add(arg0);
	}

	public PrintJob remove() {
		return innerQueue.remove();
	}

}
