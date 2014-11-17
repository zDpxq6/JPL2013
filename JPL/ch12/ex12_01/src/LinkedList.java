import java.util.Iterator;

@SuppressWarnings("rawtypes")
//反復処理というのは、ある集合を表現するデータに対して、同じ処理を適用したいときによく利用する処理です。
//反復処理の1つにfor文があり、for文には基本for文と拡張for文があります。
//拡張for文は、ある決まりきった基本for文の短縮形を提供するための単純な構文です。
//拡張for文の文法は
//for (型 繰り返し用変数名 : 集合式) { 文 }
//です。
//ここで指定する「集合式」には、反復処理の対象とする「値の集合」を定義したオブジェクトを表す式を指定します。
//またその式の評価結果は、
//	「配列のインスタンス」
//	「java.lang.Iterable(以下Iterable)インターフェイスを実装したオブジェクト」
//のどちらかになる必要があります。
//
// Iterableインターフェイスは唯一iterator()だけを宣言しています。
// iterator()は戻り値として反復子であるIteratorオブジェクトを返します。
// 反復子であるIteratorオブジェクトは、拡張for文で反復処理を行う際に利用されます。
// したがって Iterableインターフェイスを実装しているクラスは拡張for文が利用できます。
//
// さて、iterator()の戻り値となるIteratorオブジェクトは、当然Iteratorクラスのメソッドを実装している必要があります。
// これは、見かけ上イテレータを使っていないように見える拡張for文も、内部的にはイテレータを駆使して処理が行われているためです。
// 内部的にイテレータを利用しているため、Iterableインターフェイスのiterator()の戻り値となるIteratorオブジェクト
// がきちんとIteratorインターフェイスのメソッドを実装していないと、反復処理を行うことができません。

public class LinkedList implements Iterable ,Cloneable, List{
	// リストのノード
	static private class Node {
		Object value;
		Node nextNode;

		// コンストラクタ
		Node( Object value, Node nextNode) {
			this.value = value;
			this.nextNode = nextNode;
		}
	}
	// フィールド変数
	private final Node topNode;
	private int size;

	// コンストラクタ
	public LinkedList( ) {
		this.topNode = new Node(null, null); // トップノード
		this.size = 0;
	}

	// n 番目のセルを求める
	private Node getNode( int n) {
		int i = -1;
		Node result = this.topNode;
		while (result != null) {
			if (n == i) {
				return result;
			}
			i++;
			result = result.nextNode;
		}
		throw new ListIndexOutOfBoundsException("LinkedList");
	}

	// 参照
	@Override
	public Object getNodeValue( int n) {
		Node result = getNode(n);
		return result.value;
	}

	// 挿入
	@Override
	public void add( int n, Object value) {
		Node previousNode = getNode(n - 1);
		Node addingNode = new Node(value, previousNode.nextNode);
		previousNode.nextNode = addingNode;
		this.size++;
	}

	//最後に挿入
	@Override
	public boolean add(Object value){
		this.add(this.size, value);
		return true ;
	}

	@Override
	public LinkedList clone() throws CloneNotSupportedException {
		super.clone();
		LinkedList result = new LinkedList() ;

		for( Object element : this ){
			result.add(((Vehicle)element).clone());
		}
		return result;
	}

	//イテレータ
	@Override
	public Iterator iterator(){
		//無名クラス
		return new Iterator()
		{
			Node currentNode = LinkedList.this.topNode.nextNode;

			@Override
			public boolean hasNext()	{
				return this.currentNode != null;
			}

			@Override
			public Object next(){
				Object result = this.currentNode.value;
				this.currentNode = this.currentNode.nextNode;
				return result;
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
}


//例外クラス
@SuppressWarnings("serial")
class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {
	public ListIndexOutOfBoundsException( ) {
	}

	public ListIndexOutOfBoundsException( String msg) {
		super(msg);
	}
}