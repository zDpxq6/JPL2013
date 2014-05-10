//(C) 2014 zDpxq6
package ex01_03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class AlteredFibonacciTest {

	@Test
	public void testCorrectCreation() {
		List<Integer> expected = new LinkedList<Integer>();
		expected.add(1);
		expected.add(1);
		expected.add(2);
		AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(2);
		List<Integer> actual = altFib.getFibonacci();
		assertThat(actual,is(expected));
	}

	@Test
	public void testCreationFail() {
		try{
			@SuppressWarnings("unused")
			AlteredFibonacci altFib = AlteredFibonacci.createAlteredFibonacci(0);
			org.junit.Assert.fail("本来到達しない");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

}
