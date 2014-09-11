package ex22_04;

import java.util.Iterator;

public interface Attributed{
	void add(Attribute newAttr);
	Attribute find(String attrName);
	Attribute remove(String attrName);
	Iterator<Attribute> attributes();
}