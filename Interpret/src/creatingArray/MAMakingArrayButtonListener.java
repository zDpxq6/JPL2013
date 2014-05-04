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
	private final JComboBox[] �z��v�f���̓R���{�{�b�N�X�A���C;


	public MAMakingArrayButtonListener (Class<?> selectedClass, JCheckBox chb, JComboBox[] �z��v�f���̓R���{�{�b�N�X�A���C, Models mdls, ExceptionArea ea){
		this.selectedClass = selectedClass;
		this.chb = chb;
		this.�z��v�f���̓R���{�{�b�N�X�A���C = �z��v�f���̓R���{�{�b�N�X�A���C;
		this.arrayLength = �z��v�f���̓R���{�{�b�N�X�A���C.length;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(this.chb.isSelected()){
				String type = this.selectedClass.toString();
				if(Character.class.equals(type)){
					char[] ���� = (char[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Character) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Byte.class.equals(this.selectedClass)){
					byte[] ���� = (byte[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Byte) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Short.class.equals(this.selectedClass)){
					short[] ���� = (short[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Short) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Integer.class.equals(this.selectedClass))/*Integer.class.equals(selectedClass.getClass())*/{
					int[] ���� = (int[]) Array.newInstance(int.class, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						if(checkType(comboBox)){//String�ł���
							����[k] = Integer.valueOf((String) comboBox.getSelectedItem());
						}else{
							����[k] = (Integer)comboBox.getSelectedItem();
						}
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Long.class.equals(this.selectedClass)){
					long[] ���� = (long[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Long)comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Float.class.equals(this.selectedClass)){
					float[] ���� = (float[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Float)comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Double.class.equals(this.selectedClass)){
					double[] ���� = (double[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Double) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}else if(Boolean.class.equals(this.selectedClass)){
					boolean[] ���� = (boolean[]) Array.newInstance(this.selectedClass, this.arrayLength);
					int k = 0;
					for(JComboBox comboBox :this.�z��v�f���̓R���{�{�b�N�X�A���C){
						����[k] = (Boolean) comboBox.getSelectedItem();
						k++;
					}
					this.mdls.getListModel().addElement(����);
					this.mdls.getComboBoxModel().addElement(����);
				}
			}else {
				Object[] ����= (Object[]) Array.newInstance(this.selectedClass, this.arrayLength);
				int k = 0;
				for(JComboBox element :this.�z��v�f���̓R���{�{�b�N�X�A���C){
					//System.out.println(element.getSelectedItem()+": " + element.getSelectedItem().getClass());
					����[k] = element.getSelectedItem();
					k++;
				}
				this.mdls.getListModel().addElement(����);
				this.mdls.getComboBoxModel().addElement(����);
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
