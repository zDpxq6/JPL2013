package ex02_06;
//練習問題2.6: LinkedListクラスにmainメソッドを書いて、
//Vehicle型のオブジェクトを数個作成して、
//リストの連続したノードに入れなさい。
public class LinkedList {
	private final Cell header;

	public LinkedList() {
		super();
		this.header = new Cell("** List Head **");
	}

	public void add(Object data) {
		getTailCell().next = new Cell(data);

	}

	private Cell getTailCell() {
		Cell result = this.header;
		while (result.next != null) {
			result = result.next;
		}
		return result;
	}

	@Override
	public String toString(){
		StringBuilder strBld = new StringBuilder("[");
		Cell cell = this.header;
		while (cell.next != null) {
			cell = cell.next;
			strBld.append("{" + cell.toString() + "}, ");
		}
		strBld.delete(strBld.length()-2, strBld.length()-1);
		strBld.append("]");
		return strBld.toString();
	}

}
