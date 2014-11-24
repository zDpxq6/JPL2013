package ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{
	private byte seed;

	private EncryptOutputStream(OutputStream outputStream) {
		super(outputStream);
	}

	public EncryptOutputStream(OutputStream outputStream , byte seed) {
		this(outputStream);
		this.seed = seed;
	}

	@Override
	public void write(int b) throws IOException{
		int result = b^this.seed;
//		System.out.print(result);
		super.write(result);
	}

}
