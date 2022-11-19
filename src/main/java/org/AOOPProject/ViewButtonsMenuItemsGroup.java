package org.AOOPProject;

import java.util.ArrayList;
import java.util.HashMap;

import org.AOOPProject.ListColumnsHandler.ListPane;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

public class ViewButtonsMenuItemsGroup {
	ListPane lp;
	ArrayList<ViewButton> allButtons;
	ArrayList<ViewMenuItem> allMenuItems;
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

	public ViewButtonsMenuItemsGroup(MainWindow mainWin) {
		this.mainWin = mainWin;
		allButtons = new ArrayList<>();
		allMenuItems = new ArrayList<>();
	}

	public ViewButtonsMenuItemsGroup(ListPane lp, MainWindow mainWin) {
		this.lp = lp;
		this.mainWin = mainWin;
		allButtons = new ArrayList<>();
		allMenuItems = new ArrayList<>();
	}

	void addViewButton(ViewButton button) {
		allButtons.add(button);
	}

	void addViewMenuItem(ViewMenuItem item) {
		allMenuItems.add(item);
	}

	// public ViewButtonsGroup(PopulatorColumnsBridge bridge, int index) {
	// this(bridge.currentlyShownDirs.get(index));
	// }

	public void updateItems() {
		for (ViewButton i : allButtons) {
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

	public void setListPanes(ListPane lp) {
		this.lp = lp;
		updateItems();
	}

	static private HashMap<MainWindow, ViewButtonsMenuItemsGroup> groups = new HashMap<>();
	// static private HashMap<ViewButtonsGroup, MainWindow> groupsInverted =
	// new HashMap<>();

	static ViewButtonsMenuItemsGroup getGroup(MainWindow win) {
		// if (groups.containsKey(win) != groupsInverted.containsKey(groups))
		// System.err.println("MainWindows and ViewButtonsGroup must have a
		// one-to-one mapping");
		if (!groups.containsKey(win)) {
			// ViewButtonsGroup g;
			groups.put(win, new ViewButtonsMenuItemsGroup(win));

			// groupsInverted.put(g, win);
		}
		return groups.get(win);
	}
}
