package days;

import static days.Days.Saturday;
import static days.Days.Sunday;

public class IfElseDayDecider implements DayDecider {

	@Override
	public boolean isWeekDay(Days day) {
		//dayがSaturdayかSundayでfalseになる
		return (Saturday.equals(day) || Sunday.equals(day)) == false;
	}

}
