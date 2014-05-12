//(C) 2014 zDpxq6
package ex01_09;

import java.util.List;

//練習問題1.9 Fibonacciアプリケーションを修正して、数列を保存して、最後に値のリストを表示するようにしなさい。
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
		if(list == null){
			throw new NullPointerException();
		}
		for (E element : list) {
			System.out.println(element);
		}
	}

	/**
	 * printListメソッドは、List型のオブジェクトを引数に取り、そのオブジェクトの内容を標準出力に出力するメソッドである。
	 *
	 * @param array
	 *            List型のlistは、標準出力に出力するリストである。
	 * */
	public static <E> void printList(E[] array) {
		if(array == null){
			throw new NullPointerException();
		}
		for (E element : array) {
			System.out.println(element);
		}
	}
}
