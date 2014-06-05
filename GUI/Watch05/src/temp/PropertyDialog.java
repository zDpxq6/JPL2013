package temp;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import constant.Const;

public class PropertyDialog extends Dialog implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

		private Font font;
		private int fontSize;
		private Color fontColor;
		private Color backgroundColor;
		private boolean flag = false;
		private final GridBagLayout gridBagLayout = new GridBagLayout();
		private final Preferences preference;

		private final Label l1 = new Label("Font Size", Label.RIGHT);
		private final Label l2 = new Label("Font", Label.RIGHT);
		private final Label l3 = new Label("Font Color", Label.RIGHT);
		private final Label l4 = new Label("Background Color", Label.RIGHT);

		private final Choice selectingFontSize = new Choice();
		private final Choice selectingFont = new Choice();
		private final Choice selectingFontColor = new Choice();
		private final Choice selectingBackgroundColor = new Choice();

		private final Button ok = new Button("決定");
		private final Button cancel = new Button("キャンセル");

		PropertyDialog(Frame owner) {
			super(owner);
			this.setLayout(this.gridBagLayout);
			this.setTitle("プロパティ");
			this.preference = Preferences.userRoot().node("Display");
			this.setSize(Const.DIALOG_WIDTH, Const.DIALOG_HEIGHT);
			this.setLocation(this.preference.getInt("window_x", 0), this.preference.getInt("window_y", 0));
			this.setResizable(false);

			addChoice(this.selectingFontSize, "size", Const.FONT_SIZE_SMALL, Const.FONT_SIZE_LARGE);
			addChoice(this.selectingFont, "font", "Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput");
			addChoice(this.selectingFontColor, "color", "White", "Red", "Green", "Blue", "Black");
			addChoice(this.selectingBackgroundColor, "backgroundColor", "Blue", "White", "Black", "Red", "Green");

			addComponent(this.l1, 0, 0, 2, 1);
			addComponent(this.selectingFontSize, 2, 0, 2, 1);

			addComponent(this.l2, 0, 1, 2, 1);
			addComponent(this.selectingFont, 2, 1, 2, 1);

			addComponent(this.l3, 0, 2, 2, 1);
			addComponent(this.selectingFontColor, 2, 2, 2, 1);

			addComponent(this.l4, 0, 3, 2, 1);
			addComponent(this.selectingBackgroundColor, 2, 3, 2, 1);

			addComponent(this.cancel, 1, 4, 2, 1);
			this.cancel.addActionListener(this);
			addComponent(this.ok, 3, 4, 2, 1);
			this.ok.addActionListener(this);


			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent close) {
					close.getWindow().dispose();
				}
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("決定")) {
				this.preference.putInt("font-size", Integer.parseInt(this.selectingFontSize.getSelectedItem()));
				this.preference.put("font", this.selectingFont.getSelectedItem());
				this.preference.put("text-color", this.selectingFontColor.getSelectedItem());
				this.preference.put("background-color", this.selectingBackgroundColor.getSelectedItem());
				this.flag = true;
			}
			this.dispose();
		}

		public boolean isFlag() {
			return this.flag;
		}

		@Override
		public Font getFont() {
			return this.font;
		}

		public Color getTextcolor() {
			return this.fontColor;
		}

		@Override
		public Color getBackground() {
			return this.backgroundColor;
		}

		private void addChoice(Choice c, String type, String...strings) {
			ArrayList<String> arr = new ArrayList<String>();
			for (String s: strings) {
				if (s.equals(this.preference.get(type, null))) {
					arr.add(0, s);
				} else {
					arr.add(s);
				}
			}
			for (String s: arr) {
				c.add(s);
			}
		}

		private void addChoice(Choice c, String type, int...ints) {
			ArrayList<String> arr = new ArrayList<String>();
			for (Integer index: ints) {
				if (index.equals(this.preference.getInt("font-size", 50))) {
					arr.add(0, index.toString());
				} else {
					arr.add(index.toString());
				}
			}
			for (String s: arr) {
				c.add(s);
			}
		}

		private void addComponent(Component c, int x, int y, int w, int h) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = x;
			gbc.gridy = y;
			gbc.gridwidth = w;
			gbc.gridheight = h;
			gbc.insets = new Insets(5, 5, 5, 5);
			this.gridBagLayout.setConstraints(c, gbc);
			this.add(c);
		}
	}
