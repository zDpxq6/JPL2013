package ex21_01;


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
			StringBuilder stringBuilder = new StringBuilder();
			while((readChar = this.read()) != -1 && readChar != '\n' && readChar != '\r'){
				stringBuilder.append((char)readChar);
			}
			String result;
			if((result = stringBuilder.toString()).length() == 0){
				result = null;
			}
			return result;
		}
	}

}