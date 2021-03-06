//(C) 2014 zDpxq6
package ex01_10;


//練習問題1.10	ImprovedFibonacciアプリケーションを修正して、数列を配列に保存して、
//最後に値のリストを表示するようにしなさい。
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredImprovedFibonacci altFib = AlteredImprovedFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(altFib.getFibonacci());
	}
}
