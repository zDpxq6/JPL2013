package days;


public class SwitchDayDecider implements DayDecider {

	@Override
	public boolean isWeekDay(Days day) {
		// dayがSaturdayかSundayでfalseになる
		switch (day) {
		case Sunday:
			return false;
		case Saturday:
			return false;
		default:
			return true;
		}

	}

}
