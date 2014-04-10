package ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindString {
	public static void main(String[] args) throws IOException{
		String match = "import";
		FileReader fileIn = new FileReader("/Users/tsuguka/Desktop/TypeDesc.txt");
		LineNumberReader in = new LineNumberReader(fileIn);
		String readString = null;
		while((readString = in.readLine())!=null){
			if(readString.indexOf(match) != -1){
				System.out.println("\"" + match +"\" at line " + in.getLineNumber());
				continue;
			}
		}
	}
}