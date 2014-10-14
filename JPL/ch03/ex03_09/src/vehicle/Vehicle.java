package vehicle;

import vehicle.Direction.RelativeDirection;

public class Vehicle implements Cloneable {
	private static final String MESSAGE = "[ID: %d, Speed: %.1f, Direction: %s, Owner: %s]";
	private static int serialNumber = 0;
	private double speed;
	private Direction direction;
	private String owner;
	private final int ID;
	public static final Direction.RelativeDirection LEFT = Direction.RelativeDirection.LEFT;
	public static final Direction.RelativeDirection RIGHT = Direction.RelativeDirection.RIGHT;

	public Vehicle(double speed, Direction direction, String owner) {
		super();
		this.speed = speed;
		this.direction = direction;
		this.owner = owner;
		this.ID = serialNumber++;
	}

	public Vehicle(String owner) {
		this(0, null, owner);
	}

	public Vehicle() {
		this(0, null, null);
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return this.speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return this.owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void changeSpeed(double speed) {
		setSpeed(speed);
	}

	/**
	 * stop vehicle
	 */
	public void stopVehicle() {
		setSpeed(0);
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * @return the serialNumber
	 */
	public static int getSerialNumber() {
		return serialNumber - 1;
	}

	public void turn(double arg) {
		if (arg < 0 || 360 <= arg) {
			throw new IllegalArgumentException("値の範囲が不正です. 0 <= arg < 360 の範囲で入力して下さい");
		}
		if (arg <= 22.5 || 337.5 < arg) {
			setDirection(Direction.N);
		} else if (22.5 < arg && arg <= 67.5) {
			setDirection(Direction.NE);
		} else if (67.5 < arg && arg <= 112.5) {
			setDirection(Direction.E);
		} else if (112.5 < arg && arg <= 157.5) {
			setDirection(Direction.SE);
		} else if (157.5 < arg && arg <= 202.5) {
			setDirection(Direction.S);
		} else if (202.5 < arg && arg <= 247.5) {
			setDirection(Direction.SW);
		} else if (247.5 < arg && arg <= 292.5) {
			setDirection(Direction.W);
		} else if (292.5 < arg && arg <= 337.5) {
			setDirection(Direction.NW);
		} else {
			// ダメなとき
		}
	}

	public void turn(RelativeDirection relativeDirection) {
		setDirection(relativeDirection.turn(this.direction));
	}

	@Override
	public String toString() {
		return String.format(MESSAGE, this.ID, this.speed, this.direction, this.owner);
	}

	@Override
	public Object clone() {
		Object result = null;
		try{
			result = super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return result;
	}
}