package ex22_05;

import java.util.Random;

public class SixDice implements Dice {
	private static final Random RANDOM = new Random();
	private final int VALUE_WIDTH = 6;
	private final int MIN_VALUE = 1;
	@Override
	public int roll(){
		return RANDOM.nextInt(this.VALUE_WIDTH) + this.MIN_VALUE;
	};
}
