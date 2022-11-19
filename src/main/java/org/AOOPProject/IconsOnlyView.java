package org.AOOPProject;

import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

//TODO: Continue from this; make other views and connect them to the ViewButton buttons
public class IconsOnlyView extends SurroundListCellRenderer<JLabel> implements FileDisplayerView {

	public IconsOnlyView() {
		super(new JLabel());
	}

	@Override
	public void setView(JList list) {
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends File> list, File value, int index,
			boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		component.setIcon(javax.swing.filechooser.FileSystemView.getFileSystemView()
				.getSystemIcon((File) value));
		return component;
	}

}
