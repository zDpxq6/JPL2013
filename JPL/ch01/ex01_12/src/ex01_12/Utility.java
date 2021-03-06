//(C) 2014 zDpxq6
package ex01_12;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//練習問題1.3 Fibonacciプログラムの出力リストにタイトルを追加しなさい
/**
 * @auther zDpxq6
 * */
public class Utility {
	private static final String SEPARATOR = ": ";

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

	public static <E> void printList(E[] array) {
		for (E element : array) {
			System.out.println(element);
		}
	}

	public static <E> void printListWithIndex(List<E> list) {
		Iterator<E> ite = list.iterator();
		for (int counter = list.size(); 0 < counter; counter--) {
			E element = ite.next();
			System.out.print(counter + SEPARATOR);
			System.out.println(element);
		}
	}

//	public static <E> List<Object> analyzeList(List<E> list, Filter<E> filter) {
//		List<E> copyList = copyList(list);
//		Iterator<E> ite = copyList.iterator();
//		List<Object> resultList = new LinkedList<Object>();
//		while (ite.hasNext()) {
//			E element = ite.next();
//			resultList.add(filter.modify(element));
//		}
//		return resultList;
//	}

	public static <E> Object[] analyzeList(List<E> list, Filter<E> filter) {
		List<E> copyList = copyList(list);
		Iterator<E> ite = copyList.iterator();
		List<Object> resultList = new LinkedList<Object>();
		while (ite.hasNext()) {
			E element = ite.next();
			resultList.add(filter.modify(element));
		}

		return resultList.toArray();
	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> copyList(List<E> list){
		List<Object> result = new LinkedList<Object>();
		Iterator<E> ite  = list.iterator();
		while(ite.hasNext()){
			E element = ite.next();
			result.add(element);
		}
		return (List<E>) result;
	}

}
