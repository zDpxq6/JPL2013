package lookUp;

import ex01_13.LookUp;

public interface SuperLookUp extends LookUp{
	/** nameと関連付けられた値を返す
	 * そのような値がなければnullを返す */
	@Override
	Object find(String name);
	/**
	 * @param newObject Object型のObjectは新しい要素として追加される
	 */
	void add(String key, Object value);
	/**
	 * @return オブジェクトを削除する
	 * @throws NoSuchMethodException 
	 */
	void remove(String name) throws NoSuchMethodException;
}
