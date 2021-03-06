import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface List extends Iterable{

		// 参照
		public Object getNodeValue( int n) ;

		// 挿入
		public void add( int n, Object value);

		//最後に挿入
		public boolean add(Object value);

		@Override
		public Iterator iterator();


		public List clone() throws CloneNotSupportedException;

}