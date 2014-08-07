package ex22_05;


public class Demo {
	public static void main(String args[]) {
		Dice dice1 = new SixDice();
		Dice dice2 = new SixDice();

		DiceObserver observer = new DiceObserver();

		observer.roll(10000, dice1, dice2);

		observer.showResult();

//		System.out.println(2 + "が出た回数は" + result.get(2) + "回です");
//		System.out.println(3 + "が出た回数は" + result.get(3) + "回です");
//		System.out.println(4 + "が出た回数は" + result.get(4) + "回です");
//		System.out.println(5 + "が出た回数は" + result.get(5) + "回です");
//		System.out.println(6 + "が出た回数は" + result.get(6) + "回です");
//		System.out.println(7 + "が出た回数は" + result.get(7) + "回です");
//		System.out.println(8 + "が出た回数は" + result.get(8) + "回です");
//		System.out.println(9 + "が出た回数は" + result.get(9) + "回です");
//		System.out.println(10 + "が出た回数は" + result.get(10) + "回です");
//		System.out.println(11 + "が出た回数は" + result.get(11) + "回です");
//		System.out.println(12 + "が出た回数は" + result.get(12) + "回です");

	}
}
