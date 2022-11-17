package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class DirBackButton extends NavigationButton implements ConditionallyActiveButton {
	public DirBackButton(DirectoryShownFiles directoryShownFiles) {
		super(directoryShownFiles);
	}

	public DirBackButton() {
		super();
	}

	@Override
	public void manipulateHistory() {
		// if(directoryShownFiles.histIndex != 0)
		// directoryShownFiles.hist.subList(directoryShownFiles.histIndex + 1,
		// directoryShownFiles.hist.size());
		--directoryShownFiles.histIndex;
	}

	@Override
	public boolean condition() {
		if (directoryShownFiles == null)
			return false;
		return directoryShownFiles.histIndex != 0;
	}
}
