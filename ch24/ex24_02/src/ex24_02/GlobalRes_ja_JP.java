package ex24_02;

import java.util.ListResourceBundle;

public class GlobalRes_ja_JP extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return contents;
	}

	private static final Object[][] contents = { { GlobalRes.HELLO, "こんにちは" }, { GlobalRes.GOODBYE, "さようなら" }, };

}
