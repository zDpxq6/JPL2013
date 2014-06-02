//(C) 2014 zDpxq6
package ex14_02;

import print.IPrintQueueInterface;
//最初のバージョンのPrintServerを修正して、本文で述べたように、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにしなさい。

public class PrintJob implements IPrintQueueInterface {
	private final String content;

	/**
	 * @param content
	 * コンストラクタ
	 */
	public PrintJob(String content) {
		super();
		if (content == null) {
			throw new NullPointerException();
		}
		this.content = content;
	}

	/* (非 Javadoc)
	 * @see print.IPrintQueueInterface#getContent()
	 */
	@Override
	public Object getContent() {
		return this.content;
	}

	/* (非 Javadoc)
	 * @see print.IPrintQueueInterface#print()
	 */
	@Override
	public void print() {
		System.out.println(this);
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.content;
	}
}
