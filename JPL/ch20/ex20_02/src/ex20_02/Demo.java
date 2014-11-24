package ex20_02;

import java.io.IOException;


public class Demo {
	public static void main(String[] args){
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		TranslateByte tb = new TranslateByte(from, to, System.in);

		int c;
		try {
			while((c = tb.read()) != -1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
