package ex24_03;

// PlayWavFile.java -- A test class that plays a .wav file

// Erica Asai<easai@acm.org>
// Time-stamp: <2004-09-03 03:41:05 easai>

// Comments:

// PlayWavFile plays a sound file "emma.wav" in WAVE format.

// This is a part of the article "Playing a sound file (in WAVE format) in Java".

// http://easai.00freehost.com/sound.html

// Please refer to the article for more information.


public class PlayWavFile {
	public static String playWavFile(String fileName) {
		Thread th = new Thread(new 適当(fileName));
		th.start();
		return fileName;
	}
}