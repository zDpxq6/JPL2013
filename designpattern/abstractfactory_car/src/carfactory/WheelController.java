package carfactory;

import factory.Controller;

public class WheelController implements Controller{
	private static final String NAME = "a steering wheel";

	@Override
	public void getController() {
		System.out.print(NAME);
	}
}
