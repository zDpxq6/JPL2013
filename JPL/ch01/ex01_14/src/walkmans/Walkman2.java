package walkmans;

import ex01_14.Jack;
import ex01_14.Walkman;


public class Walkman2 extends Walkman1 {
	public static final int JACK_NUM = 2;

	 public Walkman2(){
		//super()呼ばないことできる?
		super();
		this.jack = new Jack[Walkman2.JACK_NUM];
		for(int i = 0; i < Walkman2.JACK_NUM; i++){
			this.jack[i] = new Jack();
		}
	 }

	@Override
	public String getMessage (){
		return String.format(Walkman.MESSAGE, Walkman2.JACK_NUM).toString();
	}

}
