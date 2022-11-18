package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

public class DirUpButton extends NavigationButton implements ConditionallyActiveButton {
	public DirUpButton(NavigationButtonsGroup group) {
		super(group);
	}

	public DirUpButton(MainWindow mainWindow) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
	}

	@Override
	public void manipulateHistory() {
		if (group.dsf.hist.size() - 1 > group.dsf.histIndex)
			group.dsf.hist.subList(group.dsf.histIndex + 1,
					group.dsf.hist.size());
		PairPwdPopulator pair = group.dsf.hist.get(group.dsf.histIndex).clone();
		pair.pwd.remove(pair.pwd.size() - 1);
		group.dsf.hist.add(pair);
		++group.dsf.histIndex;
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null && group.dsf.getPwd().size() != 0;
	}
}
