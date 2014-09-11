package ex22_04;

import java.util.Observable;
import java.util.Observer;


//監視する方
public class ObserverImpl implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("o:"+o);
		System.out.println("obje:"+arg);
		System.out.println("updated!!");
	}

}
