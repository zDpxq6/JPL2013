import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface List extends Iterable{

		// QÆ
		public Object getNodeValue( int n) ;

		// ‘}“ü
		public void add( int n, Object value);

		//ÅŒã‚É‘}“ü
		public boolean add(Object value);

		@Override
		public Iterator iterator();


		public List clone() throws CloneNotSupportedException;

}