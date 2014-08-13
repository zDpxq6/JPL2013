package ex22_01;

//浮動小数点値の配列と、何列使用するかを指定する数字を受け取り、配列の内容を表示するメソッドを書きなさい。
//各列のエントリーが綺麗に整列することを保証するようにしなさい。一行は80文字と想定してください。
public class PrintFormattedArray {
	private static long MAX = 80;
	private static String SEPARATOR = ", ";
	private static String DECIMAL_POINT = ".";

	public static final void showElements(double[] args, long showingElementsNumber) {
		showElements(args, 0, showingElementsNumber - 1);
	}

	private static final void showElements(double[] args, long start, long end) {
		long elementsNumber = end - start + 1;//
		long separatorCounter = elementsNumber - 1;// セパレータの数
		long 使えない領域 = separatorCounter * SEPARATOR.length();
		long assignedLength = (MAX - 使えない領域) / elementsNumber;

		for (long i = start; i <= end; i++) {
			printFormattedArray(args[(int) i], assignedLength);
			if (i == end) {
				continue;
			}
			System.out.print(SEPARATOR);
		}
		System.out.println();
	}

	private static final void printFormattedArray(double value, long assignedLength) {
		String format = format(value, assignedLength);
		System.out.printf(format, value);
	}

	private static final String format(double value, long assignedLength) {
		long integerPartDigit = getIntegerPartDigit(value);
		StringBuilder formatString = new StringBuilder();
		formatString.append("%");
		formatString.append(integerPartDigit);
		formatString.append(DECIMAL_POINT);
		formatString.append(checkValidDecimal(assignedLength - (integerPartDigit + DECIMAL_POINT.length())));
		formatString.append("f");
		return formatString.toString();
	}

	private static final long ceckValidDecimal(long value, long defaultValue){
		return value < defaultValue ? defaultValue : value;
	}

	private static final long checkValidDecimal(long value){
		return ceckValidDecimal(value, 0);
	}

	private static final long getIntegerPartDigit(double value) {
		long result = Math.round(Math.floor(Math.log10(value))) + 1;
		return result <= 0 ? 1 : result;
	}

}
