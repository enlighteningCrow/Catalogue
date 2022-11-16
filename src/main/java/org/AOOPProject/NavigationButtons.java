package org.AOOPProject;

import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

public class NavigationButtons {
    static public class DirUpButton extends NavigationButton implements ConditionallyActiveButton {
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

    static public class DirBackButton extends NavigationButton implements ConditionallyActiveButton {
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

    static public class DirForwardButton extends NavigationButton implements ConditionallyActiveButton {
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

    // TODO: (Urgent): Make it not expand somehow
    static public class ExactNavigationButton extends NavigationButton {
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

        @Override
        public void manipulateHistory() {
            if (directoryShownFiles.hist.size() - 1 > directoryShownFiles.histIndex)
                directoryShownFiles.hist.subList(directoryShownFiles.histIndex + 1,
                        directoryShownFiles.hist.size());
            directoryShownFiles.hist.add(directoryShownFiles.new PairPwdPopulator(pwd, populator));
            ++directoryShownFiles.histIndex;
        }
    }
}
