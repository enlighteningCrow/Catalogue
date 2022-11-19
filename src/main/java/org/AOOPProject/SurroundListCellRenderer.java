package org.AOOPProject;

import java.awt.Component;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

import java.awt.Font;

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
        System.out.println("\nForeground: " + foreground);
        ColorUIResource background = utils.getLAFDefaultColor("List." + (isSelected
                ? cellHasFocus ? "selectionBackground"
                        : "selectionInactiveBackground"
                : "background"));
        component.setBackground(background);
        System.out.println("Backgroudn: " + background);
        // Object border = utils.getLAFDefault(
        // "List." + (cellHasFocus ? isSelected ? "focusSelectedCellHighlightBorder" :
        // "focusCellHighlightBorder"
        // : "cellNoFocusBorder"));
        // if (border instanceof Border)
        // component.setBorder((Border) border);
        // Object font = utils.getLAFDefault("List.font");
        // if (font instanceof Font)
        // component.setFont((Font) font);
        return component;
    }
}
