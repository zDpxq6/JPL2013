package ex14_02;

import print.IPrintQueueInterface;

public class PrintJob implements IPrintQueueInterface {
	private final String content;
	
	public PrintJob(String content){
		if(content == null){
			throw new NullPointerException();
		}
		this.content = content;
	}
	
	public Object getContent(){
		return this.content;
	}
	
	public void print(){
		System.out.println(this);
	}
	
	public String toString(){
		return content;
	}
}
