package constant;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyListCellRenderer implements ListCellRenderer {


	@Override
	public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean hasFocus) {
		JLabel colorChip = new JLabel(makeLabelWithColorChip(object.toString()));
		colorChip.setOpaque(true);
		colorChip.setBackground(isSelected ? Color.RED : Color.WHITE);
		colorChip.setForeground(isSelected ? Color.WHITE : Color.BLACK);
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
