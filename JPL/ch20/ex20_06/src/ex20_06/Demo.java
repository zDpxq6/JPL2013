package ex20_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException{
		FileReader fileIn = new FileReader(args[0]);
		String match = args[1];
		@SuppressWarnings("resource")
		LineNumberReader in = new LineNumberReader(fileIn);
		String readString = null;
		try {
			while((readString = in.readLine())!=null){
				if(readString.indexOf(match) != -1){
					System.out.println(in.getLineNumber() + ": " + readString);
				}
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
