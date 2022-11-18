package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class DirBackButton extends NavigationButton implements ConditionallyActiveButton {
	public DirBackButton(NavigationButtonsGroup group) {
		super(group);
	}

	public DirBackButton(MainWindow mainWindow) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
	}

	@Override
	public void manipulateHistory() {
		--group.dsf.hist.currentIndex;
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null && group.dsf.hist.currentIndex != 0;
	}
}
