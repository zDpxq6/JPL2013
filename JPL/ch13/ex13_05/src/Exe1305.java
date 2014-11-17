public class Exe1305 {
	// 10進数を含む文字列を、右から3桁ごとにカンマで区切られた数に変換するメソッドを書きなさい。
	// たとえば、文字列"1543729"が与えられたら、そのメソッドは、文字列”1,543,729”を返します。

	private static final char SEPARATOR = ',';
	private static final int DIGITS = 3;

	public static String separateString( final String target) {
		return separateString(target, SEPARATOR, DIGITS);
	}

	public static String separateString( final String target, char separator,
			int digits) {
		int numberOfSeparators = target.length() / digits;
		int digitsBeforeFirstSepartor = target.length() % digits;

		int end = digitsBeforeFirstSepartor;
		int start = 0;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i <= numberOfSeparators; i++) {
			if(end == 0){
				start = end;
				end += digits;
				continue;
			}
			result.append(target.substring(start, end));
			if (i == numberOfSeparators) {
				break;
			}
			result.append(separator);
			start = end;
			end += digits;
		}
		return result.toString();
	}

}
