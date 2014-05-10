//(C) 2014 zDpxq6
package ex01_04;

import org.junit.Test;

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
