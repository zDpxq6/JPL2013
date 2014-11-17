public class Exe1306 {
	// 区切り文字と、区切り文字間の桁数を指定するパラメータを受け付けるようにメソッドを修正しなさい。

	private static final char SEPARATOR = ',';
	private static final int DIGITS = 3;

	public static String separateString( final String target) {
		return separateString(target, SEPARATOR, DIGITS);
	}

	public static String separateString( final String target, char separator,
			int digits) {
		if(digits < 0){
			throw new IllegalArgumentException("桁に無効な値が入力されています");
		}
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
