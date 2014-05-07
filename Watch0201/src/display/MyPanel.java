package display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import consta.Const;
import font.FontSize;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private final BufferedImage bufferedImage = new BufferedImage(Const.FRAME_WIDTH, Const.FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D graphics = (Graphics2D) this.bufferedImage.getGraphics();

	int fontSize = FontSize.LARGE.getValue();
	Color fontColor = Color.black;
	String Fonts = "Monospaced";
	Color backgroundColor = Color.red;

	int stringWidth ;
	int stringHeight ;
	String message;
	FontMetrics fontMetrics;

	public MyPanel() {
		super();
		initAppearance();
	}

	private void initAppearance(){
		this.setVisible(true);
		this.setSize( Const.FRAME_WIDTH, Const.FRAME_HEIGHT );
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.graphics = (Graphics2D) this.bufferedImage.getGraphics();
	}

	@Override
	public void paintComponent( Graphics graphics) {
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
}
