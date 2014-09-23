package planefactory;

import factory.Controller;

public class StickController implements Controller{
	private static final String NAME = "a control stick";

	@Override
	public void getController() {
		System.out.print(NAME);
	}
}
