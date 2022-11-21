package org.AOOPProject;

import java.awt.Component;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JList;

public class IconsOnlyView extends SurroundListCellRenderer<JLabel> implements FileDisplayerView {

	public IconsOnlyView() {
		super(new JLabel());
	}

	@Override
	public void setView(FileDisplayerList list) {
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends File> list, File value, int index,
			boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		component.setIcon(javax.swing.filechooser.FileSystemView.getFileSystemView()
				.getSystemIcon((File) value));
		return component;
	}

}
