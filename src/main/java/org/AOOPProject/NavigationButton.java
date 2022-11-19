package org.AOOPProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class NavigationButton extends JButton
		implements NavigationHistoryManipulator {
	NavigationButtonsGroup group;

	public NavigationButton(NavigationButtonsGroup group) {
		super();
		this.group = group;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manipulateHistory();
				if (group.dsf != null)
					group.dsf.getBridge().update();
			}
		});
		if (!group.allButtons.contains(this))
			group.allButtons.add(this);
	}

	public NavigationButton() {
		this(null);
	}
}
