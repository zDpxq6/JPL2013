package ex10_05;

public class CharPrinter {
	public static void printChars(char char1, char char2) {
		char start = char1;
		char end = char2;
		if (0 < Character.valueOf(start).compareTo(Character.valueOf(end))) {
			char tmp = char2;
			end = start;
			start = tmp;
		}
		StringBuffer stringBuffer = new StringBuffer();
		start--;
		do {
			start++;
			stringBuffer.append(start);
		} while (start != end);
		System.out.println(stringBuffer.toString());
	}
}
