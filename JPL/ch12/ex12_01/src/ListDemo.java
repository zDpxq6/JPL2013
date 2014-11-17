import java.util.Iterator;

public class ListDemo {
	static void printCollection (@SuppressWarnings("rawtypes") Iterator iter) {
		while(iter.hasNext()){
			((Vehicle) iter.next()).printField();
		}
		System.out.println();
	}

	public static void main(String[] args){
		List demoList = new LinkedList();

		demoList.add( new Vehicle (	10, 20, "Taro" ) );
		demoList.add( new Vehicle (	30, 40, "Jiro" ) );
		demoList.add( new Vehicle (	50, 60, "Sabro") );

		try {
			System.out.println("元のコレクション");
			printCollection(demoList.iterator());
			System.out.println("コピーしたコレクション");
			List copiedList = demoList.clone();
			printCollection(copiedList.iterator());
			System.out.println("元のコレクションを停止");

			for(Object element : demoList){
				((Vehicle)element).stop();
			}

			System.out.println("元のコレクション");
			printCollection(demoList.iterator());
			System.out.println("コピーしたコレクション");
			printCollection(copiedList.iterator());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	 }
 }
