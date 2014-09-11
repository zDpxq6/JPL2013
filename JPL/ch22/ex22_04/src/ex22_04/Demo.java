package ex22_04;

import java.util.Observer;

public class Demo {
	public static void main(String args[]){
		ObservableImpl publisher = new ObservableImpl();
		Observer subscriber = new ObserverImpl();
		publisher.addObserver(subscriber);
		publisher.add(new Attribute("key1","value1"));
	}
}
