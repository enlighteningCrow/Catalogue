package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.FileSystemPopulator;

public class DirUpButton extends NavigationButton implements ConditionallyActiveButton {
	// public DirUpButton(NavigationButtonsGroup group) {
	// super(group);
	// }

	public DirUpButton(MainWindow mainWindow) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
	}

	@Override
	public void manipulateHistory() {
		FileSystemPopulator pair = group.dsf.hist.get(group.dsf.hist.currentIndex).clone();
		pair.pwd.remove(pair.pwd.size() - 1);
		group.dsf.hist.push(pair);
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null && group.dsf.getPwd().size() != 0;
	}
}
