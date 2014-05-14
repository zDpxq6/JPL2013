package demo;

import ex14_02.PrintJob;
import ex14_02.PrintServer;

public class Demo {
	public static void main(String[] args){
		PrintServer ps = new PrintServer();
		ps.print(new PrintJob("one"));
		ps.print(new PrintJob("two"));
		ps.print(new PrintJob("three"));
//		ps.run();
	}
}
