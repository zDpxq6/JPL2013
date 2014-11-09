public class Primitives {
	/*���l�ł���e��{�^�̃t�B�[���h��錾���Ă���N���X���쐬���āA
	 * �قȂ郊�e�����`�����g�p���Ēl�������Ă݂Ȃ����B
	 * �Ⴆ�΁Aint�t�B�[���h��3.5f�������Ă݂�Ƃ��B
	 * �ǂ̃t�B�[���h���ǂ̃t�B�[���h�^�ƈꏏ�Ɏg�p�ł��܂����B
	 * �l�̑傫����ς��Ăǂ̂悤�ȉe�������邩�𒲂ׂĂ݂Ȃ����B
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