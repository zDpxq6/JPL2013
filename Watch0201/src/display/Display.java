package display;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import consta.Const;
import counter.Counter;
import counter.InterfaceForCounterClient;

public class Display extends JFrame implements InterfaceForCounterClient{

	private static final long serialVersionUID = 1L;

	private final MyPanel panel = new MyPanel();

	public Display() {
		super(Const.TITLE);
		init();
	}

	public void init(){
		initAppearance();
		initProcess();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing( WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void initAppearance(){
		this.setVisible(true);
		this.setSize( Const.FRAME_WIDTH, Const.FRAME_HEIGHT );
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new MyPanel());
	}

	private void initProcess(){
		Thread thread = new Thread(new Counter(this));
		thread.start();
	}

	@Override
	public void paint( Graphics graphics) {
		this.panel.paintComponent(graphics);
	}

	@Override
	public void update( Graphics graphics) {
		paint(graphics);
	}

	@Override
	public void execute() {
		repaint();
	}

}
