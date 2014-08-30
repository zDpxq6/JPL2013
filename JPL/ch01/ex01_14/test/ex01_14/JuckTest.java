package ex01_14;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class JuckTest {

	@Test
	public void testIsPluged() {
		Jack j = new Jack();
		boolean actual = j.isPluged();
		assertThat(actual, is(false));
	}

	@Test
	public void testSetPlug() {
		Jack j = new Jack();
		j.setPlug(true);
		boolean actual = j.isPluged();
		assertThat(actual, is(true));
	}

	@Test
	public void testConstructor() {
		//Jack[] j = new Jack[1];
		Jack[] j = {new Jack()};//new Jack[1];
		boolean actual = j[0].isPluged();
		assertThat(actual, is(false));
	}

}
