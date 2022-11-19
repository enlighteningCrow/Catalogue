package org.AOOPProject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class ViewButton extends JButton {
	ViewButtonsMenuItemsGroup group;
	FileDisplayerView view;

	public ViewButton(MainWindow mainWindow, FileDisplayerView view) {
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
		if (!group.allButtons.contains(this))
			group.allButtons.add(this);
	}
}
