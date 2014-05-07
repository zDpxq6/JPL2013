package component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Models {

	private final DefaultListModel listModel;
	private final DefaultComboBoxModel comboBoxModel;
	private final JList list;

	public Models(){
		this.listModel = new DefaultListModel();
		this.list = new JList(this.listModel);
		this.comboBoxModel = new DefaultComboBoxModel();
	}

	public DefaultListModel getListModel(){
		return this.listModel;
	}

	public DefaultComboBoxModel getComboBoxModel(){
		return this.comboBoxModel;
	}

	public JList getList(){
		return this.list;
	}

	public void addElement(Object obj){
		this.listModel.addElement(obj);
		this.comboBoxModel.addElement(obj);
	}
}
