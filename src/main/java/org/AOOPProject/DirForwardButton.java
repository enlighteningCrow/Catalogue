package org.AOOPProject;

public class DirForwardButton extends NavigationButton implements ConditionallyActiveButton {

	public DirForwardButton(MainWindow mainWindow) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
	}

	@Override
	public void manipulateHistory() {
		++group.dsf.hist.currentIndex;
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null && group.dsf.hist.currentIndex < group.dsf.hist.size() - 1;
	}
}
