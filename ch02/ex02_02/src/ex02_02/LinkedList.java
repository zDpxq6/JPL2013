package ex02_02;

//練習問題2.2: LinkedListクラスを作成しなさい。
//LinkedListクラスは、Object型のフィールドと、リストの中で次のLinkedList要素への参照を持ちます。
public class LinkedList {
	private final Cell header;

	public LinkedList() {
		super();
		this.header = new Cell("** List Head **");
	}

	public void add(Object data) {
		getTailCell().next = new Cell(data);

	}

	private Cell getTailCell(){
		Cell result = this.header;
		while (result.next != null) {
			result = result.next;
		}
		return result;
	}

}
