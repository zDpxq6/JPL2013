package ex24_03;

import java.util.ListResourceBundle;

public class GlobalRes_tr extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return contents;
	}

	private static final Object[][] contents = { { GlobalRes.HELLO, "Merhaba" }, { GlobalRes.GOODBYE, "Görüşürüz" }, };


}
