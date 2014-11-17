//(C) 2014 zDpxq6
package ex01_04;

//練習問題1.4 何らかの数列を生成するプログラムを作成しなさい。例えば、平方表とか
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 2;

	public static void main(String[] args) {
		SquareNumber altFib = ForSquareNumber.createSquareNumber(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(((ForSquareNumber) altFib).getSquareNumber());
		altFib = ForSquareNumber.createSquareNumber(TERMINATING_CONDITION);

		altFib = WhileSquareNumber.createSquareNumber(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(((WhileSquareNumber) altFib).getSquareNumber());

		altFib = DoWhileSquareNumber.createSquareNumber(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Utility.printList(((DoWhileSquareNumber) altFib).getSquareNumber());
	}
}
