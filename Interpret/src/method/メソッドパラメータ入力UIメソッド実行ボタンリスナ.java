package method;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JComboBox;

import component.ExceptionArea;
import component.Models;


public class メソッドパラメータ入力UIメソッド実行ボタンリスナ implements ActionListener {

	private final Method selectedMethod;
	private final JComboBox[] メソッドパラメータ入力コンボボックスアレイ;
	private final Models mdls;
	private final ExceptionArea ea;
	private final Object obj;

	public メソッドパラメータ入力UIメソッド実行ボタンリスナ(Method selectedMethod, Object obj, JComboBox[] メソッドパラメータ入力コンボボックスアレイ, Models mdls,ExceptionArea ea) {
		this.selectedMethod = selectedMethod;
		this.メソッドパラメータ入力コンボボックスアレイ = メソッドパラメータ入力コンボボックスアレイ;
		this.mdls = mdls;
		this.ea = ea;
		this.obj = obj;
		System.out.println("ここまでOK");
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
		Class<?>[] methodParameterTypeArray = this.selectedMethod.getParameterTypes();
		Object[] parameterArray = new Object[methodParameterTypeArray.length];
		Object tmp = null;
		int i = 0;
		for(JComboBox comboBox :this.メソッドパラメータ入力コンボボックスアレイ){
			String type = methodParameterTypeArray[i].toString();
			if("char".equals(type)){
				char[] charArray = ((String) comboBox.getSelectedItem()).toCharArray();
				tmp = charArray[0];
			}else if("byte".equals(type)){
				tmp = Byte.valueOf((String) comboBox.getSelectedItem());
			}else if("short".equals(type)){
				tmp = Short.valueOf((String) comboBox.getSelectedItem());
			}else if("int".equals(type)){
				System.out.println("型: " + comboBox.getSelectedItem().getClass());
				tmp = Integer.valueOf((String) comboBox.getSelectedItem());
			}else if("long".equals(type)){
				tmp = Long.valueOf((String) comboBox.getSelectedItem());
			}else if("float".equals(type)){
				tmp = Float.valueOf((String) comboBox.getSelectedItem());
			}else if("double".equals(type)){
				tmp = Double.valueOf((String) comboBox.getSelectedItem());
			}else if("boolean".equals(type)){
				tmp = Boolean.valueOf((String) comboBox.getSelectedItem());
			} else {
				tmp = comboBox.getSelectedItem();
			}
			parameterArray[i] = tmp;
			i++;
		}
			//条件分岐が入る(void,primitive以外は追加)
			Object createdInstance = this.selectedMethod.invoke(this.obj, parameterArray);
			if(createdInstance instanceof Object){
				this.mdls.getListModel().addElement(createdInstance);
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}


}
