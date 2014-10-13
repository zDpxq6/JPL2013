package mask;

public class Y extends X {
	{
		System.out.println("Y, 初期化子前:\t" + this.yMask);
	}

	protected int yMask = 0xff00;
	{
		System.out.println("Y, 初期化子後:\t" +this.yMask);
	}

	public Y() {
		this.fullMask |= this.yMask;
		System.out.println("Y, Const.後:\t" + this.yMask);
	}

	@Override
	void printMasks(String message) {
		System.out.printf(message + "%n" + "xMask:\t\t%04x%n" + "yMaks:\t\t%04x%n" + "fullMask:\t%04x%n%n", this.xMask, this.yMask, this.fullMask);
	}
}