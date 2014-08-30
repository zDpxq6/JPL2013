//(C) 2014 zDpxq6
package ex01_09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ex01_09.AlteredImprovedFibonacci;

public class AlteredFibonacciTest {

	@Test
	public void testCorrectCreation() {
		Integer[] expected = { 1, 1, 2 };
		AlteredImprovedFibonacci altFib = AlteredImprovedFibonacci.createAlteredFibonacci(2);
		Integer[] actual = altFib.getFibonacci();
		assertThat(actual, is(expected));
	}

	@Test
	public void testCreationFail() {
		try {
			@SuppressWarnings("unused")
			AlteredImprovedFibonacci altFib = AlteredImprovedFibonacci.createAlteredFibonacci(0);
			org.junit.Assert.fail("本来到達しない");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
