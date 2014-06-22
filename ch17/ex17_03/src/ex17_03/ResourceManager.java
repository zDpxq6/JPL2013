package ex17_03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tsuguka
 * リソースマネージャーは、リソースを自動的に回収するクラスである。
 * リソースを自動的に回収することにより、リソースがどのように利用されても、
 * リソースの返還に気を遣う必要がなくなる。
 */
public final class ResourceManager {

	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;

	public ResourceManager() {
		this.queue = new ReferenceQueue<Object>();			//到達可能性が変化すると参照キューに入る
		this.refs = new HashMap<Reference<?>, Resource>();	//参照とリソースが結びついている
		this.reaper = new ReaperThread();					//刈り取りスレッド
		this.reaper.start();

		// ... リソースの初期化 ...
	}

	class ReaperThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Reference<?> ref = ResourceManager.this.queue.remove();//この時点でキューに入っているものが議論対象。参照キューから参照オブジェクトを1つ除いて返す.
					Resource resource = null;
					synchronized (ResourceManager.this) {
						resource = ResourceManager.this.refs.get(ref);//参照オブジェクトと結びついているリソースを返す
						ResourceManager.this.refs.remove(ref);//参照オブジェクトは削除
					}
					resource.release();
					ref.clear();//参照オブジェクトとリソースの結びつきを削除する
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	public synchronized void shutdown() {
		if (!this.shutdown) {
			this.shutdown = true;
			this.reaper.interrupt();
		}
	}

	public synchronized Resource getResource(Object key) {
		if (this.shutdown) {
			throw new IllegalStateException();
		}
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, this.queue);
		this.refs.put(ref, res);
		return res;
	}

	private static class ResourceImpl implements Resource {
		int keyHash;
		boolean needsRelease = false;

		ResourceImpl(Object key) {
			this.keyHash = System.identityHashCode(key);
			// ... 外部リソースの設定
			this.needsRelease = true;
		}

		@Override
		public void use(Object key, Object... args) {
			if (System.identityHashCode(key) != this.keyHash) {
				throw new IllegalArgumentException("wrong key");

				// ... リソースの使用 ...
			}

		}

		@Override
		public void release() {
			if (this.needsRelease) {
				this.needsRelease = false;
			}

		}

	}
}
