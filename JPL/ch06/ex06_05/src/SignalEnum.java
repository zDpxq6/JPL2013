enum SignalEnum {
	GREEN("GREEN"),
	YELLOW("YELLOW"),
	RED("RED");

	String name;

	SignalEnum(String name) {
		this.name = name;
	}

	SignalEnum getColor(){
		return valueOf(this.name);
	}

}

