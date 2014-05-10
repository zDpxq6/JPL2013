//(C) 2014 zDpxq6
package ex01_06;

import java.util.Iterator;
import java.util.List;

//練習問題1.6 練習問題1.3で作成したプログラムを修正して、タイトルに対して名前付文字列定数を使用するように修正しなさい。
/**
 * @auther zDpxq6
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
