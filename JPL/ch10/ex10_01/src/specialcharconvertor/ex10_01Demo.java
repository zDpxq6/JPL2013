package specialcharconvertor;

public class ex10_01Demo {
	public static void main(String[] args){
		String str = SpecialCharConverter.printEscapedCharacter("\n \t \b \r \f \\ \' \"");
		System.out.println("output: " + str);
	}
}