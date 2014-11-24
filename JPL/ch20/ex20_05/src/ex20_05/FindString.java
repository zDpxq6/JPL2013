package ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindString {
	public static void main(String[] args) throws IOException{
		FileReader fileIn = new FileReader(args[0]);
		String match = args[1];
		@SuppressWarnings("resource")
		LineNumberReader in = new LineNumberReader(fileIn);
		String readString = null;
		while((readString = in.readLine())!=null){
			if(readString.indexOf(match) != -1){
				System.out.println(in.getLineNumber() + ": " + readString);
			}
		}
	}
}