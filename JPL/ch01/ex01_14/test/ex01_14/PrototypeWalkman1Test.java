package ex01_14;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import walkmans.Walkman1;

public class PrototypeWalkman1Test {

	@Test
	public void getJack1() {
		Walkman1 p = new Walkman1();
		int actual = p.getJack().length;
		assertThat(actual, is(1));
	}

	@Test
	public void getJack2() {
		Walkman1 p = new Walkman1();
		Jack[] j = p.getJack();
		boolean actual = j[0].isPluged();
		assertThat(actual, is(false));
	}

}
