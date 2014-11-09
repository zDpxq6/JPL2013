public class Vehicle {
	private static int ID = 0;
	enum Direction {
		LEFT,
		RIGHT,
	}
//	public static final double TURN_LEFT = 90 ;
//	public static final double TURN_RIGHT = -90 ;

	private double nowSpeed = 0;
	private double nowDirection = 0;
	private String ownerName = null ;
	private int carID = 0 ;

	Vehicle ( ) {
		this( 0, 0, null ) ;
	}

	Vehicle ( double nowSpeed , double nowDirection , String ownerName ) {
		this.nowSpeed = nowSpeed ;
		this.nowDirection = nowDirection ;
		this.ownerName = ownerName ;
		this.carID = ++ Vehicle.ID ;
	}

	Vehicle ( String ownerName ) {
		this( 0, 0, ownerName ) ;
	}

	public static int getID(){
		return ID ;
	}

	public void printField ( ) {
		System.out.println ( "CarID: " + this.carID );
		System.out.println ( "Owner: " + this.ownerName );
		System.out.println ( "Speed: " + this.nowSpeed );
		System.out.println ( "Direction: " + this.nowDirection );
		System.out.println ( );
	}

	public void setSpeed( double speed){
		this.nowSpeed = speed ;
	}

	public void changeSpeed ( double newSpeed) {
		this.setSpeed( newSpeed );
	}

	public void stop ( ) {
		this.setSpeed( 0 );
	}

	public void setDirection ( double direction ){
		this.nowDirection = direction ;
	}

	public double getDirection ( ) {
		return this.nowDirection;
	}

	public void setOwnerName (String ownerName){
		this.ownerName = ownerName ;
	}

	public void turn ( Direction turnAngle ) {
		if(turnAngle == Direction.LEFT) {
			this.setDirection( this.getDirection() + 90 );
		} else {
			this.setDirection( this.getDirection() - 90 );
		}
	}

	@Override
	public String toString ( ) {
		return String.format(	"CarID: %d%nOwner: %s%nSpeed: %.1f%nDirection: %.1f%n",
								this.carID, this.ownerName, this.nowSpeed, this.nowDirection ) ;
	}

	public static void main(String[] args) {
		Vehicle vehicle01 = new Vehicle ( 0 , 0 , "Taro" ) ;

		System.out.println("vehicle01: ");
		vehicle01.printField();
		//System.out.println("vehicle01: ");
		vehicle01.setSpeed(100);
		System.out.println("satrt");
		System.out.println("vehicle01: ");
		vehicle01.printField();
		vehicle01.turn(Direction.RIGHT);
		System.out.println("Turn Right");
		System.out.println("vehicle01: ");
		vehicle01.printField();
	}
}
