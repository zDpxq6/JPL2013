package display;

import java.util.Calendar;

public class Watch {

	public static int getHour(){
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(){
		return Calendar.getInstance().get(Calendar.MINUTE);
	}

	public static int getSecond(){
		return Calendar.getInstance().get(Calendar.SECOND);
	}
}
