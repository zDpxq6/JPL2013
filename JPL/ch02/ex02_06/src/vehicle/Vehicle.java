package vehicle;


//練習問題2.5:
//Vehicleクラスにmainメソッドを書いて、数個の乗り物を作成し、それらのオブジェクトのフィールド値を表示するようにしなさい。
public class Vehicle {
	private static final String MESSAGE = "Properties[ID: %d, Speed: %.1f, Direction: %s, Owner: %s]";
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

	@Override
	public String toString(){
		return String.format(MESSAGE, this.ID, this.speed, this.direction, this.owner);
	}
}
