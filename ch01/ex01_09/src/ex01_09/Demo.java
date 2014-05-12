//(C) 2014 zDpxq6
package ex01_09;

//練習問題1.9 Fibonacciアプリケーションを修正して、数列を保存して、最後に値のリストを表示するようにしなさい。
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(altFib.getFibonacci());
	}
}
