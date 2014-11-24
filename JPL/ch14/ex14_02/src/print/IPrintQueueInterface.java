//(C) 2014 zDpxq6
package print;

//最初のバージョンのPrintServerを修正して、本文で述べたように、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい。
public interface IPrintQueueInterface {

	/**
	 * このメソッドは、キューに格納されている要素を得るメソッドである。
	 *
	 * @return キューの要素
	 */
	public Object getContent();

	/**
	 * このメソッドは、キューの要素を表示するメソッドである。
	 */
	public void print();
}
