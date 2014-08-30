package Observer;

public abstract class Dice {
	public abstract int roll();
	public abstract int getMax();
	public abstract int getMin();

	public static int roll(Dice dice, Dice... dices) {
		int result = 0;
		if (dice != null) {
			result = dice.roll();
		}
		result += roll(dices);
		return result;
	}

	public static int roll(Dice... dices) {
		int result = 0;
		if (dices != null) {
			for (Dice dice : dices) {
				result += dice.roll();
			}
		}
		return result;
	}
}
