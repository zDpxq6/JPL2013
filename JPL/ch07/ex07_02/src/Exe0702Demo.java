public class Exe0702Demo {
	/*���l�ł���e��{�^�̃t�B�[���h��錾���Ă���N���X���쐬���āA
	 * �قȂ郊�e�����`�����g�p���Ēl�������Ă݂Ȃ����B
	 * �Ⴆ�΁Aint�t�B�[���h��3.5f�������Ă݂�Ƃ��B
	 * �ǂ̃t�B�[���h���ǂ̃t�B�[���h�^�ƈꏏ�Ɏg�p�ł��܂����B
	 * �l�̑傫����ς��Ăǂ̂悤�ȉe�������邩�𒲂ׂĂ݂Ȃ����B
	 * */
	public static void main(String[] args){
		Integer res1 = new Integer(Byte.MIN_VALUE-1);
		System.out.println("******����l: "+(Byte.MIN_VALUE-1)+"******");
		Primitives.byteValue = (byte) (Byte.MIN_VALUE-1);
		Primitives.shortValue = Byte.MIN_VALUE-1;
		Primitives.intValue = Byte.MIN_VALUE-1;
		Primitives.longValue = Byte.MIN_VALUE-1;
		Primitives.floatValue = Byte.MIN_VALUE-1;
		Primitives.doubleValue = Byte.MIN_VALUE-1;
		Primitives.setValues(res1);
		Primitives.printPrimitives();

		System.out.println("******����l: "+Byte.MIN_VALUE+"******");
		Primitives.byteValue = Byte.MIN_VALUE;
		Primitives.shortValue = Byte.MIN_VALUE;
		Primitives.intValue = Byte.MIN_VALUE;
		Primitives.longValue = Byte.MIN_VALUE;
		Primitives.floatValue = Byte.MIN_VALUE;
		Primitives.doubleValue = Byte.MIN_VALUE;
		Primitives.printPrimitives();
		System.out.println("******����l: "+Byte.MAX_VALUE+"******");
		Primitives.byteValue = Byte.MAX_VALUE;
		Primitives.shortValue = Byte.MAX_VALUE;
		Primitives.intValue = Byte.MAX_VALUE;
		Primitives.longValue = Byte.MAX_VALUE;
		Primitives.floatValue = Byte.MAX_VALUE;
		Primitives.doubleValue = Byte.MAX_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Byte.MAX_VALUE+1)+"******");
		Primitives.byteValue = (byte) (Byte.MAX_VALUE+1);
		Primitives.shortValue = Byte.MAX_VALUE+1;
		Primitives.intValue = Byte.MAX_VALUE+1;
		Primitives.longValue = Byte.MAX_VALUE+1;
		Primitives.floatValue = Byte.MAX_VALUE+1;
		Primitives.doubleValue = Byte.MAX_VALUE+1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Short.MIN_VALUE-1)+"******");
		Primitives.byteValue = (byte) Short.MIN_VALUE-1;
		Primitives.shortValue = (short) (Short.MIN_VALUE-1);
		Primitives.intValue = Short.MIN_VALUE-1;
		Primitives.longValue = Short.MIN_VALUE-1;
		Primitives.floatValue = Short.MIN_VALUE-1;
		Primitives.doubleValue = Short.MIN_VALUE-1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Short.MIN_VALUE+"******");
		Primitives.byteValue = (byte) Short.MIN_VALUE;
		Primitives.shortValue = Short.MIN_VALUE;
		Primitives.intValue = Short.MIN_VALUE;
		Primitives.longValue = Short.MIN_VALUE;
		Primitives.floatValue = Short.MIN_VALUE;
		Primitives.doubleValue = Short.MIN_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Short.MAX_VALUE+"******");
		Primitives.byteValue = (byte) Short.MAX_VALUE;
		Primitives.shortValue = Short.MAX_VALUE;
		Primitives.intValue = Short.MAX_VALUE;
		Primitives.longValue = Short.MAX_VALUE;
		Primitives.floatValue = Short.MAX_VALUE;
		Primitives.doubleValue = Short.MAX_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Short.MAX_VALUE+1)+"******");
		Primitives.byteValue = (byte) Short.MAX_VALUE+1;
		Primitives.shortValue = (short) (Short.MAX_VALUE+1);
		Primitives.intValue = Short.MAX_VALUE+1;
		Primitives.longValue = Short.MAX_VALUE+1;
		Primitives.floatValue = Short.MAX_VALUE+1;
		Primitives.doubleValue = Short.MAX_VALUE+1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Integer.MIN_VALUE-1)+"******");
		Primitives.byteValue = (byte) Integer.MIN_VALUE-1;
		Primitives.shortValue = (short) Integer.MIN_VALUE-1;
		Primitives.intValue = Integer.MIN_VALUE-1;
		Primitives.longValue = Integer.MIN_VALUE-1;
		Primitives.floatValue = Integer.MIN_VALUE-1;
		Primitives.doubleValue = Integer.MIN_VALUE-1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Integer.MIN_VALUE+"******");
		Primitives.byteValue = (byte) Integer.MIN_VALUE;
		Primitives.shortValue = (short) Integer.MIN_VALUE;
		Primitives.intValue = Integer.MIN_VALUE;
		Primitives.longValue = Integer.MIN_VALUE;
		Primitives.floatValue = Integer.MIN_VALUE;
		Primitives.doubleValue = Integer.MIN_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Integer.MAX_VALUE+"******");
		Primitives.byteValue = (byte) Integer.MAX_VALUE;
		Primitives.shortValue = (short) Integer.MAX_VALUE;
		Primitives.intValue = Integer.MAX_VALUE;
		Primitives.longValue = Integer.MAX_VALUE;
		Primitives.floatValue = Integer.MAX_VALUE;
		Primitives.doubleValue = Integer.MAX_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Integer.MAX_VALUE+1)+"******");
		Primitives.byteValue = (byte) Integer.MAX_VALUE+1;
		Primitives.shortValue = (short) Integer.MAX_VALUE+1;
		Primitives.intValue = Integer.MAX_VALUE+1;
		Primitives.longValue = Integer.MAX_VALUE+1;
		Primitives.floatValue = Integer.MAX_VALUE+1;
		Primitives.doubleValue = Integer.MAX_VALUE+1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Long.MIN_VALUE-1)+"******");
		Primitives.byteValue = (byte) Long.MIN_VALUE-1;
		Primitives.shortValue = (short) Long.MIN_VALUE-1;
		Primitives.intValue = (int) Long.MIN_VALUE-1;
		Primitives.longValue = Long.MIN_VALUE-1;
		Primitives.floatValue = Long.MIN_VALUE-1;
		Primitives.doubleValue = Long.MIN_VALUE-1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Long.MIN_VALUE+"******");
		Primitives.byteValue = (byte) Long.MIN_VALUE;
		Primitives.shortValue = (short) Long.MIN_VALUE;
		Primitives.intValue = (int) Long.MIN_VALUE;
		Primitives.longValue = Long.MIN_VALUE;
		Primitives.floatValue = Long.MIN_VALUE;
		Primitives.doubleValue = Long.MIN_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Long.MAX_VALUE+"******");
		Primitives.byteValue = (byte) Long.MAX_VALUE;
		Primitives.shortValue = (short) Long.MAX_VALUE;
		Primitives.intValue = (int) Long.MAX_VALUE;
		Primitives.longValue = Long.MAX_VALUE;
		Primitives.floatValue = Long.MAX_VALUE;
		Primitives.doubleValue = Long.MAX_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+(Long.MAX_VALUE+1)+"******");
		Primitives.byteValue = (byte) Long.MAX_VALUE+1;
		Primitives.shortValue = (short) Long.MAX_VALUE+1;
		Primitives.intValue = (int) Long.MAX_VALUE+1;
		Primitives.longValue = Long.MAX_VALUE+1;
		Primitives.floatValue = Long.MAX_VALUE+1;
		Primitives.doubleValue = Double.MAX_VALUE+1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Float.MIN_VALUE+"******");
		Primitives.byteValue = (byte) Float.MIN_VALUE-1;
		Primitives.shortValue = (short) Float.MIN_VALUE-1;
		Primitives.intValue = (int) Float.MIN_VALUE-1;
		Primitives.longValue = (long) (Float.MIN_VALUE-1);
		Primitives.floatValue = Float.MIN_VALUE-1;
		Primitives.doubleValue = Float.MIN_VALUE-1;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Float.MAX_VALUE+1+"******");
		Primitives.byteValue = (byte) Float.MAX_VALUE;
		Primitives.shortValue = (short) Float.MAX_VALUE;
		Primitives.intValue = (int) Float.MAX_VALUE;
		Primitives.longValue = (long) Float.MAX_VALUE;
		Primitives.floatValue = Float.MAX_VALUE;
		Primitives.doubleValue = Float.MAX_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Double.MIN_VALUE+"******");
		Primitives.byteValue = (byte) Double.MIN_VALUE;
		Primitives.shortValue = (short) Double.MIN_VALUE;
		Primitives.intValue = (int) Double.MIN_VALUE;
		Primitives.longValue = (long) Double.MIN_VALUE;
		Primitives.floatValue = (float) Double.MIN_VALUE;
		Primitives.doubleValue = Double.MIN_VALUE;
		Primitives.printPrimitives();

		System.out.println("******����l: "+Double.MAX_VALUE+"******");
		Primitives.byteValue = (byte) Double.MAX_VALUE;
		Primitives.shortValue = (short) Double.MAX_VALUE;
		Primitives.intValue = (int) Double.MAX_VALUE;
		Primitives.longValue = (long) Double.MAX_VALUE;
		Primitives.floatValue = (float) Double.MAX_VALUE;
		Primitives.doubleValue = Double.MAX_VALUE;
		Primitives.printPrimitives();
	}
}