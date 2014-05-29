package ex24_02;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class 適当 implements Runnable{
	private final String fileName;

	適当(String fileName){
		super();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		File file = null;
		SourceDataLine line = null;
		try {
			file = new File(this.fileName);
			if (file.exists()) {
				AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				byte[] buf = new byte[stream.available()];
				stream.read(buf, 0, buf.length);

				// Get an AudioFormat object from the stream.
				AudioFormat format = stream.getFormat();
				long nBytesRead = format.getFrameSize() * stream.getFrameLength();

				// Construct a DataLine.Info object from the format.
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
				line = (SourceDataLine) AudioSystem.getLine(info);

				// Open and start the line.
				line.open(format);
				line.start();

				// Write the data out to the line.
				line.write(buf, 0, (int) nBytesRead);

				// Drain and close the line.
				line.drain();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(line != null){
				line.close();
			}
		}
	}
}
