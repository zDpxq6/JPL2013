//(C) 2014 zDpxq6
package ex01_03;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
public class Fibonacci {
	/** 値が50未満のフィボナッチ数列を表示する */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi; // 新しいhi
			lo = hi - lo; /*
						 * 新しいloは(合計-古いlo) すなわち古いhi
						 */
		}
	}
}
