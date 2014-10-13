package ex02_01;

//練習問題2.1:
//少なくとも
//	現在のスピード、
//	現在の方向(角度)、
//	所有者の名前
//を保持するフィールドを持つ簡単なVehicleクラスを書きなさい。
public class Vehicle {
	private static int serialNumber = 0;
	private double speed;
	private Direction direction;
	private String owner;
	private final int ID;

	public Vehicle() {
		this.ID = getSerialNumber();
	}

	public Vehicle(double speed, Direction direction, String owner, int iD) {
		super();
		this.speed = speed;
		this.direction = direction;
		this.owner = owner;
		this.ID = iD;
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

	private static int getSerialNumber() {
		return serialNumber++;
	}
}
