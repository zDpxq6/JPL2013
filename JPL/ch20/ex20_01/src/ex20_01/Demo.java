package ex20_01;

import java.io.IOException;

public class Demo {
	public static void main(String[] args){
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		try {
			TranslateByte.translateByte(from,to,System.in, System.out);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
