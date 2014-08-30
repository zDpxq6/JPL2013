package ex24_01;

import java.util.ResourceBundle;
//GlobalHelloを、例として挙げたローケルで動かしてみなさい。
//ListResourceBundle、
//.propertiesファイル、
//それにResourceBundleのサブクラスを作成して、ローケルをいくつか追加しなさい

public class GlobalHello {
	private static final String BASE_NAME = "ex24_01.GlobalRes";
	private final ResourceBundle res = ResourceBundle.getBundle(BASE_NAME);

	public void greet(String[] args) {
		String result;
		if (args.length > 0) {
			result = this.res.getString(GlobalRes.GOODBYE);
		} else {
			result = this.res.getString(GlobalRes.HELLO);
		}
		System.out.println(result);
	}

}
