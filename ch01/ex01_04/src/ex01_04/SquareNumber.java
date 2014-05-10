//(C) 2014 zDpxq6
package ex01_04;

import java.util.LinkedList;
import java.util.List;

//練習問題1.4 何らかの数列を生成するプログラムを作成しなさい。例えば、平方表とか
/**
 * @auther zDpxq6
 * */
public class SquareNumber {
	private final List<Integer> squareNumber = new LinkedList<Integer>();

	private SquareNumber() {
		super();
	}

	/**
	 * @param terminationCondition
	 *            int型のterminationConditionは、生成される平方表の要素の最大値を決定する。
	 *            生成される平方表の要素の最大値は、かならずterminationConditionの二乗以下となる。
	 * @return terminationConditionで指定された条件を満たすSquareNumberクラスのインスタンス
	 * */
	public static SquareNumber createSquareNumber(int terminationCondition) {
		if(terminationCondition < 0){
			throw new IllegalArgumentException();
		}
		SquareNumber squNum = new SquareNumber();
		squNum.makeSquareNumber(terminationCondition);
		return squNum;
	}

	private void makeSquareNumber(int terminationCondition) {
		for(int i = 0; i <= terminationCondition; i++){
			this.squareNumber.add(i*i);
		}
	}

	/**
	 * @return 平方表
	 */
	public List<Integer> getSquareNumber() {
		return this.squareNumber;
	}

}
