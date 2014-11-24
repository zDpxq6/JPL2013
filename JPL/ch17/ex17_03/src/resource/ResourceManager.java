package resource;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tsuguka リソースマネージャは外部リソース群へのアクセスを制御する。
 *         オブジェクト(?)は、リソースマネージャへリソースへのアクセスを要求し、処理が終わるまで使用できる。
 *         リソースマネージャは、リソースを自動的に回収するクラスである。 リソースを自動的に回収することにより、リソースがどのように利用されても、
 *         リソースの返還に気を遣う必要がなくなる。 "キーオブジェクト"を導入し、キーオブジェクトへ到達可能かどうかでリソースを管理する。
 *         キーオブジェクトへ到達できるときはリソースは専有されていて、到達できない時はリソースは専有が終わっている。
 *         リソースの専有が終わっている場合は回収される
 */
public final class ResourceManager {

	/**
	 * Referenceオブジェクトのキュー Referenceがたくさん入っている 到達可能性が変化すると入る
	 */
	final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();// 到達可能性が変化すると参照キューに入る
	final Map<Reference<?>, Resource> reference = new HashMap<Reference<?>, Resource>();

	/**
	 * ReferenceとResourceがMapになっているので、 1. ReferenceがPhantomReferenceでもアクセス可能 2.
	 * Referenceが常に到達可能
	 */
	final Thread reaper = new ReaperThread(); // 刈り取りスレッド
	boolean isShutdown = false;

	public ResourceManager() {
		this.reaper.start();

		// ... リソースの初期化 ...
	}

	class ReaperThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Reference<?> ref = ResourceManager.this.queue.remove();// この時点でキューに入っているものが議論対象。参照キューから参照オブジェクトを1つ除いて返す.
					Resource resource = null;
					synchronized (ResourceManager.this) {
						resource = ResourceManager.this.reference.get(ref);// 参照オブジェクトと結びついているリソースを返す
						ResourceManager.this.reference.remove(ref);// 参照オブジェクトは削除
					}
					resource.release();
					ref.clear();// 参照オブジェクトとリソースの結びつきを削除する
				} catch (InterruptedException e) {
					if (ResourceManager.this.isShutdown && ResourceManager.this.reference.size() == 0) {
						break;
					} else {
						continue;
					}
				}
			}
		}
	}

	public synchronized void shutdown() {
		if (!this.isShutdown) {
			this.isShutdown = true;
			this.reaper.interrupt();
		}
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public synchronized Resource getResource(Object key) {
		if (this.isShutdown) {
			throw new IllegalStateException();
		}

		Resource resource = new ResourceImpl(key);
		Reference<?> reference = new PhantomReference<Object>(key, this.queue);
		((Map<Reference<?>, Resource>) reference).put(reference, resource);
		return resource;
	}

	private static class ResourceImpl<T> implements Resource {
		Reference<T> keyReference;
		boolean needRelease = false;

		ResourceImpl(T key) {
			if (this.needRelease) {
				throw new IllegalStateException();
			}
			this.keyReference = new WeakReference<T>(key);
			// ... 外部リソースの設定
			this.needRelease = true;
		}

		@Override
		public void use(Object key, Object... args) {
			if (key == null || key.equals(this.keyReference.get()) == false) {
				throw new IllegalArgumentException("wrong key");

				// ... リソースの使用 ...
			}

		}

		@Override
		public synchronized void release() {
			if (this.needRelease) {
				this.needRelease = false;
			}

		}

	}
}
