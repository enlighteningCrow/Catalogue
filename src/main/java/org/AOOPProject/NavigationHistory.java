package org.AOOPProject;

import java.util.ArrayList;

// package org.AOOPProject;

// import java.util.ArrayList;

// import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

// public class NavigationHistory {
// ArrayList<DirectoryShownFiles> history;
// PopulatorColumnsBridge bridge;

// public NavigationHistory(ArrayList<DirectoryShownFiles> history,
// PopulatorColumnsBridge bridge) {
// this.history = history;
// this.bridge = bridge;
// if (bridge.history != null)
// System.err.println("Warning: The bridge's history is not null");
// bridge.history = this;
// }

// public void doFunc(NavigationHistoryAcessor accessor) {
// accessor.manipulateHistory();
// bridge.update();
// }
// }

public class NavigationHistory extends ArrayList<FileSystemPopulator> {
    int currentIndex;

    public NavigationHistory(FileSystemPopulator populator) {
        super();
        add(populator);
        this.currentIndex = 0;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    // void goBack() {
    // if (currentIndex > 0)
    // --currentIndex;
    // else
    // System.err.println("Cannot go back");
    // }
    // void goForward() {
    // if (currentIndex < this.size() - 1)
    // ++currentIndex;
    // else
    // System.err.println("Cannot go forward");
    // }
    // void goTo() {
    // }
    void clearRest() {
        if (currentIndex < size() - 1)
            removeRange(currentIndex + 1, size());
    }

    FileSystemPopulator getCurrent() {
        return get(currentIndex);
    }

    FileSystemPopulator setCurrent(FileSystemPopulator pop) {
        return set(currentIndex, pop);
    }

    void push(FileSystemPopulator pop) {
        clearRest();
        add(pop);
        ++currentIndex;
    }
}