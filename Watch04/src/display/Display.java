package display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.prefs.Preferences;

import temp.MyPopupMenu;
import temp.PopUpListener;
import consta.Const;
import counter.Counter;
import counter.InterfaceForCounterClient;
import font.FontSize;

public class Display extends Window implements InterfaceForCounterClient{

	private static final long serialVersionUID = 1L;

	private final BufferedImage bufferedImage = new BufferedImage(Const.FRAME_WIDTH, Const.FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D graphics = (Graphics2D) this.bufferedImage.getGraphics();

	int fontSize = FontSize.LARGE.getValue();
	Color fontColor = Color.black;
	String Fonts = "Monospaced";
	Color backgroundColor = Color.red;

	private Preferences preferences;

	int stringWidth ;
	int stringHeight ;
	String message;
	FontMetrics fontMetrics;

	public Display() {
		super(new Frame(Const.TITLE));
		init();
	}

	public void init(){
		initAppearance();
		initProcess();
		new PositionChanger(this);
		new PopUpListener(this, new MyPopupMenu());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing( WindowEvent e) {
				save();
				System.exit(0);
			}
		});
	}

	private void initAppearance(){
		this.setVisible(true);
		this.setSize( Const.FRAME_WIDTH, Const.FRAME_HEIGHT );
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.graphics = (Graphics2D) this.bufferedImage.getGraphics();
		this.setLocation(load());
	}

	private void initProcess(){
		Thread thread = new Thread(new Counter(this));
		thread.start();
	}

	@Override
	public void paint( Graphics graphics) {
		this.graphics.setColor(this.fontColor);
		this.graphics.setFont(new Font(this.Fonts, Font.PLAIN, this.fontSize));
		this.fontMetrics = this.graphics.getFontMetrics();
		this.message = String.format("%02d:%02d:%02d", Watch.getHour(), Watch.getMinute(), Watch.getSecond());
		this.stringWidth = this.fontMetrics.stringWidth(this.message);
		this.stringHeight = this.fontMetrics.getHeight();
		setSize(this.stringWidth * 2, this.stringHeight * 2);
		this.graphics.setBackground(this.backgroundColor);
		this.graphics.clearRect(0, 0, this.stringWidth * 2, this.stringHeight * 2);
		this.graphics.drawString(this.message,
				(this.stringWidth * 2 - this.stringWidth) / 2,
				(this.stringHeight * 2 + this.stringHeight) / 2);
		graphics.drawImage(this.bufferedImage, 0, 0, this);
	}

	@Override
	public void update( Graphics graphics) {
		paint(graphics);
	}

	@Override
	public void execute() {
		repaint();
	}
	public Point load() {
		this.preferences = Preferences.userRoot().node("Display");
		return new Point(this.preferences.getInt("window_x", 0), this.preferences.getInt("window_y", 0));
	}

	public void save() {
		this.preferences.putInt("window_x", this.getLocation().x);
		this.preferences.putInt("window_y", this.getLocation().y);
	}

}
