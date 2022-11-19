package org.AOOPProject;

import java.util.HashMap;
import java.util.ArrayList;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class NavigationButtonsGroup {
	DirectoryShownFiles dsf;
	ArrayList<NavigationButton> allButtons;
	MainWindow mainWin;

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

	static NavigationButtonsGroup getGroup(MainWindow win) {
		if (!groups.containsKey(win)) {
			groups.put(win, new NavigationButtonsGroup(win));
		}
		return groups.get(win);
	}
}
