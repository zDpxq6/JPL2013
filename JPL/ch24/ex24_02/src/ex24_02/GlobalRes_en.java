package ex24_02;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class GlobalRes_en extends ResourceBundle {

	private static final String GOODBYE = "goodbye.wav";
	private static final String HELLO = "hello.wav";

	private final Dictionary<String, Object> contents;

	public GlobalRes_en() {
		this.contents = new Hashtable<String, Object>();
		this.contents.put(GlobalRes.HELLO, HELLO);
		this.contents.put(GlobalRes.GOODBYE, GOODBYE);
	}

	@Override
	public Enumeration<String> getKeys() {
		return this.contents.keys();
	}

	@Override
	protected Object handleGetObject(String arg0) {
		return PlayWavFile.playWavFile((String) this.contents.get(arg0));
	}

}
