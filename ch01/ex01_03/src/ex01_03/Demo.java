//(C) 2014 zDpxq6
package ex01_03;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(altFib.getFibonacci());
	}
}
