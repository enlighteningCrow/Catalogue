package org.AOOPProject;

import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.FileSystemPopulator;

// TODO: (Urgent): Make it not expand somehow
public class ExactNavigationButton extends NavigationButton implements ConditionallyActiveButton {
	FileSystemPopulator populator;
	ArrayList<String> pwd;

	public ExactNavigationButton(NavigationButtonsGroup group, FileSystemPopulator populator,
			ArrayList<String> pwd) {
		super(group);
		this.populator = populator;
		this.pwd = pwd;
	}

	public ExactNavigationButton(NavigationButtonsGroup group, DirectoryShownFiles dsf, ArrayList<String> pwd) {
		this(group, dsf.getPopulator(), pwd);
	}

	public ExactNavigationButton(NavigationButtonsGroup group, FileSystemPopulator populator, String str,
			ArrayList<String> pwd) {
		this(group, populator, pwd);
		this.setText(str);
	}

	public ExactNavigationButton(NavigationButtonsGroup group, DirectoryShownFiles dsf, String str,
			ArrayList<String> pwd) {
		this(group, dsf.getPopulator(), pwd);
		this.setText(str);
	}

	public ExactNavigationButton(MainWindow mainWindow, FileSystemPopulator populator,
			ArrayList<String> pwd) {
		super(NavigationButtonsGroup.getGroup(mainWindow));
		this.populator = populator;
		this.pwd = pwd;
	}

	public ExactNavigationButton(MainWindow mainWindow, DirectoryShownFiles dsf, ArrayList<String> pwd) {
		this(NavigationButtonsGroup.getGroup(mainWindow), dsf.getPopulator(), pwd);
	}

	public ExactNavigationButton(MainWindow mainWindow, FileSystemPopulator populator, String str,
			ArrayList<String> pwd) {
		this(NavigationButtonsGroup.getGroup(mainWindow), populator, pwd);
		this.setText(str);
	}

	public ExactNavigationButton(MainWindow mainWindow, DirectoryShownFiles dsf, String str,
			ArrayList<String> pwd) {
		this(NavigationButtonsGroup.getGroup(mainWindow), dsf.getPopulator(), pwd);
		this.setText(str);
	}

	@Override
	public void manipulateHistory() {
		if (group.dsf.hist.size() - 1 > group.dsf.histIndex)
			group.dsf.hist.subList(group.dsf.histIndex + 1,
					group.dsf.hist.size()).clear();
		group.dsf.hist.add(populator.clone());
		++group.dsf.histIndex;
	}

	@Override
	public boolean condition() {
		return group != null && group.dsf != null;
	}
}
