//(C) 2014 zDpxq6
package ex14_04;

//練習問題14.3を修正してstaticデータとstaticメソッドを使用するようにしなさい。

public class Calculator {
	private static int value;

	/**
	 * このメソッドは、加算を繰り返すメソッドである。
	 *
	 * @param value
	 *            新たに加える数
	 */
	public static synchronized void add(int value) {
		Calculator.value += value;
		System.out.println("add: " + Calculator.value);
	}
}
