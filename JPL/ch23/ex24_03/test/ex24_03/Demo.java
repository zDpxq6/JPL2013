package ex24_03;

import java.util.Currency;
import java.util.Locale;

public class Demo {

	public static void main(String[] args) {
		Demo.getCurrency(Locale.US);
		Demo.getCurrency(Locale.CHINA);
		Demo.getCurrency(Locale.JAPAN);
		Demo.getCurrency(Locale.GERMANY);
		Demo.getCurrency(Locale.FRANCE);
		Demo.getCurrency(Locale.UK);
	}

	private static Currency getCurrency(Locale locale){
		Locale.setDefault(locale);
		Currency result = Currency.getInstance(Locale.getDefault());
		System.out.println(result.getSymbol());
		return result;
	}

}
