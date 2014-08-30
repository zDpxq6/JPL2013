//(C) 2014 zDpxq6
package ex01_09;

import java.util.List;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void printListTest1() {
		try{
		Utility.printList((Object[])null);
		org.junit.Assert.fail("本来到達しない");
		} catch(NullPointerException e){
			e.printStackTrace();
		}
	}

	@Test
	public void  printListTest2() {
		try{
		Utility.printList((List<Object>)null);
		org.junit.Assert.fail("本来到達しない");
		} catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
