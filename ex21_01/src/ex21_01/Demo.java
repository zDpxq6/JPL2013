package ex21_01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo {
	private static final String USERS_TSUGUKA_DESKTOP_DEMO_TXT = "/Users/tsuguka/Desktop/Demo.txt";

	public static void main(String[] args){
		boolean hasAdded;
		BufferedFilterReader dataHandler = null;
		List <String> resultList = new ArrayList <String> ();
		try {
			dataHandler = new BufferedFilterReader(new FileReader(USERS_TSUGUKA_DESKTOP_DEMO_TXT));
			String readString = null;
			while(null != (readString = dataHandler.readLine())){
				System.out.println("読み込んだ文字列: "+readString);
				int comparisonResult = -1;
				if(resultList.size() == 0){
					resultList.add(readString);
				} else {
					System.out.println("List要素数: " + resultList.size());
					ListIterator<String> ite = resultList.listIterator();
					String listElement = null;
					hasAdded = false;
					while(ite.hasNext()){
						listElement = ite.next();
						System.out.println("listの内容: "+listElement);
						comparisonResult = readString.compareTo(listElement);
						if(0 <= comparisonResult){
							ite.add(readString);
							hasAdded = true;
							break;
						}
					}
					if(hasAdded == false){
						resultList.add(0,readString);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("*****RESULT*****");
			for(String element :  resultList){
				System.out.println(element);
			}
		}
	}
}
