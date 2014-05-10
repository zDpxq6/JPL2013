package ex01_04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SquareNumberTest {

	@Test
	public void testCorrectCreation() {
		List<Integer> expected = new LinkedList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(4);
		SquareNumber altSqu = SquareNumber.createSquareNumber(2);
		List<Integer> actual = altSqu.getSquareNumber();
		assertThat(actual,is(expected));
	}

	@Test
	public void testCreationFail() {
		try{
			@SuppressWarnings("unused")
			SquareNumber altFib = SquareNumber.createSquareNumber(-1);
			org.junit.Assert.fail("本来到達しない");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

}
