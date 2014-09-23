package planefactory;

import factory.Actuator;
import factory.Controller;
import factory.Vehicle;

public final class PlaneVehicle implements Vehicle {
	private static final String NAME = "plane";
	private final Controller controller;
	private final Actuator actuator;

	public PlaneVehicle(Controller controller, Actuator actuator) {
		this.controller = controller;
		this.actuator = actuator;
	}

	@Override
	public void move() {
		System.out.printf("a %s is controlled by ", NAME );
		this.controller.getController();
		System.out.printf(", and moved by %s%n", this.actuator.getActuator() );
	}

}
