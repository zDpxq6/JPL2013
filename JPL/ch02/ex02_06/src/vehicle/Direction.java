package vehicle;

public enum Direction {
	N("North"),	NE("NorthEast"),
	E("East"),	SE("SouthEast"),
	S("South"),	SW("SouthWest"),
	W("West"),	NW("NorthWest"),;

	private final String displayName;

	private Direction(String name){
		this.displayName = name;
	}

	@Override
	public String toString(){
		return this.displayName;
	}
}
