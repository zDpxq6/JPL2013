//(C) 2014 zDpxq6
package ex01_04;

//練習問題1.4 何らかの数列を生成するプログラムを作成しなさい。例えば、平方表とか
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 2;

	public static void main(String[] args) {
		SquareNumber altFib = SquareNumber.createSquareNumber(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(altFib.getSquareNumber());
	}
}
