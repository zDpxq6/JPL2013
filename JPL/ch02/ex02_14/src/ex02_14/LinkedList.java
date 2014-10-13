package ex02_14;
//練習問題2.6: LinkedListクラスにmainメソッドを書いて、
//Vehicle型のオブジェクトを数個作成して、
//リストの連続したノードに入れなさい。
public class LinkedList {
	private static final String TO_STRING_ELEMENT_SEPARATOR = ", ";
	private static final String TO_STRING_ELEMENT_FINISHER = "}";
	private static final String TO_STRING_ELEMENT_STARTER = "{";
	private static final String TO_STRING_FINISHER = "]";
	private static final String TO_STRING_STARTER = "[";
	private static final String HEADDER_CONTENT = "** List Head **";
	private final Cell header;

	public LinkedList() {
		super();
		this.header = new Cell(HEADDER_CONTENT);
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
		StringBuilder strBld = new StringBuilder(TO_STRING_STARTER);
		Cell cell = this.header;
		while (cell.next != null) {
			cell = cell.next;
			strBld.append(TO_STRING_ELEMENT_STARTER);
			strBld.append(cell.toString());
			strBld.append(TO_STRING_ELEMENT_FINISHER);
			strBld.append(TO_STRING_ELEMENT_SEPARATOR);
		}
		strBld.delete(strBld.length()-TO_STRING_ELEMENT_SEPARATOR.length(), strBld.length()-1);
		strBld.append(TO_STRING_FINISHER);
		return strBld.toString();
	}

}
