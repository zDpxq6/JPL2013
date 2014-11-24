////(C) 2014 zDpxq6
//package original;
//
//import print.PrintQueue;
//
////練習問題14.2
////最初のバージョンのPrintServerを修正して、本書で述べたように、スレッドの識別により
////コンストラクタで生成されたスレッドだけがrunできるようにしなさい。
//public class PrintServer implements Runnable {
//	private final PrintQueue requests = new PrintQueue();
//
//	public PrintServer() {
//		new Thread(this).start();
//	}
//
//	public void print(PrintJob job) {
//		this.requests.add(job);
//	}
//
//	@Override
//	public void run() {
//		for (;;) {
//			realPrint(this.requests.remove());
//		}
//	}
//
//	private void realPrint(PrintJob job) {
//
//	}
//
//}
