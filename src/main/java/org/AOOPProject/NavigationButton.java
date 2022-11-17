package org.AOOPProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

// interface VoidFunction {
//     public void op();
// }

public abstract class NavigationButton extends JButton
		implements NavigationHistoryAcessor {
	NavigationButtonsGroup group;

	// VoidFunction func;

	// @Override
	// public void manipulateHistory() {
	// func.op();
	// }

	public NavigationButton(NavigationButtonsGroup group) {
		super();
		this.group = group;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manipulateHistory();
				if (group.dsf != null)
					group.dsf.getBridge().update();
				// Note: The following will be called anyways
				// NavigationButton.updateButtons();
			}
		});
		if (!group.allButtons.contains(this))
			group.allButtons.add(this);
	}

	public NavigationButton() {
		this(null);
	}
}
