public class Ex09_02{
	private static int bitCount(int number){
		int result = number >> 1 & 03333333333;
		result = number - result - (result >> 1 & 03333333333);
		result = (result + (result >> 3) & 0707070707) % 077;

		return result;
	}

	public static void main(String[] args){
		System.out.println(bitCount(3));
	}
}