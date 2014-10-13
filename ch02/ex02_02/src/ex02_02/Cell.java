package ex02_02;
//練習問題2.2: LinkedListクラスを作成しなさい。
//LinkedListクラスは、Object型のフィールドと、リストの中で次のLinkedList要素への参照を持ちます。
class Cell {
	Cell next;
	Object data;

	Cell(Object data){
		this.next = null;
		this.data = data;
	}

}
