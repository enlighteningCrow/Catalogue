package org.AOOPProject;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

/**
 * Note: Class to handle communication between the lists in the interface and
 * the models (FileSystemModel)
 */
class ListColumnsHandler {

	/**
	 * The FileContentsDisplayer this is part of
	 */
	private final FileContentsDisplayer fileContentsDisplayer;

	GridBagConstraints constraints;

	/**
	 * The models for each of the columsn of ListPanes; The models[0] is for the
	 * first column (leftmost), and the models[models.size() - 1] is for the
	 * rightmost column
	 */
	static class PairFSModelDirectory {
		FileSystemModel model;
		String currentDirectory;

		public PairFSModelDirectory(FileSystemModel model, String currentDirectory) {
			this.model = model;
			this.currentDirectory = currentDirectory;
		}
	}

	public ArrayList<PairFSModelDirectory> models = new ArrayList<>();

	/**
	 * Group up the list and the pane it belongs to
	 */
	public class ListPane {
		FileDisplayerList list;
		JScrollPane pane;

		PairFSModelDirectory pair = null;

		public PairFSModelDirectory getPair() {
			return pair;
		}

		public void setPair(PairFSModelDirectory pair) {
			this.pair = pair;
		}

		public ListPane(FileDisplayerList list, JScrollPane pane) {
			this.list = list;
			this.pane = pane;
		}
	}

	public ArrayList<ListPane> listPanes = new ArrayList<>();

	ListPane currentActiveList;

	public ListPane getCurrentActiveList() {
		return currentActiveList;
	}

	public int getCurrentActiveListIndex() {
		for (int i = listPanes.size() - 1; i >= 0; --i) {
			if (currentActiveList == listPanes.get(i))
				return listPanes.size() - i;
		}
		return -1;
	}

	/**
	 * getter for maxColumnNumber
	 * 
	 * @return max number of columns
	 */
	public int getColumnNumber() {
		return this.fileContentsDisplayer.maxColumnNumber;
	}

	/**
	 * setter for maxColumnNumber; also updates if the maxColumnNumber is changed
	 * 
	 * @param num the new maxColumnNumber
	 */
	public void setColumnNumber(int num) {
		if (this.fileContentsDisplayer.maxColumnNumber == num)
			return;
		this.fileContentsDisplayer.maxColumnNumber = num;
		update();
	}

	/**
	 * Constructo from max number of columns
	 * 
	 * @param fileContentsDisplayer The fileContentsDisplayer
	 * @param num                   max number of columns
	 */
	public ListColumnsHandler(FileContentsDisplayer fileContentsDisplayer, int num) {
		this.fileContentsDisplayer = fileContentsDisplayer;
		this.fileContentsDisplayer.maxColumnNumber = num;
		update();
	}

	/**
	 * Use this function after changing the model or current path; used to update
	 * the GUI
	 */
	void update() {
		while (listPanes.size() < models.size()) {
			ListPane item;
			listPanes.add(item = new ListPane(new FileDisplayerList(), new JScrollPane()));
			item.pane.setViewportView(item.list);
			constraints = new java.awt.GridBagConstraints();
			constraints.fill = java.awt.GridBagConstraints.BOTH;
			constraints.anchor = java.awt.GridBagConstraints.PAGE_START;
			constraints.weightx = 1.0;
			constraints.weighty = 1.0;
			this.fileContentsDisplayer.add(item.pane, constraints);

			item.list.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent evt) {
					currentActiveList = item;
					updateExternals();
				}
			});
		}
		while (listPanes.size() > models.size()) {
			this.fileContentsDisplayer.remove(listPanes.get(listPanes.size() - 1).pane);
			listPanes.remove(listPanes.size() - 1);
		}
		for (int i = 0; i < listPanes.size(); ++i) {
			listPanes.get(i).list.setModel(models.get(i + models.size() - listPanes.size()).model);
			listPanes.get(i).setPair(models.get(i + models.size() - listPanes.size()));
		}
		if (currentActiveList == null && listPanes.size() != 0)
			currentActiveList = listPanes.get(0);
		updateExternals();
	}

	void updateExternals() {
		if (currentActiveList == null)
			return;
		final ListPane lp = currentActiveList;
		JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(
				JTabbedPane.class,
				fileContentsDisplayer);
		if (tabbedPane == null)
			return;
		if (lp.getPair() != null) {
			for (int i = 0; i < tabbedPane.getComponentCount(); ++i)
				if (tabbedPane.getComponent(i) == fileContentsDisplayer) {
					tabbedPane.setTitleAt(i, lp.getPair().currentDirectory);
				}
		}
		MainWindow mainWin = (MainWindow) SwingUtilities.getAncestorOfClass(
				MainWindow.class,
				tabbedPane);
		if (mainWin == null)
			return;
		mainWin.setTitle("Catalogue -> " + lp.getPair().currentDirectory);
		DirectoryShownFiles currentShownDirectory = fileContentsDisplayer.bridge.currentlyShownDirs
				.get(listPanes.indexOf(lp));
		lp.list.setDsf(currentShownDirectory);
		lp.list.setMainWindow(mainWin);
		mainWin.getPathPanel().removeAll();
		FileSystemPopulator pop = currentShownDirectory.getPopulator().clone();
		pop.pwd.clear();
		mainWin.getPathPanel()
				.add(new ExactNavigationButton(mainWin, pop,
						currentShownDirectory.getPopulator().categoryName));
		ArrayList<String> arr = new ArrayList<>();
		for (String s : currentShownDirectory.getPwd()) {
			arr.add(s);
			mainWin.getPathPanel()
					.add(new JLabel("/"));
			pop.pwd.add(s);
			mainWin.getPathPanel()
					.add(new ExactNavigationButton(mainWin, pop.clone(), s));
		}
		NavigationButtonsGroup.getGroup(mainWin).setDirectoryShownFiles(currentShownDirectory);
		ViewButtonsMenuItemsGroup.getGroup(mainWin).setListPanes(lp);
	}
}
