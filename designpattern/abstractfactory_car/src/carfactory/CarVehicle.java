package carfactory;

import factory.Actuator;
import factory.Controller;
import factory.Vehicle;

public final class CarVehicle implements Vehicle {
	private static final String NAME = "car";
	private final Controller controller;
	private final Actuator actuator;

	public CarVehicle(Controller controller, Actuator actuator) {
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
