//(C) 2014 zDpxq6
package ex01_10;

import java.util.ArrayList;
import java.util.List;

//練習問題1.10	ImprovedFibonacciアプリケーションを修正して、数列を配列に保存して、
//				最後に値のリストを表示するようにしなさい。
/**
 * @auther zDpxq6
 * */
public class AlteredImprovedFibonacci {
	private int[] fibonacci;// = new int[];

	private AlteredImprovedFibonacci() {
		super();
	}

	/**
	 * @param terminationCondition
	 *            生成されるフィボナッチ数列の要素の最大値を決定する。
	 *            生成されるフィボナッチ数列の要素の最大値は、かならずterminationCondition以下となる。
	 *            そのため、terminationConditionの最小値は1である。
	 * @return terminationConditionで指定された条件を満たすAlteredFibonacciクラスのインスタンス
	 * */
	public static AlteredImprovedFibonacci createAlteredFibonacci(int terminationCondition) {
		if(terminationCondition <= 1){
			throw new IllegalArgumentException();
		}
		AlteredImprovedFibonacci altFib = new AlteredImprovedFibonacci();
		altFib.makeFibonacci(terminationCondition);
		return altFib;
	}

	private void makeFibonacci(int terminationCondition) {
		int low = 0;
		int high = 1;
		List <Integer> fibonacci = new ArrayList <Integer> ();
		while (high <= terminationCondition) {
			fibonacci.add(high);
			high = high + low; // 新しいhi
			low = high - low; /*
							 * 新しいloは、(合計 - 古いlo) すなわち、古いhi
							 */
		}
		this.fibonacci=convertToArray(fibonacci);
	}

	//2回ループするのがいまいち。
	//要素数は要素の最大値より大きくならないはずなので、要素の最大値を配列数として配列を作ってもいいかも。
	//その後、値の入っているところだけを抽出するのが良い?
	private static final int[] convertToArray(List<Integer> list){
		int[] result = new int[list.size()];
		int i = 0;
		for(Integer e: list){
			result[i++] = e;
		}
		return result;
	}

	/**
	 * @return フィボナッチ数列
	 */
	public int[] getFibonacci() {
		return this.fibonacci;
	}

}
