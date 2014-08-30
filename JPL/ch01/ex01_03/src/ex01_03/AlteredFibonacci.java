//(C) 2014 zDpxq6
package ex01_03;

import java.util.LinkedList;
import java.util.List;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
/**
 * @auther zDpxq6
 * AlteredFibonacciクラスはFibonacciクラスの「フィボナッチ数列の生成」の責務を抽出したクラスである。
 *
 * */
public class AlteredFibonacci {
	private final List<Integer> fibonacci = new LinkedList<Integer>();

	private AlteredFibonacci() {
		super();
	}

	/**
	 * @param terminationCondition
	 *            生成されるフィボナッチ数列の要素の最大値を決定する。
	 *            生成されるフィボナッチ数列の要素の最大値は、かならずterminationCondition以下となる。
	 *            そのため、terminationConditionの最小値は1である。
	 * @return terminationConditionで指定された条件を満たすAlteredFibonacciクラスのインスタンス
	 * */
	public static AlteredFibonacci createAlteredFibonacci(int terminationCondition) {
		if(terminationCondition <= 1){
			throw new IllegalArgumentException();
		}
		AlteredFibonacci altFib = new AlteredFibonacci();
		altFib.makeFibonacci(terminationCondition);
		return altFib;
	}

	private void makeFibonacci(int loopTerminationCondition) {
		int low = 0;
		int high = 1;
		while (high <= loopTerminationCondition) {
			this.fibonacci.add(high);
			high = high + low; // 新しいhi
			low = high - low; /*
							 * 新しいloは、(合計 - 古いlo) すなわち、古いhi
							 */
		}
	}

	/**
	 * @return IntegerのList型のフィボナッチ数列
	 */
	public List<Integer> getFibonacci() {
		return this.fibonacci;
	}

}
