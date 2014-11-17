package days;

public class Demo {

	public static void main(String[] args) {
		DayDecider dd = new IfElseDayDecider();
		judge(dd);
		dd = new SwitchDayDecider();
		judge(dd);

	}

	private static void judge(DayDecider dd) {
		print(Days.Monday, dd);
		print(Days.Tuesday, dd);
		print(Days.Wednesday, dd);
		print(Days.Thursday, dd);
		print(Days.Friday, dd);
		print(Days.Saturday, dd);
		print(Days.Sunday, dd);
	}

	private static void print(Days day, DayDecider dd) {
		System.out.println(day.toString() + ": " + dd.isWeekDay(day));
	}

}
