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

import temp.MyListCellRenderer;
import display.Display;
import enumeration.Colour;

/**
 * ダイアログに関する設定を行うクラス
 */
public class PropertyDialog extends JDialog {

	private static final int DIALOG_WIDTH = 240;
	private static final int DIALOG_HIGHT = 240;

	private static final int DIALOG_ELEMENT_HIGHT = 120;

	private static final long serialVersionUID = 1L;

	private static final int DIALOG_ELEMENT_WIDTH = 120;

	private final SettingDataHolder dataHolder;

	private JList fontTypeList;
	private JList fontSizeList;

	private JList fontColorList;
	private JList backgroundColorList;

	private final Dimension listSize = new Dimension(DIALOG_ELEMENT_HIGHT, DIALOG_ELEMENT_WIDTH);

	public PropertyDialog(Display owner, SettingDataHolder holder) {
		super(owner);
		this.dataHolder = holder;
		setResizable(false); // サイズ変更不可
		setSize(500,500);
		setTitle(Const.TITLE);

		GridBagLayout layout= new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// 各項目の設定
		initFontList();
		initFontSizeList();
		initFontColorList();
		initBackgroundColorList();

		addLabel	(0, 0, Const.FONT, layout, gridBagConstraints);
		addList	(0, 1, this.fontTypeList, layout, gridBagConstraints);

		addLabel	(1, 0, Const.FONT_SIZE, layout, gridBagConstraints);
		addList	(1, 1, this.fontSizeList, layout, gridBagConstraints);

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
		this.fontTypeList = new JList(items);
		this.fontTypeList.setSelectedIndex(0);
		this.fontTypeList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				PropertyDialog.this.dataHolder.setFont(PropertyDialog.this.fontTypeList.getSelectedValue().toString());
			}
		});
	}

	/**
	 * フォントサイズの設定項目を初期化します
	 */
	private void initFontSizeList() {
		Object[] items = {	Const.SMALL_FONT_SIZE, Const.MIDIUM_FONT_SIZE, Const.LARGE_FONT_SIZE };
		this.fontSizeList = new JList(items);
		this.fontSizeList.setSelectedIndex(0);
		this.fontSizeList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int i = (Integer) PropertyDialog.this.fontSizeList.getSelectedValue();
				PropertyDialog.this.dataHolder.setFontSize(i);
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
		this.fontColorList.setSelectedIndex(2);
		this.fontColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				@SuppressWarnings("unchecked")
				Color selected = ((EnumInterfaceforClient<Color>)PropertyDialog.this.fontColorList.getSelectedValue()).getValue();
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
		this.backgroundColorList.setSelectedIndex(1);
		this.backgroundColorList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Color selected = ((enumeration.Colour)PropertyDialog.this.backgroundColorList.getSelectedValue()).getValue();
				PropertyDialog.this.dataHolder.setBackgroundColor(selected);
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
		sp.setPreferredSize(this.listSize);
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