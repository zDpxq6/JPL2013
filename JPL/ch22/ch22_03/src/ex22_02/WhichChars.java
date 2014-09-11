package ex22_02;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

public class WhichChars {
	private final HashMap<Byte,BitSet>used = new HashMap<Byte,BitSet>();

	public WhichChars(String str){
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			Byte key = (byte) (str.charAt(i) >> 8);

			BitSet value = this.used.get(key);
			if (value == null) {
				value = new BitSet();
				this.used.put(key, value);
			}

			value.set(c & 0x00FF);
		}
	}

	@Override
	public String toString(){
		String desc = "[";
		Set<Byte> usedSet = this.used.keySet();

		for (Byte upper : usedSet) {
			BitSet lower = this.used.get(upper);
			for (int i = lower.nextSetBit(0); i >= 0; i = lower.nextSetBit(i + 1)) {
				desc += (char) (upper << 8 | i);
			}
		}

		return desc + "]";
	}
}
