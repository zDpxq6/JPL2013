package ex01_16;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class BadDataSetExceptionTest {

	/**
	 *
	 */
	@Test
	public void test() {
		try{
			try{
				throw new IOException();
			}catch(IOException e){
				throw new BadDataSetException("dataSetName", e);
			}
		}catch(BadDataSetException e){
			assertThat(e.getDataSetName(), is("dataSetName"));
		}
	}

}
