package openingScreen;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Models {

	private final DefaultListModel 生成済オブジェクトのリストモデル;
	private final JList 生成済オブジェクト一覧;
	private final DefaultComboBoxModel 生成済オブジェクトのコンボボックスモデル;

	public Models(){
		this.生成済オブジェクトのリストモデル = new DefaultListModel();
		this.生成済オブジェクト一覧 = new JList(this.生成済オブジェクトのリストモデル);
		this.生成済オブジェクトのコンボボックスモデル = new DefaultComboBoxModel();
	}

	public DefaultListModel get生成済オブジェクトのリストモデル(){
		return this.生成済オブジェクトのリストモデル;
	}

	public JList get生成済オブジェクト一覧(){
		return this.生成済オブジェクト一覧;
	}

	public DefaultComboBoxModel get生成済オブジェクトのコンボボックスモデル(){
		return this.生成済オブジェクトのコンボボックスモデル;
	}
}
