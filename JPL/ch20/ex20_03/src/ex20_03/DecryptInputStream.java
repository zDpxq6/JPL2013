package ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream{

	private byte seed;

	private DecryptInputStream(InputStream inputStream) {
		super(inputStream);
	}

	public DecryptInputStream(InputStream inputStream, byte seed) {
		this(inputStream);
		this.seed = seed;
	}

	@Override
	public int read() throws IOException{
		int result = super.read();
		if(result != -1){
			result = result^this.seed;
		}
		System.out.print(result+"\n");
		return result;
	}

}
