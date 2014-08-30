//(C) 2014 zDpxq6
package ex01_10.demo;

import java.util.List;

import ex01_10.AlteredFibonacci;
import ex01_10.EvenMarkFilter;
import ex01_10.Utility;


//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
public class Demo {
	private static final String MARK = "*";
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		List<Object> resultList = Utility.analyzeList(altFib.getFibonacci(), new EvenMarkFilter<Integer>(MARK));
		Utility.printListWithIndex(resultList);
	}
}
