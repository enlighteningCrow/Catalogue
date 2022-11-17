package org.AOOPProject;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

public class DirUpButton extends NavigationButton implements ConditionallyActiveButton {
    public DirUpButton(DirectoryShownFiles directoryShownFiles) {
        super(directoryShownFiles);
    }

    @Override
    public void manipulateHistory() {
        if (directoryShownFiles.hist.size() - 1 > directoryShownFiles.histIndex)
            directoryShownFiles.hist.subList(directoryShownFiles.histIndex + 1,
                    directoryShownFiles.hist.size());
        PairPwdPopulator pair = directoryShownFiles.hist.get(directoryShownFiles.histIndex).clone();
        pair.pwd.remove(pair.pwd.size() - 1);
        directoryShownFiles.hist.add(pair);
        ++directoryShownFiles.histIndex;
    }

    @Override
    public boolean condition() {
        return directoryShownFiles.getPwd().size() != 0;
    }
}