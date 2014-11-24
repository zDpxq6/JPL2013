package Attr;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this(name, null);
	}

	public Attr(DataInputStream dis) {
		String name = null;
		DataInputStream copyOfdis = new DataInputStream(dis);
		try {
			// nameの設定
			name = copyOfdis.readUTF();

			// valueの設定
			byte[] valueByte = new byte[copyOfdis.readInt()];
			copyOfdis.read(valueByte);
			ByteArrayInputStream bais = new ByteArrayInputStream(valueByte);
			ObjectInputStream ois = new ObjectInputStream(bais);
			this.value = ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}

	public Object setValue(Object newValue) {
		Object oldval = this.value;
		this.value = newValue;
		return oldval;
	}

	@Override
	public String toString() {
		return this.name + " = '" + this.value + "'";
	}

	public void getStream(DataOutputStream dos) {
		DataOutputStream copyOfdos = new DataOutputStream(dos);
		try {
			copyOfdos.writeUTF(this.name);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(new ByteArrayOutputStream());
			oos.writeObject(this.value);
			oos.close();
			baos.close();
			byte[] valueByte = baos.toByteArray();
			int valueByteSize = valueByte.length;
			copyOfdos.writeInt(valueByteSize);
			copyOfdos.write(valueByte);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}