package ex21_07;

import java.util.ArrayList;
import java.util.List;

public class Stack<E>{
	//ArrayListクラスで定義されているpublicメソッドを使用させたくないため委譲を用いた
	private final List<E> list = new ArrayList<E>();

	public Stack(){
		super();
	}

	public int push(E e){
		synchronized(this){
			this.list.add(e);
			return this.list.size();
		}
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		synchronized(this){
			int listSize = this.list.size();
			if(listSize == 0){
				throw new RuntimeException("要素がありません");
			} else {
				Object result = this.list.get(listSize - 1);
				this.list.remove(listSize - 1);
				return (E) result;
			}
		}
	}

	public int size(){
		synchronized(this){
			return this.list.size();
		}
	}

}
