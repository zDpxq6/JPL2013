package constant;

import java.awt.Color;

import display.Display;

public class SettingDataHolder{

	Display display;

	public SettingDataHolder(Display display){
		super();
		this.display = display;
	}

	public void setBackgroundColor(Color white) {
		this.display.setBackgroundColor(white);
	}

	public void setFontColor(Color yellow) {
		this.display.setFontColor(yellow);
	}

	public void setFontSize(int parseInt) {
		this.display.setFontSize(parseInt);

	}

	public void setFont(String fontName) {
		this.display.setFont(fontName);
	}

	public void setFontType(String monospaced) {
		// TODO 自動生成されたメソッド・スタブ

	}

}