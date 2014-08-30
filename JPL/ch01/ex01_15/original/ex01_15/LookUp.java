package ex01_15;

public interface LookUp {
	/** nameと関連付けられた値を返す
	 * そのような値がなければnullを返す */
	Object find(String name);
}
