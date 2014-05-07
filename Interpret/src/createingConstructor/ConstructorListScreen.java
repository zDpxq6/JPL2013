package createingConstructor;

import java.lang.reflect.Constructor;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import component.ExceptionArea;
import component.Models;

import constant.Const;

public class ConstructorListScreen extends JFrame {
	/**
	 *"コンストラクタの選択画面
	 */
	private static final long serialVersionUID = 1L;

	private final Class<?> selectedClass;
	private final Models mdls;
	private final ExceptionArea ea;
	private JList jl;

	public ConstructorListScreen(Class<?> selectedClass, Models mdls, ExceptionArea ea) {
		super(Const.CONSTRUCTOR_LIST_SCREEN_TITLE);
		this.selectedClass = selectedClass;
		this.mdls = mdls;
		this.ea = ea;
		this.init();
	}

	private void init(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//これが便利
		setLocationRelativeTo(null);
		setSize(Const.CONSTRUCTOR_LIST_SCREEN_FRAME_WIDTH, Const.CONSTRUCTOR_SCREEN_FRAME_HIGHT);
		//受け取ったクラスからリストを生成
		this.jl = new JList(createListModel(this.selectedClass));
		this.jl.addMouseListener(new LSSelectingMouseListener(this,this.mdls,this.ea));
		//
		JScrollPane constructorListPane = new JScrollPane(this.jl);
		add(constructorListPane);

		this.setVisible(true);
	}

	/**クラスをうけとってそのクラスの全コンストラクタが入ったリストモデルを生成する*/
	public static DefaultListModel createListModel(Class<?> clazz){
		Constructor<?>[] constructorArray = clazz.getConstructors();
		return createListModel(constructorArray, null);
	}

	public JList getList(){
		return this.jl;
	}

	public static <T> DefaultListModel createListModel(T[] base, T[] additional){
		DefaultListModel result = new DefaultListModel();
		if(additional != null){
			for (T element : additional) {
				if(element == null){
					System.out.println("要素がnullです");
				}
				result.addElement(element);
			}
		}
		for (T element : base) {
			result.addElement(element);
		}
		return result;
	}
}
