//(C) 2014 zDpxq6
package ex01_09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ex01_09.AlteredFibonacci;

public class AlteredFibonacciTest {

	@Test
	public void testCorrectCreation() {
		Integer[] expected = { 1, 1, 2 };
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(2);
		Integer[] actual = altFib.getFibonacci();
		assertThat(actual, is(expected));
	}

	@Test
	public void testCreationFail() {
		try {
			@SuppressWarnings("unused")
			AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(0);
			org.junit.Assert.fail("本来到達しない");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
