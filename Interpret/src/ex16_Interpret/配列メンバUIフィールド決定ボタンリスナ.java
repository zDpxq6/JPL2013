package ex16_Interpret;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;


public class 配列メンバUIフィールド決定ボタンリスナ implements ActionListener {
	private final Object selectedInstance;
	private final ExceptionArea ea;
	private final JComboBox[] 配列要素編集コンボボックスアレイ;
//	private final Class clz;

	public 配列メンバUIフィールド決定ボタンリスナ(Object obj, JComboBox[] コンボボックスアレイ, ExceptionArea ea){
		this.配列要素編集コンボボックスアレイ = コンボボックスアレイ;
		this.selectedInstance = obj;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
//			Class<?>[] フィールド型配列 = new Class<?>[this.配列要素編集コンボボックスアレイ.length];
			int i = 0;
			for(JComboBox comboBox :this.配列要素編集コンボボックスアレイ){
				Array.set(this.selectedInstance, i++, comboBox.getSelectedItem());
//				i++;
////				フィールド型配列[i] = clz;
////
////				int mod = フィールド型配列[i].getModifiers();
//
////				if(!Modifier.isStatic(mod) && !Modifier.isFinal(mod)){
//					if(Character.TYPE.equals(this.clz)){
//						((Object)Array.get(this.selectedInstance, i)).setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setChar(this.selectedInstance, (Character)comboBox.getSelectedItem());
//					}else if(Byte.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setByte(this.selectedInstance, (Byte)comboBox.getSelectedItem());
//					}else if(Short.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setShort(this.selectedInstance, (Short)comboBox.getSelectedItem());
//					}else if(Integer.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setInt(this.selectedInstance, (Integer) comboBox.getSelectedItem());
//					}else if(Long.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setLong(this.selectedInstance, (Long) comboBox.getSelectedItem());
//					}else if(Float.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setFloat(this.selectedInstance, (Float)comboBox.getSelectedItem());
//					}else if(Double.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setDouble(this.selectedInstance, (Double)comboBox.getSelectedItem());
//					}else if(Boolean.TYPE.equals(this.clz)){
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].setBoolean(this.selectedInstance, (Boolean) comboBox.getSelectedItem());
//					} else {
//						this.配列要素編集コンボボックスアレイ[i].setAccessible(true);
//						this.配列要素編集コンボボックスアレイ[i].set(this.selectedInstance,comboBox.getSelectedItem());
//					}
////				}
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		} finally {
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}
}
