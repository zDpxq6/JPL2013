package lookUp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MySuperLookUpTest {

	@Test
	public void testAdd1() {
		MySuperLookUp myLookUp = new MySuperLookUp();
		try{
			myLookUp.add(null, "最初の値");
			fail("本来到達しない");
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	@Test
	public void testAdd2() {
		MySuperLookUp myLookUp = new MySuperLookUp();
		try{
			myLookUp.add("first", null);
			fail("本来到達しない");
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		MySuperLookUp myLookUp = new MySuperLookUp();
		myLookUp.add("first", "最初の値");
		String actual = (String) myLookUp.find("first");
		assertThat(actual, is("最初の値"));
	}

	public void testFind2() {
		MySuperLookUp myLookUp = new MySuperLookUp();
		myLookUp.add("first", "最初の値");
		String actual = (String) myLookUp.find("次の値");
		if(actual != null){
			fail("本来到達しない");
		}
	}

	@Test
	public void testRemove() {
		MySuperLookUp actual = new MySuperLookUp();
		actual.add("first", "最初の値");
		try{
			actual.remove("first");
			actual.remove("first");
			fail("本来到達しない");
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

}
