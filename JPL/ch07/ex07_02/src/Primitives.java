public class Primitives {
	/*数値である各基本型のフィールドを宣言しているクラスを作成して、
	 * 異なるリテラル形式を使用して値を代入してみなさい。
	 * 例えば、intフィールドに3.5fを代入してみるとか。
	 * どのフィールドがどのフィールド型と一緒に使用できますか。
	 * 値の大きさを変えてどのような影響があるかを調べてみなさい。
	 * */

	static byte byteValue;
	static short shortValue;
	static int intValue;
	static long longValue;
	static float floatValue;
	static double doubleValue;

	public static <T extends Number> void setValues(T newValue){
		byteValue	= newValue.byteValue();
		shortValue	= newValue.shortValue();
		intValue		= newValue.intValue();
		longValue	= newValue.longValue();
		floatValue	= newValue.floatValue();
		doubleValue	= newValue.doubleValue();
	}

	static public void printPrimitives(){
		//System.out.println("***Printing Primitives***");
		System.out.println("byte: " + byteValue);
		System.out.println("short: " + shortValue);
		System.out.println("int: " + intValue);
		System.out.println("long: " + longValue);
		System.out.println("float: " + floatValue);
		System.out.println("double: " + doubleValue);
		System.out.println();
	}
}