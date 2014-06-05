package temp;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyListCellRenderer implements ListCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean hasFocus) {
		JLabel colorChip = new JLabel(makeLabelWithColorChip(object.toString()));
		return colorChip;
	}

	private static String makeLabelWithColorChip(String colorName){
		StringBuilder result = new StringBuilder();
		result.append("<html>");

		result.append("<font color = \"");
		result.append(colorName);
		result.append("\">■</font>");

		result.append(colorName);

		result.append("</html>");
		return result.toString();
	}
}
