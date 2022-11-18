package org.AOOPProject;

// import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class NavigationButtonsGroup {
	DirectoryShownFiles dsf;
	ArrayList<NavigationButton> allButtons;
	MainWindow mainWin;
	// VoidFunction func;

	// @Override
	// public void manipulateHistory() {
	// func.op();
	// }

	// public NavigationButtonsGroup() {
	// this(null, null);
	// }
	//
	// public NavigationButtonsGroup(DirectoryShownFiles dsf) {
	// this.dsf = dsf;
	// allButtons = new ArrayList<>();
	// }

	public NavigationButtonsGroup(MainWindow mainWin) {
		this.mainWin = mainWin;
		allButtons = new ArrayList<>();
	}

	public NavigationButtonsGroup(DirectoryShownFiles dsf, MainWindow mainWin) {
		this.dsf = dsf;
		this.mainWin = mainWin;
		allButtons = new ArrayList<>();
	}

	void addNavigationButton(NavigationButton button) {
		allButtons.add(button);
	}

	// public NavigationButtonsGroup(PopulatorColumnsBridge bridge, int index) {
	// this(bridge.currentlyShownDirs.get(index));
	// }

	public void updateButtons() {
		for (NavigationButton i : allButtons) {
			if (i instanceof ConditionallyActiveButton)
				i.setEnabled(((ConditionallyActiveButton) i).condition());
			else
				i.setEnabled(true);
		}
		if (mainWin != null) {
			mainWin.revalidate();
			mainWin.repaint();
		}
	}

	public void setDirectoryShownFiles(DirectoryShownFiles dsf) {
		this.dsf = dsf;
		updateButtons();
	}

	static private HashMap<MainWindow, NavigationButtonsGroup> groups = new HashMap<>();
	// static private HashMap<NavigationButtonsGroup, MainWindow> groupsInverted =
	// new HashMap<>();

	static NavigationButtonsGroup getGroup(MainWindow win) {
		// if (groups.containsKey(win) != groupsInverted.containsKey(groups))
		// System.err.println("MainWindows and NavigationButtonsGroup must have a
		// one-to-one mapping");
		if (!groups.containsKey(win)) {
			// NavigationButtonsGroup g;
			groups.put(win, new NavigationButtonsGroup(win));

			// groupsInverted.put(g, win);
		}
		return groups.get(win);
	}
}
