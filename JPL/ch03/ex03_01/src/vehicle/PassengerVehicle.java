package vehicle;


public class PassengerVehicle extends Vehicle {
	private static final String MESSAGE = "[ID: %d, Speed: %.1f, Direction: %s, Owner: %s, Seat(s) %d, Seated person %d]";
	private final int seat;
	private final int seated;

	public PassengerVehicle(double speed, Direction direction, String owner, int seat, int seated){
		super(speed, direction, owner);
		this.seat = seat;
		this.seated = seated;
	}

	public PassengerVehicle(String owner) {
		this(0, null, owner,0,0);
	}

	public PassengerVehicle() {
		this(0, null, null,0,0);
	}

	/**
	 * @return the seat
	 */
	public int getSeat() {
		return this.seat;
	}

	/**
	 * @return the seated
	 */
	public int getSeated() {
		return this.seated;
	}

	@Override
	public String toString() {
		return String.format(MESSAGE, getID(), getSpeed(), getDirection(), getOwner(), this.seat, this.seated);
	}
}
