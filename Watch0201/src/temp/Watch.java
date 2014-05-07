package temp;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import consta.Const;
import display.PositionChanger;
import font.FontSize;

public class Watch extends Window implements ActionListener, ItemListener, Runnable {

	private static final long serialVersionUID = 1L;

	private static BufferedImage bufferedImage;
	private static Graphics2D graphics;

	static Color backgroundColor = Color.red;

	static int stringWidth ;
	static int stringHeight ;
	static String message;

	static void setFontSize(int size){
		fontSize = size;
	}

	static void setFontColor(Color color){
		fontColor = color;
	}

	static void setFont(String font){
		Fonts = font;
	}

	static void setBackgroundColor(Color color){
		backgroundColor = color;
	}

	static Watch watch = new Watch() {
		private static final long serialVersionUID = 1L;
	};

	static Thread thread = new Thread(watch);

	static FontMetrics fontMetrics;

//	public static void main( String[] args) {
//		watch.setVisible(true);
//		watch.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing( WindowEvent e) {
//				System.exit(0);
//			}
//		});
//		thread.start();
//	}


	MyPopupMenu myPopupMenu = new MyPopupMenu();
	public Watch( ) {
		super(new Frame("Watch02"));
		new PositionChanger(this,this.myPopupMenu);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(Const.FRAME_WIDTH, Const.FRAME_HEIGHT);
		bufferedImage = new BufferedImage(Const.FRAME_WIDTH, Const.FRAME_HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
		add(this.myPopupMenu.popup);
	}

	@Override
	public void actionPerformed( ActionEvent e) {
		if (e.getActionCommand() == "Large") {
			fontSize = FontSize.LARGE.getValue();
		}
		if (e.getActionCommand() == "Small") {
			fontSize = FontSize.SMALL.getValue();
		}

		if (e.getActionCommand() == "Dialog") {
			Fonts = "Dialog";
		}
		if (e.getActionCommand() == "DialogInput") {
			Fonts = "Dialog";
		}
		if (e.getActionCommand() == "Monospaced") {
			Fonts = "Monospaced";
		}
		if (e.getActionCommand() == "Serif") {
			Fonts = "Serif";
		}
		if (e.getActionCommand() == "SanSerif") {
			Fonts = "SanSerif";
		}
		if (e.getActionCommand() == "Symbol") {
			Fonts = "Symbol";
		}

		if (e.getActionCommand() == "Red") {
			backgroundColor = Color.red;
		}
		if (e.getActionCommand() == "Blue") {
			backgroundColor = Color.blue;
		}
		if (e.getActionCommand() == "Green") {
			backgroundColor = Color.green;
		}

		if (e.getActionCommand() == "Black") {
			fontColor = Color.black;
		}
		if (e.getActionCommand() == "White") {
			fontColor = Color.white;
		}
	}

//	@Override
//	public void paint( Graphics g) {
//		graphics.setColor(fontColor);
//		graphics.setFont(new Font(Fonts, Font.PLAIN, fontSize));
//		fontMetrics = graphics.getFontMetrics();
//		message = String.format("%02d:%02d:%02d", hour, minute, second);
//		stringWidth = fontMetrics.stringWidth(message);
//		stringHeight = fontMetrics.getHeight();
//		watch.setSize(stringWidth * 2, stringHeight * 2);
//		graphics.setBackground(backgroundColor);
//		graphics.clearRect(0, 0, stringWidth * 2, stringHeight * 2);
//		graphics.drawString(message,
//				(stringWidth * 2 - stringWidth) / 2,
//				(stringHeight * 2 + stringHeight) / 2);
//		g.drawImage(bufferedImage, 0, 0, this);
//	}

//	@Override
//	public void update( Graphics g) {
//		paint(g);
//	}
//
//
//	@Override
//	public void itemStateChanged( ItemEvent e) {
//		// TODO Auto-generated method stub
//
//	}

}
