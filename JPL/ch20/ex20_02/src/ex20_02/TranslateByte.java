package ex20_02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte extends FilterInputStream{
	private byte from;
	private byte to;


	private TranslateByte(InputStream in) {
		super(in);
	}

	public TranslateByte(byte from, byte to, InputStream in) {
		this(in);
		this.from = from;
		this.to = to;
	}

	@Override
	public int read() throws IOException{
		int result = super.read();
		if( result != -1){
			if(result == this.from){
				result = this.to;
			}
		}
		return result;
	}
}
