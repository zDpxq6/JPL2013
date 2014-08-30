package lookUp;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MySuperLookUp implements SuperLookUp{
	private final Map<String,Object> nameMap = new HashMap<String, Object>();

	public MySuperLookUp(){
		super();
	}
	@Override
	public Object find(String name) {
		return this.nameMap.get(name);
	}

	@Override
	public void remove(String name) throws NoSuchElementException {
		Object value = this.nameMap.get(name);
		if(value != null){
			this.nameMap.remove(name);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void add(String key, Object value) {
		if(key == null || value == null){
			throw new NullPointerException();
		}
		this.nameMap.put(key, value);
	}

}
