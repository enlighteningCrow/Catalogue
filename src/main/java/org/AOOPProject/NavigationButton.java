package org.AOOPProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

// interface VoidFunction {
//     public void op();
// }

public abstract class NavigationButton extends JButton
		implements NavigationHistoryAcessor {
	DirectoryShownFiles directoryShownFiles;
	static ArrayList<NavigationButton> allButtons = new ArrayList<>();
	// VoidFunction func;

	// @Override
	// public void manipulateHistory() {
	// func.op();
	// }

	public NavigationButton(DirectoryShownFiles directoryShownFiles) {
		super();
		this.directoryShownFiles = directoryShownFiles;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manipulateHistory();
				directoryShownFiles.getBridge().update();
				NavigationButton.updateButtons();
			}
		});
		allButtons.add(this);
	}

	public NavigationButton(PopulatorColumnsBridge bridge, int index) {
		this(bridge.currentlyShownDirs.get(index));
	}

	static public void updateButtons() {
		for (NavigationButton i : allButtons) {
			if (i instanceof ConditionallyActiveButton) {
				i.setEnabled(((ConditionallyActiveButton) i).condition());
			} else
				i.setEnabled(true);
		}
	}
}
