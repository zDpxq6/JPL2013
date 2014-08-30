package walkmans;

import ex01_14.Walkman;


public class Walkman3 extends Walkman2{

	private final Microphone mic = new Microphone();

	public void communicate(){
		this.mic.comunicate();
	}

	@Override
	public String getMessage (){
		return String.format(Walkman.MESSAGE + Microphone.MESSAGE, Walkman2.JACK_NUM).toString();
	}


	public final class Microphone{
		private static final String MESSAGE = " And can communicate.";
		public final void comunicate() {
			System.out.println("communicate");
		}
	}
}
