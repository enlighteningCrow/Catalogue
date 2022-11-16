package org.AOOPProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

// interface VoidFunction {
//     public void op();
// }

public abstract class NavigationButton extends IconButton
        implements NavigationHistoryAcessor, ConditionallyActiveButton {
    DirectoryShownFiles directoryShownFiles;
    static ArrayList<NavigationButton> allButtons;
    // VoidFunction func;

    // @Override
    // public void manipulateHistory() {
    // func.op();
    // }

    public NavigationButton(DirectoryShownFiles directoryShownFiles) {
        super();
        this.directoryShownFiles = directoryShownFiles;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manipulateHistory();
                directoryShownFiles.getBridge().update();
                NavigationButton.updateButtons();
            }
        });
    }

    public NavigationButton(PopulatorColumnsBridge bridge, int index) {
        this(bridge.currentlyShownDirs.get(index));
    }

    static public void updateButtons() {
        for (NavigationButton i : allButtons) {
            // TODO: This (check if active or not and set)
            i.setEnabled(i.condition());
        }
    }
}
