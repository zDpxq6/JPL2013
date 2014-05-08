package ex22_01;


public interface AttributedInterface{
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();
}