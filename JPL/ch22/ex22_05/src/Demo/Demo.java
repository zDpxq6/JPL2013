package Demo;

import Observer.Dice;
import Observer.Ideal;
import diceImpl.SixDice;


public class Demo {
	public static void main(String args[]) {
		Dice dice1 = new SixDice();
		Dice dice2 = new SixDice();

		Ideal observer = new Ideal(dice1,dice2);

		observer.roll(1000);

		observer.showResult();

	}
}
