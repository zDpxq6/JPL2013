package ex02_16;
//練習問題2.6: LinkedListクラスにmainメソッドを書いて、
//Vehicle型のオブジェクトを数個作成して、
//リストの連続したノードに入れなさい。
/**
 * @author tsuguka
 * リストを抽象化したクラス
 */
public class LinkedList implements Cloneable{
	private static final String TO_STRING_ELEMENT_SEPARATOR = ", ";
	private static final String TO_STRING_ELEMENT_FINISHER = "}";
	private static final String TO_STRING_ELEMENT_STARTER = "{";
	private static final String TO_STRING_FINISHER = "]";
	private static final String TO_STRING_STARTER = "[";
	private static final String HEADDER_CONTENT = "** List Head **";
	private final Cell header;
	private int elementNumber = 0;

	/**
	 * 空のリストを作成します
	 */
	public LinkedList() {
		super();
		this.header = new Cell(HEADDER_CONTENT);
	}

	/**
	 * 指定された要素をリストの最後に追加します
	 * @param data - リストに追加される要素
	 */
	public void add(Object data) {
		getTailCell().next = new Cell(data);
		this.elementNumber++;
	}

	/**
	 * リストの最後尾の要素を取り出します。
	 * @return 最後尾の要素
	 */
	private Cell getTailCell() {
		Cell result = this.header;
		while (result.next != null) {
			result = result.next;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

	/**
	 * リスト内にある要素の数を返します。
	 * @return リスト内の要素数
	 */
	public int size(){
		return this.elementNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}


	/**
	 * @author tsuguka
	 * リストの要素を抽象化したクラス
	 */
	private final class Cell implements Cloneable {
		private Cell next;
		private final Object data;

		/**
		 * コンストラクタ
		 * @param data
		 */
		/**
		 * @param data
		 */
		private Cell(Object data) {
			this.next = null;
			this.data = data;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString(){
			return this.data.toString();
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}

}
