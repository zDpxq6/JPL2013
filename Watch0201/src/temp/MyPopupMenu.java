package temp;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import consta.Const;


public class MyPopupMenu implements ActionListener{
	public PopupMenu popup;

	public MyPopupMenu() {

		this.popup = new PopupMenu("Edit");

     // [Property]
		Menu menuProperty = new Menu("Property"); // 繝｡繝九Η繝ｼ繝舌�鬆�岼[Property]縺ｮ螳｣險�
		menuProperty.addActionListener(this); // 繝ｪ繧ｹ繝翫�縺ｮ莉伜刈
		this.popup.add(menuProperty); // 繝｡繝九Η繝ｼ繝舌�鬆�岼[Property]縺ｮ逕滓�
		// [Property]-[FontColor]
		Menu menuFontColor = new Menu("FontColor");
		menuFontColor.addActionListener(this);
		menuProperty.add(menuFontColor);
		// [Property]-[FontColor]-[Black]
		MenuItem menuSizeLargeFontColorBlack = new MenuItem("Black");
		menuFontColor.add(menuSizeLargeFontColorBlack);
		// [Property]-[FontColor]-[White]
		MenuItem menuSizeLargeFontColorWhite = new MenuItem("White");
		menuFontColor.add(menuSizeLargeFontColorWhite);
		// [Property]-[FontSize]
		Menu menuFontSize = new Menu("FontSize");
		menuFontSize.addActionListener(this);
		menuProperty.add(menuFontSize);
		// [Property]-[FontColor]-[Large]
		MenuItem menuSizeLarge = new MenuItem("Large");
		menuFontSize.add(menuSizeLarge);
		// [Property]-[FontColor]-[Small]
		MenuItem menuSizeSmall = new MenuItem("Small");
		menuFontSize.add(menuSizeSmall);
		// [Property]-[BackgroundColor]
		Menu menuBackgroundColor = new Menu("BackgroundColor");
		menuBackgroundColor.addActionListener(this);
		menuProperty.add(menuBackgroundColor);
		// [Property]-[BackgroundColor]-[Red]
		MenuItem menuBackgroundRed = new MenuItem("Red");
		menuBackgroundColor.add(menuBackgroundRed);
		// [Property]-[BackgroundColor]-[Blue]
		MenuItem menuBackgroundBlue = new MenuItem("Blue");
		menuBackgroundColor.add(menuBackgroundBlue);
		// [Property]-[BackgroundColor]-[Green]
		MenuItem menuBackgroundGreen = new MenuItem("Green");
		menuBackgroundColor.add(menuBackgroundGreen);
		// [Property]-[BackgroundColor]
		Menu menuFont = new Menu("Font");
		menuFont.addActionListener(this);
		menuProperty.add(menuFont);
		// [Property]-[BackgroundColor]-[Red]
		MenuItem menuFontDialog = new MenuItem("Dialog");
		menuFont.add(menuFontDialog);
		// [Property]-[BackgroundColor]-[Blue]
		MenuItem menuFontDialogInput = new MenuItem("DialogInput");
		menuFont.add(menuFontDialogInput);
		// [Property]-[BackgroundColor]-[Green]
		MenuItem menuFontMonospaced = new MenuItem("Monospaced");
		menuFont.add(menuFontMonospaced);
		MenuItem menuFontSerif = new MenuItem("Serif");
		menuFont.add(menuFontSerif);
		MenuItem menuFontSansSerif = new MenuItem("SansSerif");
		menuFont.add(menuFontSansSerif);
		MenuItem menuFontSymbol = new MenuItem("Symbol");
		menuFont.add(menuFontSymbol);

        //add(this.popup); // add popup menu to applet
//
//        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
//
//        resize(200, 200);
    }


	@Override
	public void actionPerformed( ActionEvent arg0) {
	    String command = arg0.getActionCommand();

	    if (command == "Large") {
	    		Watch.setFontSize(Const.FONT_SIZE_LARGE);
		}
		if (command == "Small") {
		 	Watch.setFontSize(Const.FONT_SIZE_SMALL);
		}

		if (command == "Dialog") {
			Watch.setFont("Dialog");
		}
		if (command == "DialogInput") {
			Watch.setFont("DialogInput");
		}
		if (command == "Monospaced") {
			Watch.setFont("Monospaced");
		}
		if (command == "Serif") {
			Watch.setFont("Serif");
		}
		if (command == "SanSerif") {
			Watch.setFont("SanSerif");
		}
		if (command == "Symbol") {
			Watch.setFont("Symbol");
		}

		if (command == "Red") {
			Watch.setBackgroundColor(Color.red);
		}
		if (command == "Blue") {
			Watch.setBackgroundColor(Color.blue);
		}
		if (command == "Green") {
			Watch.setBackgroundColor(Color.green);
		}

		if (command == "Black") {
			Watch.setFontColor(Color.black);
		}
		if (command == "White") {
			Watch.setFontColor(Color.white);
		}
    }
}
