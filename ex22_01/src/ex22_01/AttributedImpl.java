package ex22_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedImpl extends Observable implements AttributedInterface, Iterable<Attr>{

//	private final List<Observer> observerList = new ArrayList<Observer>();

	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();

	@Override
	public void add(Attr newAttr) {
		this.attrTable.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}
	@Override
	public Attr find(String attrName) {
		return this.attrTable.get(attrName);
	}
	@Override
	public Attr remove(String attrName) {
		return this.attrTable.remove(attrName);
	}
	@Override
	public java.util.Iterator<Attr> attrs() {
		return this.attrTable.values().iterator();
	}
	@Override
	public Iterator<Attr> iterator() {
		return attrs();
	}

//	@Override
//	public void addObserver(Observer o) {
//		this.observerList.add(o);
//	}
}