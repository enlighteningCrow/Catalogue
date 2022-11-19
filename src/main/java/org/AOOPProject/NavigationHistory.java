package org.AOOPProject;

import java.util.ArrayList;

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