package display;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import constant.Constant;
import constant.PropertyDialog;
import constant.SettingDataHolder;
import counter.Counter;
import counter.InterfaceForCounterClient;

public class Display extends Frame implements InterfaceForCounterClient {

	private static final long serialVersionUID = 1L;

	private final BufferedImage bufferedImage = new BufferedImage(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D graphics = (Graphics2D) this.bufferedImage.getGraphics();

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setFontType(String fontType) {
		this.fontType = fontType;
	}

	int fontSize;
	Color fontColor;
	String fontType;
	Color backgroundColor;

	int stringWidth;
	int stringHeight;
	String message;
	FontMetrics fontMetrics;

	private Dialog dialog;

	public Display() {
		super(Constant.TITLE);
		init();
	}

	private PositionChanger positionChanger;

	public void init() {
		initAppearance();
		initProcess();
		System.out.println("ここまで");
		initMenu();
		this.positionChanger = new PositionChanger(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Display.this.positionChanger.save();
				((PropertyDialog) Display.this.dialog).save();
				System.exit(0);
			}
		});
	}

	private void initAppearance() {
		this.setVisible(true);
		this.setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.graphics = (Graphics2D) this.bufferedImage.getGraphics();
		this.dialog = new PropertyDialog(this, new SettingDataHolder(this));
		((PropertyDialog) this.dialog).load();
		((PropertyDialog) this.dialog).refresh();
	}

	private void initMenu() {

		MenuItem properties = new MenuItem(Constant.PROPERTIES);
		properties.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.this.dialog.setVisible(true);
			}
		});

		Menu menu = new Menu(Constant.MENU);
		menu.add(properties);

		MenuBar menuBar = new MenuBar();
		menuBar.add(menu);
		this.setMenuBar(menuBar);
	}

	private void initProcess() {
		Thread thread = new Thread(new Counter(this));
		thread.start();
	}

	@Override
	public void paint(Graphics graphics) {
		this.graphics.setColor(this.fontColor);
		this.graphics.setFont(new Font(this.fontType, Font.PLAIN, this.fontSize));
		this.fontMetrics = this.graphics.getFontMetrics();
		this.message = String.format("%02d:%02d:%02d", Watch.getHour(), Watch.getMinute(), Watch.getSecond());
		this.stringWidth = this.fontMetrics.stringWidth(this.message);
		this.stringHeight = this.fontMetrics.getHeight();
		setSize(this.stringWidth * 2, this.stringHeight * 2);
		this.graphics.setBackground(this.backgroundColor);
		this.graphics.clearRect(0, 0, this.stringWidth * 2, this.stringHeight * 2);
		this.graphics.drawString(this.message, (this.stringWidth * 2 - this.stringWidth) / 2, (this.stringHeight * 2 + this.stringHeight) / 2);
		graphics.drawImage(this.bufferedImage, 0, 0, this);
	}

	@Override
	public void update(Graphics graphics) {
		paint(graphics);
	}

	@Override
	public void execute() {
		repaint();
	}

}
