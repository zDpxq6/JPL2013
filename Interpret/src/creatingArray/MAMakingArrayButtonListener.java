package creatingArray;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;
import component.Models;


public class MAMakingArrayButtonListener implements ActionListener {

	private final Class<?> selectedClass;
	private final JCheckBox chb;
	private final int arrayLength;
	private final Models mdls;
	private final ExceptionArea ea;
	private final JComboBox[] 配列要素入力コンボボックスアレイ;


	public MAMakingArrayButtonListener (Class<?> selectedClass, JCheckBox chb, JComboBox[] 配列要素入力コンボボックスアレイ, Models mdls, ExceptionArea ea){
		this.selectedClass = selectedClass;
		this.chb = chb;
		this.配列要素入力コンボボックスアレイ = 配列要素入力コンボボックスアレイ;
		this.arrayLength = 配列要素入力コンボボックスアレイ.length;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(this.chb.isSelected()){
				String type = this.selectedClass.toString();
				if(Character.class.equals(type)){
					char[] 結果 = (char[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Character) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Byte.class.equals(this.selectedClass)){
					byte[] 結果 = (byte[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Byte) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Short.class.equals(this.selectedClass)){
					short[] 結果 = (short[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Short) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Integer.class.equals(this.selectedClass))/*Integer.class.equals(selectedClass.getClass())*/{
					int[] 結果 = (int[]) Array.newInstance(int.class, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						if(checkType(comboBox)){//Stringである
							結果[k] = Integer.valueOf((String) comboBox.getSelectedItem());
						}else{
							結果[k] = (Integer)comboBox.getSelectedItem();
						}
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Long.class.equals(this.selectedClass)){
					long[] 結果 = (long[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Long)comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Float.class.equals(this.selectedClass)){
					float[] 結果 = (float[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Float)comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Double.class.equals(this.selectedClass)){
					double[] 結果 = (double[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Double) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}else if(Boolean.class.equals(this.selectedClass)){
					boolean[] 結果 = (boolean[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.配列要素入力コンボボックスアレイ){
						結果[k] = (Boolean) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(結果);
					this.mdls.getComboBoxModel().addElement(結果);
				}
			}else {
				Object[] 結果= (Object[]) Array.newInstance(this.selectedClass, this.arrayLength);
				int k = 0;
				for(JComboBox element :this.配列要素入力コンボボックスアレイ){
					//System.out.println(element.getSelectedItem()+": " + element.getSelectedItem().getClass());
					結果[k] = element.getSelectedItem();
					k++;
				}
				this.mdls.getListModel().addElement(結果);
				this.mdls.getComboBoxModel().addElement(結果);
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		}finally{
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}

	private static boolean checkType(JComboBox comboBox){
		return comboBox.getSelectedItem().getClass() == String.class;
	}

}
