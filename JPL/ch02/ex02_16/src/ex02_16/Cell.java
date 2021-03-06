package ex02_16;
//練習問題2.6: LinkedListクラスにmainメソッドを書いて、
//Vehicle型のオブジェクトを数個作成して、
//リストの連続したノードに入れなさい。
final class Cell implements Cloneable {
	Cell next;
	Object data;

	Cell(Object data) {
		this.next = null;
		this.data = data;
	}

	@Override
	public String toString(){
		return this.data.toString();
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
