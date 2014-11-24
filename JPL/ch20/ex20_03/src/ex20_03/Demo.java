package ex20_03;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;


public class Demo{
	public static void main(String[] args){
		byte seed = 1;
		FilterInputStream fis = new DecryptInputStream(System.in, seed);
		FilterOutputStream fos = new EncryptOutputStream(System.out, seed);
		try {
			int tmp = -1;
			while((tmp = fis.read()) != -1){
				fos.write(tmp);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}