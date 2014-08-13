package ex24_01;

import java.util.Locale;

public class Demo {

	public static void main(String[] args) {
		//日本語
		GlobalHello gh = new GlobalHello();
		gh.greet(args);

		//英語
		Locale.setDefault(Locale.ENGLISH);
		gh = new GlobalHello();
		gh.greet(args);

		//オーストラリア英語
		Locale.setDefault(new Locale("en","AU"));
		gh = new GlobalHello();
		gh.greet(args);

		//ヒンディー語
		Locale.setDefault(new Locale("hi"));
		gh = new GlobalHello();
		gh.greet(args);

		//トルコ語
		Locale.setDefault(new Locale("tr"));
		gh = new GlobalHello();
		gh.greet(args);
	}

}
