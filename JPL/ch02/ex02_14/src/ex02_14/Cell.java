package ex02_14;
//練習問題2.6: LinkedListクラスにmainメソッドを書いて、
//Vehicle型のオブジェクトを数個作成して、
//リストの連続したノードに入れなさい。
class Cell {
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

}
