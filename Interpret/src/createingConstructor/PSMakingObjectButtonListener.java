package createingConstructor;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;
import component.Models;


public class PSMakingObjectButtonListener implements ActionListener {

	private final Constructor<?> selectedConstructor;
	private final JComboBox[] コンストラクタパラメータ入力コンボボックスアレイ;
	private final Models mdls;
	private final ExceptionArea ea;
	private static final String CLASS_NAME = PSMakingObjectButtonListener.class.toString();

	public PSMakingObjectButtonListener(Constructor<?> selectedConstructor, Models mdls,JComboBox[] コンストラクタパラメータ入力コンボボックスアレイ, ExceptionArea ea){
		this.selectedConstructor = selectedConstructor;
		this.コンストラクタパラメータ入力コンボボックスアレイ = コンストラクタパラメータ入力コンボボックスアレイ;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			Class<?>[] 選択したコンストラクタのパラメータの型配列 = this.selectedConstructor.getParameterTypes();
			Object[] 選択したコンストラクタのパラメータ配列 = new Object[選択したコンストラクタのパラメータの型配列.length];

			int i = 0;
			for(JComboBox comboBox :this.コンストラクタパラメータ入力コンボボックスアレイ){
				Class<?> type = 選択したコンストラクタのパラメータの型配列[i];	//求められる型
				Object コンボボックスに入力したパラメータの値= null;
				Object 取得値 = null;
				if(comboBox.getSelectedIndex() < 0){
					取得値 = comboBox.getSelectedItem();
					System.out.println("取得値の型: ");
					if(type == Character.TYPE || type == Character.class){//求められる型がプリミティブかラッパなら
						char[] charArray = ((String) 取得値).toCharArray();
						コンボボックスに入力したパラメータの値 = charArray[0];
					}else if(type == Byte.TYPE || type == Byte.class){//求められる型がプリミティブかラッパなら
						コンボボックスに入力したパラメータの値 = Byte.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Short.TYPE || type == Short.class){
						コンボボックスに入力したパラメータの値 = Short.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Integer.TYPE || type == Integer.class){// || type == Integer.class.toString()){
						System.out.println(comboBox.getSelectedItem().getClass());
						コンボボックスに入力したパラメータの値 = Integer.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Long.TYPE || type == Long.class){
						System.out.println(comboBox.getSelectedItem().getClass());
						コンボボックスに入力したパラメータの値 = Long.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Float.TYPE || type == Float.class){
						コンボボックスに入力したパラメータの値 = Float.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Double.TYPE || type == Double.class){
						コンボボックスに入力したパラメータの値 = Double.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Boolean.TYPE || type == Boolean.class){
						コンボボックスに入力したパラメータの値 = Boolean.valueOf((String) comboBox.getSelectedItem());
					} else {
						コンボボックスに入力したパラメータの値 = comboBox.getSelectedItem();
					}
				} else {
					コンボボックスに入力したパラメータの値 = comboBox.getSelectedItem();
				}
				選択したコンストラクタのパラメータ配列[i] = コンボボックスに入力したパラメータの値;
				i++;
			}
			Object createdInstance = this.selectedConstructor.newInstance(選択したコンストラクタのパラメータ配列);
			this.mdls.addElement(createdInstance);
		} catch (Throwable e) {
			this.ea.writeException(e);
		}finally{
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}

	private static boolean 適当な名前(String type, Class<?> p2){
		boolean result = true;
		if(type == "boolean" || p2 == boolean.class && p2 == Boolean.class/*type == "boolean" && p2 == boolean.class || type == "boolean" && p2 == Boolean.class*/){
			result = false;
		} else if(type == "char" && p2 == char.class || type == "char" && p2 == Character.class){
			result = false;
		} else if(type == "byte" && p2 == byte.class || type == "byte" && p2 == Byte.class){
			result = false;
		} else if(type == "short" && p2 == short.class || type == "short" && p2 == Short.class){
			result = false;
		} else if(type == "int" && p2 == int.class || type == "int" && p2 == Integer.class){
			result = false;
		} else if(type == "long" && p2 == long.class || type == "long" && p2 == Long.class){
			result = false;
		} else if(type == "float" && p2 == float.class || type == "float" && p2 == Float.class){
			result = false;
		} else if(type == "double" && p2 == double.class || type == "double" && p2 == Double.class){
			result = false;
		}

		else if(type == "Boolean" && p2 == boolean.class || type == "Boolean" && p2 == Boolean.class){
			result = false;
		} else if(type == "Character" && p2 == char.class || type == "Character" && p2 == Character.class){
			result = false;
		} else if(type == "Byte" && p2 == byte.class || type == "Byte" && p2 == Byte.class){
			result = false;
		} else if(type == "Short" && p2 == short.class || type == "Short" && p2 == Short.class){
			result = false;
		} else if(type == "Integer" && p2 == int.class || type == "Integer" && p2 == Integer.class){
			result = false;
		} else if(type == "Long" && p2 == long.class || type == "Long" && p2 == Long.class){
			result = false;
		} else if(type == "Float" && p2 == float.class || type == "Float" && p2 == Float.class){
			result = false;
		} else if(type == "Double" && p2 == double.class || type == "Double" && p2 == Double.class){
			result = false;
		}
		return result;
	}

}
