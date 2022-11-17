package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class DirForwardButton extends NavigationButton implements ConditionallyActiveButton {
    public DirForwardButton(DirectoryShownFiles directoryShownFiles) {
        super(directoryShownFiles);
    }

    @Override
    public void manipulateHistory() {
        ++directoryShownFiles.histIndex;
    }

    @Override
    public boolean condition() {
        return directoryShownFiles.histIndex < directoryShownFiles.hist.size() - 1;
    }
}