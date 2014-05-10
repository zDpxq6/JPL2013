package ex01_04;

import org.junit.Test;

import ex01_04.Utility;

public class UtilityTest {

	@Test
	public void test() {
		try{
		Utility.printList(null);
		org.junit.Assert.fail("本来到達しない");
		} catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
