package ex17_02;
import java.lang.ref.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class DataHandler {
	private WeakReference <File> lastFile;//lastFileも弱い参照に変更
	private WeakReference <byte[]> lastData;
	
	byte[] readFile(File file) throws IOException {
		byte[] result;
		if (file.equals(lastFile)) {
			result = lastData.get();
			if (result != null){
				return result;
			}
		}
		result = readBytesFromFile(file);
		lastFile = new WeakReference <File> (file);
		lastData = new WeakReference<byte[]>(result);
		return result;
	}

	private byte[] readBytesFromFile(File file) throws IOException {
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			byte []fbytes = new byte[1024];  

			while ((bis.read(fbytes)) >= 0) {
				 System.out.print(new String(fbytes));  
			}
			
			return fbytes;
		} finally {
			if(bis != null){
				bis.close();
			}
		}
	}
}