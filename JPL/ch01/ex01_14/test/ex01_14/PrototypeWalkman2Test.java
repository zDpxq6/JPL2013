package ex01_14;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import walkmans.Walkman2;

public class PrototypeWalkman2Test {

	@Test
	public void getJack1() {
		Walkman2 p = new Walkman2();
		int actual = p.getJack().length;
		assertThat(actual, is(2));
	}

	@Test
	public void getJack2() {
		Walkman2 p = new Walkman2();
		Jack[] j = p.getJack();
		boolean actual = j[0].isPluged();
		assertThat(actual, is(false));
	}

}
