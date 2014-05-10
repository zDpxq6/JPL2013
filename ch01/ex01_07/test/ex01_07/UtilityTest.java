//(C) 2014 zDpxq6
package ex01_07;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

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

	@Test
	public void test2(){
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Integer> list2 = Utility.copyList(list1);
		list1.set(1, 5);
		assertThat(list1.get(1).intValue(),not(list2.get(1).intValue()));
	}

}
