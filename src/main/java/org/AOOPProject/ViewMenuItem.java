package org.AOOPProject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class ViewMenuItem extends JMenuItem {
    ViewButtonsMenuItemsGroup group;
    FileDisplayerView view;

    // VoidFunction func;

    // @Override
    // public void manipulateHistory() {
    // func.op();
    // }

    public ViewMenuItem(MainWindow mainWindow, FileDisplayerView view) {
        super();
        this.group = ViewButtonsMenuItemsGroup.getGroup(mainWindow);
        this.view = view;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (group.lp != null) {
                    group.lp.list.setView(view);
                }
            }
        });
        if (!group.allMenuItems.contains(this))
            group.allMenuItems.add(this);
    }

    // public ViewMenuItem() {
    // this(null);
    // }
}
