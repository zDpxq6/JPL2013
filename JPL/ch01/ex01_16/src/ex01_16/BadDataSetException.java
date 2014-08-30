package ex01_16;

import java.io.IOException;

public class BadDataSetException extends Exception{
	private final String dataSetName;
//
//	public BadDataSetException(){
//		super();
//		this.dataSetName = null;
//	}
//
//	public BadDataSetException(String dataSetName){
//		super(dataSetName);
//		this.dataSetName = dataSetName;
//	}
//
//	public BadDataSetException(String dataSetName, Throwable cause){
//		super(dataSetName, cause);
//		this.dataSetName = dataSetName;
//	}
//
//	public BadDataSetException(Throwable cause){
//		super(cause);
//		this.dataSetName = null;
//	}

	/**
	 *
	 */
	private static final long serialVersionUID = -7752326614392528338L;

	public BadDataSetException(String dataSetName, IOException e){
		super(e);
		this.dataSetName = dataSetName;
	}

	/**
	 * @return dataSetName
	 */
	public String getDataSetName() {
		return this.dataSetName;
	}

}
