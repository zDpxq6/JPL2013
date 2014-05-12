//(C) 2014 zDpxq6
package ex01_10;

import java.util.LinkedList;
import java.util.List;

//練習問題1.10 ImprovedFibonacciアプリケーションを修正して、数列を保存するようにしなさい。
//その際に、数列の値とその値が偶数かを示すブール値を保持するクラスを作成して、そのクラスのオブジェクトへの参照を配列として持つようにしなさい
/**
 * @auther zDpxq6
 * */
public class AlteredFibonacci {
	private Integer[] fibonacci;

	private AlteredFibonacci() {
		super();
	}

	/**
	 * @param terminationCondition
	 *            int型のterminationConditionは、生成されるフィボナッチ数列の要素の最大値を決定する。
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
		List<Integer> fibonacciList = new LinkedList<Integer>();
		while (high <= loopTerminationCondition) {
			fibonacciList.add(high);
			high = high + low; // 新しいhi
			low = high - low; /*
							 * 新しいloは、(合計 - 古いlo) すなわち、古いhi
							 */
		}
		this.fibonacci = fibonacciList.toArray(new Integer[0]);
	}

	/**
	 * @return フィボナッチ数列
	 */
	public Integer[] getFibonacci() {
		return this.fibonacci;
	}

}
