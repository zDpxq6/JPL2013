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

import consta.Const;
import consta.FontSize;
import consta.PropertyDialog;
import consta.SettingDataHolder;
import counter.Counter;
import counter.InterfaceForCounterClient;

public class Display extends Frame implements InterfaceForCounterClient {

	private static final long serialVersionUID = 1L;

	private final BufferedImage bufferedImage = new BufferedImage(Const.FRAME_WIDTH, Const.FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D graphics = (Graphics2D) this.bufferedImage.getGraphics();

	int fontSize = FontSize.LARGE_FONT.getFontSize();

	public void setFontSize(int fontSize){
		this.fontSize = fontSize;
	}
	Color fontColor = Color.black;

	String Fonts = "Monospaced";
	Color backgroundColor = Color.red;

	int stringWidth;
	int stringHeight;
	String message;
	FontMetrics fontMetrics;

	private Dialog dialog;

	public Display() {
		super(Const.TITLE);
		init();
	}

	public void init() {
		initAppearance();
		initProcess();
		initMenu();
		new PositionChanger(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void initAppearance() {
		this.setVisible(true);
		this.setSize(Const.FRAME_WIDTH, Const.FRAME_HEIGHT);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.graphics = (Graphics2D) this.bufferedImage.getGraphics();
		this.dialog = new PropertyDialog(this, new SettingDataHolder(this));
	}

	private void initMenu() {

		MenuItem properties = new MenuItem(Const.PROPERTIES);
		properties.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.this.dialog.setVisible(true);
			}
		});

		Menu menu = new Menu(Const.MENU);
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
		this.graphics.setFont(new Font(this.Fonts, Font.PLAIN, this.fontSize));
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

	public void setFontColor(Color test){
		this.fontColor= test;
	}

	public void setBackgroundColor(Color test){
		this.backgroundColor= test;
	}

}
