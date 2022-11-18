package org.AOOPProject;

import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.FileSystemPopulator;

// TODO: (Urgent): Make it not expand somehow
public class ExactNavigationButton extends NavigationButton implements ConditionallyActiveButton {
	FileSystemPopulator populator;

	public ExactNavigationButton(NavigationButtonsGroup group, FileSystemPopulator populator) {
		super(group);
		this.populator = populator.clone();
	}

	public ExactNavigationButton(NavigationButtonsGroup group, DirectoryShownFiles dsf) {
		this(group, dsf.getPopulator());
	}

	public ExactNavigationButton(NavigationButtonsGroup group, FileSystemPopulator populator, String str) {
		this(group, populator);
		this.setText(str);
	}

	public ExactNavigationButton(NavigationButtonsGroup group, DirectoryShownFiles dsf, String str) {
		this(group, dsf.getPopulator());
		this.setText(str);
	}

	public ExactNavigationButton(MainWindow mainWindow, FileSystemPopulator populator) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
		this.populator = populator;
	}

	public ExactNavigationButton(MainWindow mainWindow, DirectoryShownFiles dsf) {
		this(NavigationButtonsGroup.getGroup(mainWindow), dsf.getPopulator());
	}

	public ExactNavigationButton(MainWindow mainWindow, FileSystemPopulator populator, String str) {
		this(NavigationButtonsGroup.getGroup(mainWindow), populator);
		this.setText(str);
	}

	public ExactNavigationButton(MainWindow mainWindow, DirectoryShownFiles dsf, String str) {
		this(NavigationButtonsGroup.getGroup(mainWindow), dsf.getPopulator());
		this.setText(str);
	}

	@Override
	public void manipulateHistory() {
		group.dsf.hist.push(populator.clone());
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null;
	}
}
