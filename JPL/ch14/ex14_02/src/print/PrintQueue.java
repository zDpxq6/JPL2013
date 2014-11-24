//(C) 2014 zDpxq6
package print;

import java.util.LinkedList;
import java.util.Queue;
//最初のバージョンのPrintServerを修正して、本文で述べたように、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい。

import ex14_02.PrintJob;

public class PrintQueue{
	private final Queue <PrintJob> innerQueue = new LinkedList<PrintJob>();

	/**
	 * このメソッドは、キューにジョブを追加するメソッドである。
	 * @param 追加するジョブ
	 * @return 追加できた場合にtrue
	 */
	public synchronized boolean add(PrintJob arg0) {
		return this.innerQueue.add(arg0);
	}

	/**
	 * キューの先頭を取得および削除します。
	 * @return キューの先頭
	 */
	public PrintJob remove() {
		return this.innerQueue.remove();
	}

}
