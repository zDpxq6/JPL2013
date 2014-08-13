package ex24_02;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Demo {
	private static final String DATE = "2014/05/28";

	public static void main(String[] args) {
//		Demo.execute(DateFormat.AM_PM_FIELD);
		Demo.execute(DateFormat.DATE_FIELD);
//		Demo.execute(DateFormat.DAY_OF_WEEK_FIELD);
//		Demo.execute(DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD);
		Demo.execute(DateFormat.YEAR_FIELD);
		Demo.execute(DateFormat.DEFAULT );
//		Demo.execute(DateFormat.ERA_FIELD);
//		Demo.execute(DateFormat.FULL);
//		Demo.execute(DateFormat.DateFormat.HOUR_OF_DAY0_FIELD);
//		Demo.execute(DateFormat.HOUR_OF_DAY1_FIELD);
//		Demo.execute(DateFormat.DateFormat.HOUR0_FIELD);
//		Demo.execute(DateFormat.HOUR1_FIELD);
		Demo.execute(DateFormat.LONG);
		Demo.execute(DateFormat.MEDIUM);
//		Demo.execute(DateFormat.MILLISECOND_FIELD);
//		Demo.execute(DateFormat.MINUTE_FIE);
		Demo.execute(DateFormat.MONTH_FIELD);
//		Demo.execute(DateFormat.ECOND_FDemo.execute(SHORT);
//		Demo.execute(DateFormat.TIMEZONE_FIELD);
//		Demo.execute(DateFormat.WEEK_OF_MONTH_FIELD);
//		Demo.execute(DateFormat.WEEK_OF_MONTH);
//		Demo.execute(DateFormat.WEEK_OF_YEAR_FIELD);
//		Demo.execute(DateFormat.WEEK_OF_YEAR);
	}

	private static void execute(int dateFormat){
		DateFormat df = DateFormat.getDateInstance(dateFormat);
		Date date = null;
		try {
			date = df.parse(DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(df.format(date));
	}

}
