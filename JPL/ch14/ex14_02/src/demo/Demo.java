//(C) 2014 zDpxq6
package demo;

import ex14_02.PrintJob;
import ex14_02.PrintServer;
//最初のバージョンのPrintServerを修正して、本文で述べたように、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい。
public class Demo {
	public static void main(String[] args){
		PrintServer ps = new PrintServer();
		ps.print(new PrintJob("one"));
		ps.print(new PrintJob("two"));
		ps.print(new PrintJob("three"));
//		ps.run();
	}
}
