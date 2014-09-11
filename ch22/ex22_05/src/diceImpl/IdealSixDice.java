package diceImpl;

import java.util.Arrays;

import Observer.Dice;

public class IdealSixDice {
	private static final int[] shiftArray(int[] array, int shift) {
		if (array == null || shift < 0) {
			throw new IllegalArgumentException();
		}

		int[] result = new int[array.length + shift];

		for (int i = 0; i < array.length; i++) {
			result[shift + i] = array[i];
		}
		return result;
	}

	public static final int[] getTheoreticalValue(Dice dice, int numberOfDice) {
		int number = dice.getMax();
		int[] result = new int[number];
		Arrays.fill(result, 1);
		for(int i = 1; i < numberOfDice; i++){
			result = shiftAndMerge(result, number);
		}
		return result;
	}

	private static final int[] shiftAndMerge(int[] array, int number) {
		int[] result = shiftArray(array, 1);
		int[] shiftArray = null;
		for (int i = 2; i <= number; i++) {
			shiftArray = shiftArray(array, i);
			result = mergeArrays(result, shiftArray);
		}
		return result;
	}

	private static final int[] mergeArrays(int[] array1, int[] array2) {
		int size1 = array1.length;
		int size2 = array2.length;
		int resultSize = size2 <= size1 ? size1 : size2;
		int[] result = Arrays.copyOf(array1, resultSize);
		int[] mergee = Arrays.copyOf(array2, resultSize);

		for (int i = 0; i < resultSize; i++) {
			result[i] = result[i] + mergee[i];
		}

		return result;
	}

}
