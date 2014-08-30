package ex01_10;

public class FibonacciElement {
	private final int fibonacciElement;
	private final boolean flag;

	FibonacciElement(int i, boolean flag) {
		this.fibonacciElement = i;
		this.flag = flag;
	}

	/**
	 * @return fibonacciElement
	 */
	public int getFibonacciElement() {
		return this.fibonacciElement;
	}

	/**
	 * @return flag
	 */
	public boolean isFlag() {
		return this.flag;
	}

	@Override
	public String toString() {
		String mark = this.flag ? "*" : "";
		return Integer.toString(this.fibonacciElement) + " " + mark;
		// return Integer.toString(this.fibonacciElement) + " " + this.flag ?
		// "*" : "";
	}
}
