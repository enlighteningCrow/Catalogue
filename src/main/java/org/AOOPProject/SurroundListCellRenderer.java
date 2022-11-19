package org.AOOPProject;

import java.awt.Component;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ColorUIResource;

public abstract class SurroundListCellRenderer<T extends JComponent> implements ListCellRenderer<File> {

        T component;

        public SurroundListCellRenderer(T component) {
                this.component = component;
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends File> list, File value,
                        int index, boolean isSelected,
                        boolean cellHasFocus) {
                component.setOpaque(true);
                ColorUIResource foreground = utils.getLAFDefaultColor("List." + (isSelected
                                ? cellHasFocus ? "selectionForeground"
                                                : "selectionInactiveForeground"
                                : "foreground"));
                component.setForeground(foreground);
                ColorUIResource background = utils.getLAFDefaultColor("List." + (isSelected
                                ? cellHasFocus ? "selectionBackground"
                                                : "selectionInactiveBackground"
                                : "background"));
                component.setBackground(background);
                return component;
        }
}
