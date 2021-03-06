//(C) 2014 zDpxq6
package ex01_07;

import java.util.List;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
public class Demo {
	private static final String MARK = "*";
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredImprovedFibonacci altFib = AlteredImprovedFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		List<?> resultList = Utility.analyzeList(altFib.getFibonacci(), new EvenMarkFilter<Integer>(MARK));
		Utility.printList(resultList);
	}
}
