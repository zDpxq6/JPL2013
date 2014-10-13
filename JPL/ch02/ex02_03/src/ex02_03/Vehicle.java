package ex02_03;


//練習問題2.3:
//次の乗り物のし区別番号を保持するstaticフィールドと、
//車単位でID番号を保持するための非staticフィールドをVehicleクラスに追加しなさい
public class Vehicle {
	private static int serialNumber = 0;
	private final double speed;
	private final Direction direction;
	private final String owner;
	private final int ID;

	public Vehicle(double speed, Direction direction, String owner) {
		super();
		this.speed = speed;
		this.direction = direction;
		this.owner = owner;
		this.ID = serialNumber++;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return this.speed;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return this.owner;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return this.ID;
	}
}
