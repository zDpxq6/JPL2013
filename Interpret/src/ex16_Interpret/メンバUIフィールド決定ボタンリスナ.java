package ex16_Interpret;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;


public class メンバUIフィールド決定ボタンリスナ implements ActionListener {
	private final Object selectedInstance;
	private final ExceptionArea ea;
	private final JComboBox[] フィールド入力コンボボックスアレイ;
	private final Field[] フィールド配列;

	public メンバUIフィールド決定ボタンリスナ(Object selectedInstance, JComboBox[] フィールド入力コンボボックスアレイ, ExceptionArea ea) {
		this.selectedInstance = selectedInstance;
		this.フィールド配列 = selectedInstance.getClass().getDeclaredFields();
		this.フィールド入力コンボボックスアレイ = フィールド入力コンボボックスアレイ;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			Class<?>[] フィールド型配列 = new Class<?>[this.フィールド入力コンボボックスアレイ.length];
			int i = -1;
			for(JComboBox comboBox :this.フィールド入力コンボボックスアレイ){
				i++;
				フィールド型配列[i] = this.フィールド配列[i].getType();

				int mod = this.フィールド配列[i].getModifiers();

				if(Modifier.isStatic(mod)){
					System.out.print("static ");
					if(Modifier.isFinal(mod)){
						System.out.println("final");
					}
				}else {
					if(Character.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setChar(this.selectedInstance, (Character)comboBox.getSelectedItem());
					}else if(Byte.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setByte(this.selectedInstance, (Byte)comboBox.getSelectedItem());
					}else if(Short.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setShort(this.selectedInstance, (Short)comboBox.getSelectedItem());
					}else if(Integer.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setInt(this.selectedInstance, (Integer) comboBox.getSelectedItem());
					}else if(Long.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setLong(this.selectedInstance, (Long) comboBox.getSelectedItem());
					}else if(Float.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setFloat(this.selectedInstance, (Float)comboBox.getSelectedItem());
					}else if(Double.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setDouble(this.selectedInstance, (Double)comboBox.getSelectedItem());
					}else if(Boolean.TYPE.equals(フィールド型配列[i])){
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].setBoolean(this.selectedInstance, (Boolean) comboBox.getSelectedItem());
					} else {
						this.フィールド配列[i].setAccessible(true);
						this.フィールド配列[i].set(this.selectedInstance,comboBox.getSelectedItem());
					}
				}
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		} finally {
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}
}
