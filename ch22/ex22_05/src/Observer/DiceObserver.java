package Observer;

import java.util.ArrayList;
import java.util.List;

public class DiceObserver {
	private final List<Integer> result;

	private boolean isRolled;
	private static final String LEIGAL_STATE_MESSAGE = "result:";
	private static final String ILLIGAL_STATE_MESSAGE = "haven't observed yet";
	private static final String RESULT_FORMAT = "%2d - %5d%n";

	private final Dice dice;
	private final Dice[] dices;
	private int max;

	private int min;

	public DiceObserver(Dice dice, Dice... dices) {
		this.dice = dice;
		this.dices = dices;
		getMax();
		getMin();
		this.result = new ArrayList<Integer>(this.max);
		for(int i = 0; i <= this.max; i++){
			this.result.add(i, 0);
		}
	}

	private final void getMax(){
		this.max = this.dice.getMax();
		if (this.dices != null) {
			for (Dice d : this.dices) {
				this.max += d.getMax();
			}
		}
	}

	private final void getMin(){
		this.min = this.dice.getMin();
		if (this.dices != null) {
			for (Dice d : this.dices) {
				this.min += d.getMin();
			}
		}
	}

	public List<Integer> roll(int times) {
		int total;
		int counter;
		for (int i = 0; i < times; i++) {
			total = Dice.roll(this.dice, this.dices);
			counter = this.result.get(total);
			this.result.set(total, counter + 1);
		}

		this.isRolled = true;

		return this.result;
	}

	public void showResult() {
		if (this.isRolled == false) {
			System.out.println(ILLIGAL_STATE_MESSAGE);
		} else {
			System.out.println(LEIGAL_STATE_MESSAGE);
			for (int i = this.min; i <= this.max; i++) {
				System.out.printf(RESULT_FORMAT, i, this.result.get(i));
			}
		}
	}
}
