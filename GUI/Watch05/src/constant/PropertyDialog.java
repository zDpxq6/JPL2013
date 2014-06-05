package constant;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import display.Display;

/**
 * ダイアログに関する設定を行うクラス
 */
public class PropertyDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	// フィールド
	private final SettingDataHolder mDataHolder;

	private JList mFontList;
	private JList mFontSizeList;

	private JList fontColorList;
	private JList backgroundColorList;

	private final Dimension mListSize = new Dimension(120, 120);

	public PropertyDialog(Display owner, SettingDataHolder holder) {
		super(owner);
		this.mDataHolder = holder;
		setResizable(false); // サイズ変更不可
		setSize(500, 450);
		setTitle(Const.TITLE);

		GridBagLayout layout= new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// 各項目の設定
		initFontList();
		initFontSizeList();
		initFontColorList();
		initBackgroundColorList();

		addLabel	(1, 0, Const.FONT_STYLE, layout, gridBagConstraints);
		addList	(1, 1, this.mFontList, layout, gridBagConstraints);

		addLabel	(2, 0, Const.FONT_SIZE, layout, gridBagConstraints);
		addList	(2, 1, this.mFontSizeList, layout, gridBagConstraints);

		addLabel	(0, 2, Const.FONT_COLOR, layout, gridBagConstraints);
		addList	(0, 3, this.fontColorList, layout, gridBagConstraints);

		addLabel	(1, 2, Const.BACKGROUND_COLOR, layout, gridBagConstraints);
		addList	(1, 3, this.backgroundColorList, layout, gridBagConstraints);

		// OKボタン
		JButton button = new JButton(Const.OK);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		addBtn(2, 4, button, layout, gridBagConstraints);
	}



	/**
	 * フォントスタイルの設定項目を初期化します
	 */
	private void initFontList() {
		String[] items = { Font.DIALOG, Font.DIALOG_INPUT, Font.MONOSPACED, Font.SANS_SERIF, Font.SERIF };
		this.mFontList = new JList(items);
		this.mFontList.setSelectedIndex(0);
		this.mFontList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				PropertyDialog.this.mDataHolder.setFont(PropertyDialog.this.mFontList.getSelectedValue().toString());
			}
		});
	}

	/**
	 * フォントサイズの設定項目を初期化します
	 */
	private void initFontSizeList() {
		Object[] items = {	Const.SMALL_FONT_SIZE, Const.MIDIUM_FONT_SIZE, Const.LARGE_FONT_SIZE };
		this.mFontSizeList = new JList(items);
		this.mFontSizeList.setSelectedIndex(0);
		this.mFontSizeList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selected = ((constant.FontSize)PropertyDialog.this.mFontSizeList.getSelectedValue()).getFontSize();
				PropertyDialog.this.mDataHolder.setFontSize(selected);
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
		this.fontColorList.setSelectedIndex(0);
		this.fontColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Color selected = ((constant.Colour)PropertyDialog.this.fontColorList.getSelectedValue()).getColour();
				PropertyDialog.this.mDataHolder.setFontColor(selected);
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
		this.backgroundColorList.setSelectedIndex(0);
		this.backgroundColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Color selected = ((constant.Colour)PropertyDialog.this.backgroundColorList.getSelectedValue()).getColour();
				PropertyDialog.this.mDataHolder.setBackgroundColor(selected);
			}
		});
	}

	/**
	 * 指定された文字列でJLabelを生成し、GridBagLayoutの指定された位置に追加します
	 */
	private void addLabel(int x, int y, String title, GridBagLayout gbl, GridBagConstraints gbc) {
		JLabel label = new JLabel(title);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(15, 0, 0, 0);
		gbl.setConstraints(label, gbc);
		add(label);
	}

	/**
	 * 指定されたJListをGridBagLayoutの指定された位置に追加します
	 */
	private void addList(int x, int y, JList list, GridBagLayout gbl, GridBagConstraints gbc) {
		JScrollPane sp = new JScrollPane(list);
		sp.setPreferredSize(this.mListSize);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 0, 0);
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
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 0, 0, 0);
		gbl.setConstraints(btn, gbc);
		add(btn);
	}
}