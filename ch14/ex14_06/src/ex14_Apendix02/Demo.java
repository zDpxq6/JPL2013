package ex14_Apendix02;

public class Demo {
	
	
	public static void main(String[] args){
		
		new Thread(new PrintingMessage("15�b�o��", 15)).start();
		
		new Thread(new PrintingMessage("7�b�o��", 7)).start();
		
		new Thread(Timer.getInstance()).start();
	}
}
