package ex22_01;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{
	private final String name;

	public Client(String name){
		this.name = name;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(this.name + ": " + arg1);
	}

	public String getName() {
		return this.name;
	}

}
