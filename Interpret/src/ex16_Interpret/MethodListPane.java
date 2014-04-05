package ex16_Interpret;

import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import openingScreen.Models;

import component.ExceptionArea;
import component.ListPane;

import editingObject.配列以外メンバUIメソッド選択マウスリスナ;


public class MethodListPane extends ListPane{

	private static final long serialVersionUID = 1L;
	private final JList methodList;
	private final Models mdls;
	private ExceptionArea ea;

	//JListを引数にとるのもつくる
	public MethodListPane(Object obj, MouseListener i, Models mdls, ExceptionArea ea){
		super(メソッド一覧の生成(obj.getClass(), mdls, ea), i);
		this.methodList = メソッド一覧の生成(obj.getClass(), mdls, ea);
		this.mdls = mdls;
	}

	static JList メソッド一覧の生成(Object obj, Models mdls, ExceptionArea ea){
		Method[] methodArray = obj.getClass().getMethods();//メソッドを取得

		Map <String, List<Method>>sortedMap = makeMethodArray(methodArray);

		JList methodList = new JList(makeListModel(sortedMap));
		methodList.addMouseListener(new 配列以外メンバUIメソッド選択マウスリスナ(methodList, mdls, ea));
		return methodList;
	}


	private static Map<String, List<Method>> makeMethodArray (Method[] methodArray){
		Map <String, List<Method>>result = new TreeMap<String, List<Method>>();

		for(Method element : methodArray){
			String methodName = element.getName();
			if(result.containsKey(methodName)){// when methodName duplicated(has overloaded methods)
				result.get(methodName).add(element);
			}else{
				List<Method> methodList = new LinkedList<Method>();
				methodList.add(element);
				result.put(methodName, methodList);
			}
		}
		return result;
	}

	private static DefaultListModel makeListModel(Map <String, List<Method>>適当){
		DefaultListModel methodListModel = new DefaultListModel();//リストモデル生成

		Iterator <Map.Entry<String, List<Method>>>tempMapIterator = 適当.entrySet().iterator();
		while(tempMapIterator.hasNext()){
			Map.Entry<String, List<Method>> entry = tempMapIterator.next();
			entry.getValue();
			//リストをループする
			for(Method element:entry.getValue()){
				methodListModel.addElement(element);
			}
		}
		return methodListModel;
	}
}
