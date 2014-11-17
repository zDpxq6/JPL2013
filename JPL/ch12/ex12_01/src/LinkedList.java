import java.util.Iterator;

@SuppressWarnings("rawtypes")
//���������Ƃ����̂́A����W����\������f�[�^�ɑ΂��āA����������K�p�������Ƃ��ɂ悭���p���鏈���ł��B
//����������1��for��������Afor���ɂ͊�{for���Ɗg��for��������܂��B
//�g��for���́A���錈�܂肫������{for���̒Z�k�`��񋟂��邽�߂̒P���ȍ\���ł��B
//�g��for���̕��@��
//for (�^ �J��Ԃ��p�ϐ��� : �W����) { �� }
//�ł��B
//�����Ŏw�肷��u�W�����v�ɂ́A���������̑ΏۂƂ���u�l�̏W���v���`�����I�u�W�F�N�g��\�������w�肵�܂��B
//�܂����̎��̕]�����ʂ́A
//	�u�z��̃C���X�^���X�v
//	�ujava.lang.Iterable(�ȉ�Iterable)�C���^�[�t�F�C�X�����������I�u�W�F�N�g�v
//�̂ǂ��炩�ɂȂ�K�v������܂��B
//
// Iterable�C���^�[�t�F�C�X�͗B��iterator()������錾���Ă��܂��B
// iterator()�͖߂�l�Ƃ��Ĕ����q�ł���Iterator�I�u�W�F�N�g��Ԃ��܂��B
// �����q�ł���Iterator�I�u�W�F�N�g�́A�g��for���Ŕ����������s���ۂɗ��p����܂��B
// ���������� Iterable�C���^�[�t�F�C�X���������Ă���N���X�͊g��for�������p�ł��܂��B
//
// ���āAiterator()�̖߂�l�ƂȂ�Iterator�I�u�W�F�N�g�́A���RIterator�N���X�̃��\�b�h���������Ă���K�v������܂��B
// ����́A��������C�e���[�^���g���Ă��Ȃ��悤�Ɍ�����g��for�����A�����I�ɂ̓C�e���[�^����g���ď������s���Ă��邽�߂ł��B
// �����I�ɃC�e���[�^�𗘗p���Ă��邽�߁AIterable�C���^�[�t�F�C�X��iterator()�̖߂�l�ƂȂ�Iterator�I�u�W�F�N�g
// ���������Iterator�C���^�[�t�F�C�X�̃��\�b�h���������Ă��Ȃ��ƁA�����������s�����Ƃ��ł��܂���B

public class LinkedList implements Iterable ,Cloneable, List{
	// ���X�g�̃m�[�h
	static private class Node {
		Object value;
		Node nextNode;

		// �R���X�g���N�^
		Node( Object value, Node nextNode) {
			this.value = value;
			this.nextNode = nextNode;
		}
	}
	// �t�B�[���h�ϐ�
	private final Node topNode;
	private int size;

	// �R���X�g���N�^
	public LinkedList( ) {
		this.topNode = new Node(null, null); // �g�b�v�m�[�h
		this.size = 0;
	}

	// n �Ԗڂ̃Z�������߂�
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

	// �Q��
	@Override
	public Object getNodeValue( int n) {
		Node result = getNode(n);
		return result.value;
	}

	// �}��
	@Override
	public void add( int n, Object value) {
		Node previousNode = getNode(n - 1);
		Node addingNode = new Node(value, previousNode.nextNode);
		previousNode.nextNode = addingNode;
		this.size++;
	}

	//�Ō�ɑ}��
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

	//�C�e���[�^
	@Override
	public Iterator iterator(){
		//�����N���X
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


//��O�N���X
@SuppressWarnings("serial")
class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {
	public ListIndexOutOfBoundsException( ) {
	}

	public ListIndexOutOfBoundsException( String msg) {
		super(msg);
	}
}