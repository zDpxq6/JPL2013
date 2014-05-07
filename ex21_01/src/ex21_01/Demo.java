package ex21_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo {
	public static void main(String[] args){
		File file = new File("/Users/tsuguka/Desktop/Demo.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String readString = null;
		List<String> mySortedList = new ArrayList<String>();
		try {
			while((readString = bufferedReader.readLine())!=null){
				System.out.println(readString);
				ListIterator<String> ite = mySortedList.listIterator();
				if(mySortedList.isEmpty()){
					mySortedList.add(readString);
				} else {
					while(ite.hasNext()){
						String str =ite.next();
						if(readString.compareTo(str)>0){
							ite.add(str);
							break;
						} else {
							continue;
						}
					}
					ite.add(readString);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(fileReader != null){
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("***出力***");
		System.out.println(mySortedList.isEmpty());
		for(String ele : mySortedList){
			System.out.println(ele);
		}
	}
}
