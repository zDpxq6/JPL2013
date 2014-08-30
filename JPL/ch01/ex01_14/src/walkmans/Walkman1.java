package walkmans;

import ex01_14.Jack;
import ex01_14.Walkman;


public class Walkman1 implements Walkman{
	private static final int JACK_NUM = 1;
	protected Jack[] jack;

	 public Walkman1(){
		super();
		this.jack = new Jack[Walkman1.JACK_NUM];//問題
		for(int i = 0; i < JACK_NUM; i++){//問題
			this.jack[i] = new Jack();
		}
	 }

	/**
	 * @return jack
	 */
	@Override
	public final Jack[] getJack() {
		return this.jack;
	}

	@Override
	public final int setJack(boolean[] isPluged){
		if(isPluged == null){
			throw new NullPointerException();
		}
		if(isPluged.length < this.jack.length){
			throw new IllegalArgumentException();
		}
		int i;
		for(i = 0; i < this.jack.length; i++){
			this.jack[i].setPlug(isPluged[i]);
		}
		return i + 1;
	}

	@Override
	public String getMessage (){
		return String.format(Walkman.MESSAGE, Walkman1.JACK_NUM).toString();
	}

	@Override
	public String toString(){
		return getMessage();
	}
}
