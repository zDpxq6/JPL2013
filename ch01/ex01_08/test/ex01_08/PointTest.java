package ex01_08;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point expect = new Point();
		expect.move(new Point(1,1));
		assertThat(new Point(1,1), is(expect));
	}

}
