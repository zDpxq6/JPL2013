package diceImpl;

import java.util.Random;

import Observer.Dice;

public class SixDice extends Dice {
	private static final Random RANDOM = new Random();
	private final int VALUE_WIDTH = 6;
	private final int MIN_VALUE = 1;
	@Override
	public int roll(){
		return RANDOM.nextInt(this.VALUE_WIDTH) + this.MIN_VALUE;
	}
	@Override
	public int getMax() {
		return this.VALUE_WIDTH;
	}
	@Override
	public int getMin() {
		// TODO Auto-generated method stub
		return this.MIN_VALUE;
	};
}
