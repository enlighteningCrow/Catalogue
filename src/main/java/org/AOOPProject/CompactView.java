package org.AOOPProject;

import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

//TODO: Continue from this; make other views and connect them to the ViewButton buttons
public class CompactView extends SurroundListCellRenderer<JLabel> implements FileDisplayerView {

    public CompactView() {
        super(new JLabel());
        // TODO Auto-generated constructor stub
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends File> list, File value, int index, boolean isSelected,
            boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        component.setIcon(javax.swing.filechooser.FileSystemView.getFileSystemView()
                .getSystemIcon((File) value));
        component.setText(utils.getName((File) value));
        return component;
    }

    @Override
    public void setView(JList list) {
        list.setLayoutOrientation(JList.VERTICAL);
    }

}
