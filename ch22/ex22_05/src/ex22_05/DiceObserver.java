package ex22_05;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DiceObserver {
	private final Map<Integer, Integer>result = new HashMap<Integer, Integer>();
	private boolean isRolled;
	private static final String LEIGAL_STATE_MESSAGE = "result:";
	private static final String ILLIGAL_STATE_MESSAGE = "haven't observed yet";
	private static final String RESULT_FORMAT = "%2d - %5d%n";

	public Map<Integer, Integer> roll(int times, Dice dice, Dice... dices) {
		int total;
		Integer count;
		for (int i = 0; i < times; i++) {
			total = total(dice, dices);
			count = this.result.get(total);
			count = null == this.result.get(total) ? 0 : count;
			this.result.put(total,count + 1);
//			count =  count == null ? 1 :count++;
//			result.put(total,count);
		}
		this.isRolled=true;
		return this.result;
	}

	private static int total(Dice dice, Dice... dices) {
		int result = 0;
		if(dice != null){
			result = dice.roll();
		}
		result += roll(dices);
		return result;
	}

	private static int roll(Dice...dices){
		int result = 0;
		if(dices != null){
			for (Dice e : dices) {
				result += e.roll();
			}
		}
		return result;
	}

	public void showResult(){
		if(this.isRolled == false){
			System.out.println(ILLIGAL_STATE_MESSAGE);
		}else{
			System.out.println(LEIGAL_STATE_MESSAGE);
			Map<Integer,Integer> result = new TreeMap<Integer,Integer>();
			result.putAll(this.result);
			for(Map.Entry<Integer,Integer> e : result.entrySet()){
				System.out.printf(RESULT_FORMAT,e.getKey(),e.getValue());
			}
		}
	}
}
