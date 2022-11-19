package org.AOOPProject;

import java.util.ArrayList;
import java.util.HashMap;

import org.AOOPProject.ListColumnsHandler.ListPane;

public class ViewButtonsMenuItemsGroup {
	ListPane lp;
	ArrayList<ViewButton> allButtons;
	ArrayList<ViewMenuItem> allMenuItems;
	MainWindow mainWin;

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

	static ViewButtonsMenuItemsGroup getGroup(MainWindow win) {
		if (!groups.containsKey(win)) {
			groups.put(win, new ViewButtonsMenuItemsGroup(win));
		}
		return groups.get(win);
	}
}
