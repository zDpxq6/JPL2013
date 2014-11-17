
public class Vehicle implements Cloneable{
	private static int ID = 0;
	private double nowSpeed ;
	private double nowDirection ;
	private final String ownerName ;
	private final int carID ;

	Vehicle ( double nowSpeed , double nowDirection , String ownerName ) {
		this.nowSpeed = nowSpeed ;
		this.nowDirection = nowDirection ;
		this.ownerName = ownerName ;
		this.carID = ++ Vehicle.ID;
	}

	public void printField ( ) {
		System.out.println ( "CarID: " + this.carID );
		System.out.println ( "Owner: " + this.ownerName );
		System.out.println ( "Speed: " + this.nowSpeed );
		System.out.println ( "Direction: " + this.nowDirection );
		System.out.println ( );
	}

	@Override
	public String toString ( ) {
		return String.format(	"CarID: %d%nOwner: %s%nSpeed: %.1f%nDirection: %.1f%n",
								this.carID, this.ownerName, this.nowSpeed, this.nowDirection ) ;
	}

	@Override
	public Vehicle clone() throws CloneNotSupportedException {
		super.clone();
		Vehicle result = new Vehicle( this.nowSpeed , this.nowDirection , this.ownerName);
		return result;
	}

	public void start(double nowSpeed , double nowDirection){
		this.nowSpeed = nowSpeed;
		this.nowDirection = nowDirection ;
	}

	public void stop(){
		this.nowSpeed = 0;
		this.nowDirection = 0;
	}
}
