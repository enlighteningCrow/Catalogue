package org.AOOPProject;

import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

// TODO: (Urgent): Make it not expand somehow
public class ExactNavigationButton extends NavigationButton implements ConditionallyActiveButton {
	FileSystemPopulator populator;
	ArrayList<String> pwd;

	public ExactNavigationButton(DirectoryShownFiles directoryShownFiles, FileSystemPopulator populator,
			ArrayList<String> pwd) {
		super(directoryShownFiles);
		this.populator = populator;
		this.pwd = pwd;
	}

	public ExactNavigationButton(DirectoryShownFiles dsf, ArrayList<String> pwd) {
		this(dsf, dsf.getPopulator(), pwd);
	}

	public ExactNavigationButton(DirectoryShownFiles dsf, String str, ArrayList<String> pwd) {
		this(dsf, dsf.getPopulator(), pwd);
		this.setText(str);
	}

	public ExactNavigationButton(FileSystemPopulator populator, ArrayList<String> pwd) {
		this(null, populator, pwd);
	}

	@Override
	public void manipulateHistory() {
		if (directoryShownFiles.hist.size() - 1 > directoryShownFiles.histIndex)
			directoryShownFiles.hist.subList(directoryShownFiles.histIndex + 1,
					directoryShownFiles.hist.size());
		directoryShownFiles.hist.add(directoryShownFiles.new PairPwdPopulator(pwd, populator));
		++directoryShownFiles.histIndex;
	}

	@Override
	public boolean condition() {
		return directoryShownFiles != null;
	}
}
