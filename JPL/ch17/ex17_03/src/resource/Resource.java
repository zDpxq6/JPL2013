package resource;

public interface Resource {
	void use(Object key, Object...args);
	void release();
}
