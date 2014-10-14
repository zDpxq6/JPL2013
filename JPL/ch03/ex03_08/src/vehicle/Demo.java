package vehicle;

public class Demo {
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("Aran");
		System.out.println(v1);

		PassengerVehicle v2 = new PassengerVehicle(0, Direction.E, "Jhon", 4, 1);
		System.out.println(v2);
		System.out.println(v2.getSeat());
	}
}