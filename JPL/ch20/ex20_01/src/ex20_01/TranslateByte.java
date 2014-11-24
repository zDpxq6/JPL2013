package ex20_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static OutputStream translateByte(byte from, byte to, InputStream input, OutputStream output) throws IOException{
		if(input == null || output == null){
			throw new IOException();
		}
		int read;
		try{
			while ((read = input.read()) != -1){
				if(read == from){
					read = to;
				}
				output.write(read);
			}
		} catch(IOException e){
			throw e;
		} finally{
			if(input != null){
				input.close();
			}
			if(input != null){
				output.close();
			}
		}
		return output;
	}
}
