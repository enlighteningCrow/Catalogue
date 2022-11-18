package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class DirForwardButton extends NavigationButton implements ConditionallyActiveButton {
	public DirForwardButton(NavigationButtonsGroup group) {
		super(group);
	}

	public DirForwardButton(MainWindow mainWindow) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
	}

	@Override
	public void manipulateHistory() {
		++group.dsf.histIndex;
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null && group.dsf.histIndex < group.dsf.hist.size() - 1;
	}
}
