public class ObjectNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(){
		super("オブジェクトがみつかりません");
	}

	public ObjectNotFoundException(String str){
		super(str);
	}
}