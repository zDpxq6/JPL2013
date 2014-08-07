package constant;

import java.awt.Color;

import display.Display;

public class SettingDataHolder{

	Display display;

	public SettingDataHolder(Display display){
		super();
		this.display = display;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.display.setBackgroundColor(backgroundColor);
	}

	public void setFontColor(Color fontColor) {
		this.display.setFontColor(fontColor);
	}

	public void setFontSize(int fontSize) {
		this.display.setFontSize(fontSize);

	}

	public void setFontType(String font) {
		this.display.setFontType(font);
	}

}