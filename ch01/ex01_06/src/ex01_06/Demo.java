//(C) 2014 zDpxq6
package ex01_06;

//練習問題1.6 練習問題1.3で作成したプログラムを修正して、タイトルに対して名前付文字列定数を使用するように修正しなさい。
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(altFib.getFibonacci());
	}
}
