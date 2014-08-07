package constant;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import display.Display;

/**
 * ダイアログに関する設定を行うクラス
 */
public class PropertyDialog extends JDialog {

	private static final int FONT_TYPE_DEFAULT_INDEX = 1;

	private static final int FONT_SIZE_DEFAULT_INDEX = 2;

	private static final int FONT_COLOR_DEFAULT_INDEX = 1;

	private static final int BACGROUND_COLOR_DEFAULT_INDEX = 2;

	private static final long serialVersionUID = 1L;

	// フィールド
	private final SettingDataHolder dataHolder;//TODO
	private JList fontTypeList;
	private JList fontSizeList;
	private JList fontColorList;
	private JList backgroundColorList;

	private static final Dimension FONT_LIST_SIZE = new Dimension(120, 60);
	private static final Dimension COLOR_LIST_SIZE = new Dimension(120, 120);
	private static final Dimension DIALOG_SIZE = new Dimension(400, 600);
	private static final Insets lABEL_INSETS = new Insets(0, 0, 15, 0);
	private static final Insets LIST_INSETS = new Insets(0, 15, 15, 0);
	/**
	 * @return the previousFontType
	 */
	public int getPreviousFontType() {
		return this.previousFontType;
	}

	/**
	 * @return the previousFontSize
	 */
	public int getPreviousFontSize() {
		return this.previousFontSize;
	}

	/**
	 * @return the previousFontColor
	 */
	public int getPreviousFontColor() {
		return this.previousFontColor;
	}

	/**
	 * @return the previousBackgroundColor
	 */
	public int getPreviousBackgroundColor() {
		return this.previousBackgroundColor;
	}

	private int previousFontType;
	private int previousFontSize;
	private int previousFontColor;
	private int previousBackgroundColor;

	private int currentFontType;
	private int currentFontSize;
	private int currentFontColor;
	private int currentBackgroundColor;

	public PropertyDialog(Display owner, SettingDataHolder holder) {
		super(owner);
		this.dataHolder = holder;
		setResizable(false);
		setSize(DIALOG_SIZE);
		setTitle(Constant.TITLE);

		GridBagLayout gbl= new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		// 各項目の設定
		initFontTypeList();
		initFontSizeList();
		initFontColorList();
		initBackgroundColorList();

		addLabel(0, 0, Constant.FONT, gbl, gbc);
		addList	(1, 0, this.fontTypeList, gbl, gbc, FONT_LIST_SIZE);

		addLabel(0, 1, Constant.FONT_SIZE, gbl, gbc);
		addList	(1, 1, this.fontSizeList, gbl, gbc, FONT_LIST_SIZE);

		addLabel(0, 2, Constant.FONT_COLOR, gbl, gbc);
		addList	(1, 2, this.fontColorList, gbl, gbc, COLOR_LIST_SIZE);

		addLabel(0, 3, Constant.BACKGROUND_COLOR, gbl, gbc);
		addList	(1, 3, this.backgroundColorList, gbl, gbc, COLOR_LIST_SIZE);

		// OKボタン
		JButton okButton = new JButton(Constant.OK);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PropertyDialog.this.previousFontType = PropertyDialog.this.currentFontType;
				PropertyDialog.this.previousFontSize = PropertyDialog.this.currentFontSize;
				PropertyDialog.this.previousFontColor = PropertyDialog.this.currentFontColor;
				PropertyDialog.this.previousBackgroundColor = PropertyDialog.this.currentBackgroundColor;
			}
		});
		addBtn(2, 5, okButton, gbl, gbc);

		// キャンセル
		JButton cancelButton = new JButton(Constant.CANCEL);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				refresh();
			}
		});
		addBtn(1, 5, cancelButton, gbl, gbc);
	}

	public void refresh(){
		PropertyDialog.this.currentFontType = PropertyDialog.this.previousFontType;
		PropertyDialog.this.currentFontSize = PropertyDialog.this.previousFontSize;
		PropertyDialog.this.currentFontColor = PropertyDialog.this.previousFontColor;
		PropertyDialog.this.currentBackgroundColor = PropertyDialog.this.previousBackgroundColor;
		PropertyDialog.this.fontTypeList.setSelectedIndex(PropertyDialog.this.currentFontType);
		PropertyDialog.this.fontSizeList.setSelectedIndex(PropertyDialog.this.currentFontSize);
		PropertyDialog.this.fontColorList.setSelectedIndex(PropertyDialog.this.currentFontColor);
		PropertyDialog.this.backgroundColorList.setSelectedIndex(PropertyDialog.this.currentBackgroundColor);
	}

	/**
	 * フォントタイプの設定項目を初期化します
	 */
	private void initFontTypeList() {
		String[] items = { Constant.FONT_SERIF, Constant.FONT_SANS_SERIF, Constant.FONT_MONOSPACED };
		this.fontTypeList = new JList(items);
		this.fontTypeList.setSelectedIndex(this.previousFontType);
		this.previousFontType = FONT_TYPE_DEFAULT_INDEX;
		this.fontTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.fontTypeList.addListSelectionListener(new FontTypeListener());
	}

	/**
	 * フォントサイズの設定項目を初期化します
	 */
	private void initFontSizeList() {
		Object[] items = {	Constant.SMALL_FONT_SIZE, Constant.MIDIUM_FONT_SIZE, Constant.LARGE_FONT_SIZE };
		this.fontSizeList = new JList(items);
		this.fontSizeList.setSelectedIndex(this.previousFontSize);
		this.previousFontSize = FONT_SIZE_DEFAULT_INDEX;
		this.fontSizeList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selected = (Integer) PropertyDialog.this.fontSizeList.getSelectedValue();
				PropertyDialog.this.currentFontSize = PropertyDialog.this.fontSizeList.getSelectedIndex();
				PropertyDialog.this.dataHolder.setFontSize(selected);
			}
		});
	}

	/**
	 * 文字色
	 */
	private void initFontColorList() {
		Object[] items = {	Colour.WHITE, Colour.BLACK, Colour.RED,
				Colour.BLUE, Colour.YELLOW, Colour.GREEN };
		this.fontColorList = new JList(items);
		this.fontColorList.setCellRenderer(new MyListCellRenderer());
		this.fontColorList.setSelectedIndex(this.previousFontColor);
		this.previousFontColor = FONT_COLOR_DEFAULT_INDEX;
		this.fontColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Color selected = ((constant.Colour)PropertyDialog.this.fontColorList.getSelectedValue()).getColour();
				PropertyDialog.this.currentFontColor = PropertyDialog.this.fontColorList.getSelectedIndex();
				PropertyDialog.this.dataHolder.setFontColor(selected);
			}
		});
	}


	/**
	 * 背景色
	 */
	private void initBackgroundColorList() {
		Object[] items = {	Colour.WHITE, Colour.BLACK, Colour.RED,
				Colour.BLUE, Colour.YELLOW, Colour.GREEN };
		this.backgroundColorList = new JList(items);
		this.backgroundColorList.setCellRenderer(new MyListCellRenderer());
		this.backgroundColorList.setSelectedIndex(this.previousBackgroundColor);
		this.backgroundColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Color selected = ((constant.Colour)PropertyDialog.this.backgroundColorList.getSelectedValue()).getColour();
				PropertyDialog.this.currentBackgroundColor = PropertyDialog.this.backgroundColorList.getSelectedIndex();
				PropertyDialog.this.dataHolder.setBackgroundColor(selected);
			}
		});
	}

	private void addLabel(int x, int y, String title, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = lABEL_INSETS;

		JLabel label = new JLabel(title);
		gbl.setConstraints(label, gbc);
		add(label);
	}

	private void addList(int x, int y, JList list, GridBagLayout gbl, GridBagConstraints gbc,Dimension dimension) {
		JScrollPane sp = new JScrollPane(list);
		sp.setPreferredSize(dimension);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = LIST_INSETS;
		gbl.setConstraints(sp, gbc);
		add(sp);
	}

	/**
	 * 指定されたJButtonをGridBagLayoutの指定された位置に追加します
	 */
	private void addBtn(int x, int y, JButton btn, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = LIST_INSETS;
		gbl.setConstraints(btn, gbc);
		add(btn);
	}

	/**
	 * フォントタイプのリストが選択された時の処理を定義します
	 */
	private class FontTypeListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String selected = PropertyDialog.this.fontTypeList.getSelectedValue().toString();
			PropertyDialog.this.currentFontType = PropertyDialog.this.fontTypeList.getSelectedIndex();
			if (selected.equals(Constant.FONT_MONOSPACED)) {
				PropertyDialog.this.dataHolder.setFontType(Font.MONOSPACED);
			} else if (selected.equals(Constant.FONT_SERIF)) {
				PropertyDialog.this.dataHolder.setFontType(Font.SERIF);
			} else {
				PropertyDialog.this.dataHolder.setFontType(Font.SANS_SERIF);
			}
		}
	}

	public void save(){
		Preferences pref = Preferences.systemNodeForPackage(this.getClass());
		pref.putInt("FontType", this.previousFontType);
		pref.putInt("FontSize", this.previousFontSize);
		pref.putInt("FontColor", this.previousFontColor);
		pref.putInt("BackgroundColor", this.previousBackgroundColor);
		try {
			pref.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public void load(){
		Preferences pref = Preferences.systemNodeForPackage(this.getClass());
		this.previousFontType = pref.getInt("FontType", FONT_TYPE_DEFAULT_INDEX);
		this.previousFontSize = pref.getInt("FontSize", FONT_SIZE_DEFAULT_INDEX);
		this.previousFontColor = pref.getInt("FontColor", FONT_COLOR_DEFAULT_INDEX);
		this.previousBackgroundColor = pref.getInt("BackgroundColor", BACGROUND_COLOR_DEFAULT_INDEX);
	}
}