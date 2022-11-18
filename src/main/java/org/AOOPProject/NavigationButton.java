package org.AOOPProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.FileSystemPopulator;

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
				for (int i = 0; i < 100; ++i)
					System.out.print('<');
				System.out.print('\n');
				for (int i = 0; i < NavigationButton.this.group.dsf.hist.size(); ++i) {
					System.out.println((NavigationButton.this.group.dsf.hist.currentIndex == i ? "-> " : "   ")
							+ NavigationButton.this.group.dsf.hist.get(i));
				}
				System.out.print('\n');
				manipulateHistory();
				if (group.dsf != null)
					group.dsf.getBridge().update();
				// Note: The following will be called anyways
				// NavigationButton.updateButtons();
				for (int i = 0; i < NavigationButton.this.group.dsf.hist.size(); ++i) {
					System.out.println((NavigationButton.this.group.dsf.hist.currentIndex == i ? "-> " : "   ")
							+ NavigationButton.this.group.dsf.hist.get(i));
				}
				for (int i = 0; i < 100; ++i)
					System.out.print('>');
				System.out.print('\n');
			}
		});
		if (!group.allButtons.contains(this))
			group.allButtons.add(this);
	}

	public NavigationButton() {
		this(null);
	}
}
