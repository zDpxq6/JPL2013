package ex22_01;

public class Demo {

	public static void main(String[] args){
		double[] array = {	0.123456789, 1.234567890,
							12.34567890, 123.4567890,
							1234.567890, 12345.67890,
							123456.7890, 1234567.890,
							12345678.90};

		PrintFormattedArray.showElements(array, 1);
		PrintFormattedArray.showElements(array, 2);
		PrintFormattedArray.showElements(array, 3);
		PrintFormattedArray.showElements(array, 4);
		PrintFormattedArray.showElements(array, 5);
		PrintFormattedArray.showElements(array, 6);
		PrintFormattedArray.showElements(array, 7);
		PrintFormattedArray.showElements(array, 8);
		PrintFormattedArray.showElements(array, 9);
	}
}
