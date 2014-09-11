package ex22_15;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Calculator.Calculator;
import CalculatorImpl.AdditionCalculator;
import CalculatorImpl.DivisionCalculator;
import CalculatorImpl.ModCalculator;
import CalculatorImpl.MultiplicationCalculator;
import CalculatorImpl.SubtractionCalculator;

@SuppressWarnings("serial")
public class CalculatorFrame extends Frame implements ActionListener {
	private static final String BLANK = "";
	private static final String ZERO = "0";
	private static final String DECIMAL_POINT = ".";
	private static final int FRAME_HIGHT = 300;
	private static final int FRAME_WIDTH = 150;
	private static final String TITLE = "Calculator";
	private static final LayoutManager LAYOUT2_1 = new GridLayout(2, 1);
	private static final LayoutManager LAYOUT1_2 = new GridLayout(1, 2);

	Calculator calcurater;
	private String operand1;
	private String operand2;
	private StringBuilder inputtingValue = new StringBuilder();
	private boolean isDecimal = false;

	TextField display = new TextField();
	private final Button BUTTON_CLEAR = new Button("C");

	private final Button BUTTON_RESIDUE = new Button("%");
	private final Button BUTTON_DIVISION = new Button("÷");
	private final Button BUTTON_MULTIPLICTION = new Button("×");
	private final Button BUTTON_SUBTRACTION = new Button("-");
	private final Button BUTTON_ADDITION = new Button("+");

	private final Button BUTTON_EQUAL = new Button("=");

	private final Button BUTTON_DECIMAL = new OperandButton(DECIMAL_POINT);

	private final Button BUTTON_9 = new OperandButton("9");
	private final Button BUTTON_8 = new OperandButton("8");
	private final Button BUTTON_7 = new OperandButton("7");
	private final Button BUTTON_6 = new OperandButton("6");
	private final Button BUTTON_5 = new OperandButton("5");
	private final Button BUTTON_4 = new OperandButton("4");
	private final Button BUTTON_3 = new OperandButton("3");
	private final Button BUTTON_2 = new OperandButton("2");
	private final Button BUTTON_1 = new OperandButton("1");
	private final Button BUTTON_0 = new OperandButton(ZERO);

	public static void main(String[] args) {
		new CalculatorFrame(TITLE);
	}

	private final Panel createTopPanel(){
		//パネルレイアウト
		//[  display ]
		//[C][%][÷][×]
		Panel result = new Panel(LAYOUT2_1);
		result.add(this.display);
		result.add(createCRDMButtonsPanel());
		return result;
	}

	private final Panel createCRDMButtonsPanel(){
		//C, %, ÷, ×のパネル
		Panel result = new Panel(new GridLayout(1, 4));
		result.add(this.BUTTON_CLEAR);
		result.add(this.BUTTON_RESIDUE);
		result.add(this.BUTTON_DIVISION);
		result.add(this.BUTTON_MULTIPLICTION);
		return result;
	}

	private final Panel createMediumPanel(){
		//パネルレイアウト
		//[7][8][9][-]
		//[4][5][6][+]
		Panel result = new Panel(new GridLayout(2, 4));
		result.add(this.BUTTON_7);
		result.add(this.BUTTON_8);
		result.add(this.BUTTON_9);
		result.add(this.BUTTON_SUBTRACTION);
		result.add(this.BUTTON_4);
		result.add(this.BUTTON_5);
		result.add(this.BUTTON_6);
		result.add(this.BUTTON_ADDITION);
		return result;
	}

	private final Panel createRightPanel(){
		//パネルレイアウト
		//[3][=]
		//[.][=]
		Panel result = new Panel();
		result.setLayout(LAYOUT1_2);

		Panel threeDecimalPanel = new Panel(LAYOUT2_1);
		threeDecimalPanel.add(this.BUTTON_3);
		threeDecimalPanel.add(this.BUTTON_DECIMAL);

		result.add(threeDecimalPanel);
		result.add(this.BUTTON_EQUAL);
		return result;
	}

	private final Panel createLeftPanel(){
		//パネルレイアウト
		//[1][2]
		//[ 0  ]
		Panel result = new Panel(LAYOUT2_1);

		Panel oneTwoPanel = new Panel(LAYOUT1_2);
		oneTwoPanel.add(this.BUTTON_1);
		oneTwoPanel.add(this.BUTTON_2);

		result.add(oneTwoPanel);
		result.add(this.BUTTON_0);
		return result;
	}

	private final Panel createBottomPanel(){
		//パネルレイアウト
		//[left ][right]
		//[panel][panel]
		Panel result = new Panel(LAYOUT1_2);

		Panel leftPanel = createLeftPanel();

		Panel rightPanel = createRightPanel();

		result.add(leftPanel);
		result.add(rightPanel);
		return result;
	}

	public CalculatorFrame(String title) {
		super(title);
		this.setLayout(new GridLayout(3, 1));

		Panel topPanel = createTopPanel();
		this.add(topPanel);

		Panel mediumPanel = createMediumPanel();
		this.add(mediumPanel);

		Panel bottomPanel = createBottomPanel();
		this.add(bottomPanel);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		addListeners(this);

		setSize(FRAME_WIDTH, FRAME_HIGHT);
		setVisible(true);
	}

	private final void addListeners(ActionListener i) {
		this.BUTTON_CLEAR.addActionListener(i);
		this.BUTTON_RESIDUE.addActionListener(i);
		this.BUTTON_DIVISION.addActionListener(i);
		this.BUTTON_MULTIPLICTION.addActionListener(i);
		this.BUTTON_SUBTRACTION.addActionListener(i);
		this.BUTTON_ADDITION.addActionListener(i);
		this.BUTTON_EQUAL.addActionListener(i);
		this.BUTTON_DECIMAL.addActionListener(i);
		this.BUTTON_9.addActionListener(i);
		this.BUTTON_8.addActionListener(i);
		this.BUTTON_7.addActionListener(i);
		this.BUTTON_6.addActionListener(i);
		this.BUTTON_5.addActionListener(i);
		this.BUTTON_4.addActionListener(i);
		this.BUTTON_3.addActionListener(i);
		this.BUTTON_2.addActionListener(i);
		this.BUTTON_1.addActionListener(i);
		this.BUTTON_0.addActionListener(i);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = null;
		if (e.getSource() == this.BUTTON_CLEAR) {
			System.out.println("C is pushed");
			resetText();
			this.display.setText(BLANK);
			this.operand1 = BLANK;
			this.operand2 = BLANK;
		} else if (e.getSource() == this.BUTTON_RESIDUE) {
			System.out.println("Mod is pushed");
			this.calcurater = test(ModCalculator.class,"getInstance");//ModCalculator.getInstance();
			this.operand1 = this.inputtingValue.toString();
			this.inputtingValue = new StringBuilder();
		} else if (e.getSource() == this.BUTTON_DIVISION) {
			System.out.println("÷ is pushed");
			this.calcurater = DivisionCalculator.getInstance();
			this.operand1 = this.inputtingValue.toString();
			this.inputtingValue = new StringBuilder();
		} else if (e.getSource() == this.BUTTON_MULTIPLICTION) {
			System.out.println("× is pushed");
			this.calcurater = MultiplicationCalculator.getInstance();
			this.operand1 = this.inputtingValue.toString();
			this.inputtingValue = new StringBuilder();
		} else if (e.getSource() == this.BUTTON_SUBTRACTION) {
			System.out.println("- is pushed");
			this.calcurater = SubtractionCalculator.getInstance();
			this.operand1 = this.inputtingValue.toString();
			this.inputtingValue = new StringBuilder();
		} else if (e.getSource() == this.BUTTON_ADDITION) {
			System.out.println("+ is pushed");
			this.calcurater = AdditionCalculator.getInstance();
			this.operand1 = this.inputtingValue.toString();
			this.inputtingValue = new StringBuilder();
		} else if (e.getSource() == this.BUTTON_EQUAL) {
			System.out.println("= is pushed");
			this.operand2 = this.inputtingValue.toString();
			String value1 = this.calcurater.calculate(this.operand1, this.operand2);
			if (value1.endsWith(".0")) {
				value1 = value1.substring(0, value1.length() - 2);
			}
			if (value1.contains(DECIMAL_POINT)) {
				this.isDecimal = true;
			}
			this.inputtingValue = new StringBuilder(value1);
			this.display.setText(value1);
		} else if ((obj = e.getSource()) instanceof OperandButton) {
			this.display.setText(createDisplayString(((OperandButton) obj).getValue()));
		} else {
			System.out.println("Error");
		}
	}

	private void resetText() {
		this.inputtingValue = new StringBuilder();
		this.isDecimal = false;
	}

	private String createDisplayString(String input) {
		if (DECIMAL_POINT.equals(input)) {
			if (this.isDecimal == false) {
				this.isDecimal = true;
			} else {
				return this.inputtingValue.toString();
			}
		}
		//
		if (ZERO.equals(this.inputtingValue.toString()) && DECIMAL_POINT.equals(input)==false) {
			resetText();
		}
		//
		if (BLANK.equals(this.inputtingValue.toString()) && DECIMAL_POINT.equals(input)) {
			this.inputtingValue.append(ZERO);
		}
		this.inputtingValue.append(input);
		return this.inputtingValue.toString();
	}

	private static Calculator test(Class clazz, String methodName){
		Method method;
		try {
			method = clazz.getMethod(methodName, null);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}

		Calculator result; //戻り値
		try {
			result = (Calculator) method.invoke(null, null);
			return result;
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
