package org.AOOPProject;

import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

public class NavigationButtons {
    public class DirUpButton extends NavigationButton {
        public DirUpButton(DirectoryShownFiles directoryShownFiles) {
            super(directoryShownFiles);
        }

        @Override
        public void manipulateHistory() {
            if (directoryShownFiles.hist.size() - 1 > directoryShownFiles.histIndex)
                directoryShownFiles.hist.subList(directoryShownFiles.histIndex + 1, directoryShownFiles.hist.size());
            directoryShownFiles.hist.add(directoryShownFiles.hist.get(directoryShownFiles.histIndex).clone());
            ++directoryShownFiles.histIndex;
        }

        @Override
        public boolean condition() {
            return directoryShownFiles.getPwd().size() != 0;
        }
    }

    public class DirBackButton extends NavigationButton {
        public DirBackButton(DirectoryShownFiles directoryShownFiles) {
            super(directoryShownFiles);
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
            return directoryShownFiles.histIndex != 0;
        }
    }

    public class DirForwardButton extends NavigationButton {
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

}