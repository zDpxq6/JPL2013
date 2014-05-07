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

import component.ExceptionArea;
import component.ListPane;
import component.Models;
import editingObject.�z��ȊO�����oUI���\�b�h�I���}�E�X���X�i;


public class MethodListPane extends ListPane{

	private static final long serialVersionUID = 1L;
	private final JList methodList;
	private final Models mdls;
	private ExceptionArea ea;

	//JList�������ɂƂ�̂�����
	public MethodListPane(Object obj, MouseListener i, Models mdls, ExceptionArea ea){
		super(���\�b�h�ꗗ�̐���(obj, mdls, ea), i);
		this.methodList = ���\�b�h�ꗗ�̐���(obj, mdls, ea);
		this.mdls = mdls;
	}

	static JList ���\�b�h�ꗗ�̐���(Object obj, Models mdls, ExceptionArea ea){
		Method[] methodArray = obj.getClass().getMethods();//���\�b�h���擾

		Map <String, List<Method>>sortedMap = makeMethodArray(methodArray);

		JList methodList = new JList(makeListModel(sortedMap));
		methodList.addMouseListener(new �z��ȊO�����oUI���\�b�h�I���}�E�X���X�i(methodList, obj, mdls, ea));
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

	private static DefaultListModel makeListModel(Map <String, List<Method>>�K��){
		DefaultListModel methodListModel = new DefaultListModel();//���X�g���f������

		Iterator <Map.Entry<String, List<Method>>>tempMapIterator = �K��.entrySet().iterator();
		while(tempMapIterator.hasNext()){
			Map.Entry<String, List<Method>> entry = tempMapIterator.next();
			entry.getValue();
			//���X�g�����[�v����
			for(Method element:entry.getValue()){
				methodListModel.addElement(element);
			}
		}
		return methodListModel;
	}
}
