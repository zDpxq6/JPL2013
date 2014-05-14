//(C) 2014 zDpxq6
package ex01_03;

import java.util.Iterator;
import java.util.List;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
/**
 * @auther zDpxq6
 * UtilityクラスはFibonacciクラスの「フィボナッチ数列の出力」の責務を抽出し、「List型オブジェクトの出力」へ抽象化したクラスである。
 * */
public class Utility {
	/**
	 * printListメソッドは、List型のオブジェクトを引数に取り、そのオブジェクトの内容を標準出力に出力するメソッドである。
	 *
	 * @param list
	 *            List型のlistは、標準出力に出力するリストである。
	 * */
	public static <E> void printList(List<E> list) {
		Iterator<E> ite = list.iterator();
		while (ite.hasNext()) {
			E element = ite.next();
			System.out.println(element);
		}
	}
}
