package ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

//監視される方
public class ObservableImpl extends Observable implements Attributed {

	private final Map<String, Attribute> map = new HashMap<String, Attribute>();

	@Override
	public void add(Attribute newAttr) {
		this.map.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	@Override
	public Attribute find(String attrName) {
		return this.map.get(attrName);
	}

	@Override
	public Attribute remove(String attrName) {
		return this.map.remove(attrName);
	}

	@Override
	public Iterator<Attribute> attributes() {
		List<Attribute> list = new LinkedList<Attribute>();
		for(Map.Entry<String,Attribute> e:this.map.entrySet()){
			list.add(e.getValue());
		}
		return list.iterator();
	}
}
