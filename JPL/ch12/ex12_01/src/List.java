import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface List extends Iterable{

		// �Q��
		public Object getNodeValue( int n) ;

		// �}��
		public void add( int n, Object value);

		//�Ō�ɑ}��
		public boolean add(Object value);

		@Override
		public Iterator iterator();


		public List clone() throws CloneNotSupportedException;

}