package createingConstructor;

import java.lang.reflect.Constructor;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import openingScreen.Models;

import component.ExceptionArea;

import constant.Const;

public class ListScreen extends JFrame {
	/**
	 *"コンストラクタの選択画面
	 */
	private static final long serialVersionUID = 1L;

	private final Class<?> selectedClass;
	private JList jl;
	private final Models mdls;
	private final ExceptionArea ea;

	public ListScreen(Class<?> selectedClass, Models mdls, ExceptionArea ea) {
		super(Const.FrameName2);
		this.selectedClass = selectedClass;
		this.mdls = mdls;
		this.ea = ea;
		this.init();
	}

	private void init(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(Const.コンストラクタパラメータ入力UI幅, Const.コンストラクタパラメータ入力UI高さ);

		this.jl = new JList(createListModel(this.selectedClass));
		this.jl.addMouseListener(new LSSelectingMouseListener(this,this.mdls,this.ea));//リストから選択する方式
		JScrollPane result = new JScrollPane();
		result.getViewport().setView(this.jl);

		add(result);

		this.setVisible(true);
	}

	/**クラスをうけとってそのクラスの全コンストラクタが入ったリストモデルを生成する*/
	private static DefaultListModel createListModel(Class<?> clazz){
		DefaultListModel result = new DefaultListModel();
		Constructor<?>[] constructorArray = clazz.getConstructors();
		for (Constructor<?> element : constructorArray) {
			result.addElement(element);
		}
		return result;
	}

	public JList getList(){
		return this.jl;
	}
}
