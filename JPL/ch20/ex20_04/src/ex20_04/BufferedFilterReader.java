package ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedFilterReader extends FilterReader{

	protected BufferedFilterReader(Reader reader) {
		super(reader);
	}

	public String readLine() throws IOException{
		synchronized(this.lock){
			int readChar = -1;
			StringBuilder result = new StringBuilder();
			while((readChar = this.read()) != -1 && readChar != '\n' && readChar != '\r'){
				result.append(readChar);
			}
			return result.toString();
		}
	}

}
