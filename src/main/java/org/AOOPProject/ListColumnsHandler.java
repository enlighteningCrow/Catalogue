package org.AOOPProject;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

// import org.AOOPProject.FileContentsDisplayer.ListPane;
import org.AOOPProject.FileContentsDisplayer;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

// Note: Class to handle communication between the lists in the interface and
// the models (FileSystemModel)
class ListColumnsHandler {

	/**
	 *
	 */
	private final FileContentsDisplayer fileContentsDisplayer;

	GridBagConstraints constraints;

	// public class ListColumn {
	// }
	/**
	 * The models for each of the columsn of ListPanes; The models[0] is for the
	 * first column (leftmost), and the models[models.size() - 1] is for the
	 * rightmost column
	 */
	// return;: Change this class to contain the variable "populator" as the root of
	// the models
	static class PairFSModelDirectory {
		FileSystemModel model;
		String currentDirectory;

		public PairFSModelDirectory(FileSystemModel model, String currentDirectory) {
			this.model = model;
			this.currentDirectory = currentDirectory;
		}
	}

	public ArrayList<PairFSModelDirectory> models = new ArrayList<>();
	// TODO: Use this currentDirectory to implement the path text box

	/**
	 * Group up the list and the pane it belongs to
	 */
	public class ListPane {
		// TODO: Change this list to something else,
		JList<File> list;
		JScrollPane pane;

		PairFSModelDirectory pair = null;

		public PairFSModelDirectory getPair() {
			return pair;
		}

		public void setPair(PairFSModelDirectory pair) {
			this.pair = pair;
		}

		public ListPane(JList<File> list, JScrollPane pane) {
			this.list = list;
			this.pane = pane;
		}
	}

	public ArrayList<ListPane> listPanes = new ArrayList<>();

	/**
	 * Number of columns currently being shown
	 */
	private int modelsSize;

	// private ArrayList<ListColumn> li;

	ListPane currentActiveList;

	public ListPane getCurrentActiveList() {
		return currentActiveList;
	}

	public int getCurrentActiveListIndex() {
		for (int i = listPanes.size() - 1; i >= 0; --i) {
			if (currentActiveList == listPanes.get(i))
				// Note: Use this by <whatever>.size() - <retval>
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
		// modelsSize = Math.min(models.size(),
		// this.fileContentsDisplayer.maxColumnNumber);
		// TODO: Decide whether to remove the max column number
		// modelsSize = this.fileContentsDisplayer.maxColumnNumber;
		while (listPanes.size() < models.size()) {
			ListPane item;
			// lists.add(item = this.fileContentsDisplayer.new ListPane(new JList<File>(),
			// new JScrollPane()));
			listPanes.add(item = new ListPane(new JList<File>(), new JScrollPane()));
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
			// listPanes.get(i).pane.revalidate();
			// listPanes.get(i).list.revalidate();
			// lists.get(i).
		}
		if (currentActiveList == null && listPanes.size() != 0)
			currentActiveList = listPanes.get(0);
		updateExternals();
	}

	// static ListPane lastActiveListPane = null;

	void updateExternals() {
		if (currentActiveList == null)
			return;
		final ListPane lp = currentActiveList;
		// currentActiveList = lp;
		JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(
				JTabbedPane.class,
				fileContentsDisplayer);
		// System.out.println(currentActiveList.list);
		// System.out.println(currentActiveList.list.getParent());
		// System.out.println(currentActiveList.list.getParent().getParent());
		if (tabbedPane == null)
			return;
		// tabbedPane.getSelectedIndex();
		// System.out.println(lp.getPair().currentDirectory);
		if (lp.getPair() != null) {
			for (int i = 0; i < tabbedPane.getComponentCount(); ++i)
				if (tabbedPane.getComponent(
						i) == fileContentsDisplayer) {
					tabbedPane.setTitleAt(i,
							lp.getPair().currentDirectory);
				}
			// tabbedPane.setName(lp.getPair().currentDirectory);
		}
		MainWindow mainWin = (MainWindow) SwingUtilities.getAncestorOfClass(
				MainWindow.class,
				tabbedPane);
		if (mainWin == null)
			return;
		// TODO: Add something in this class regarding current directory
		// and make bridge update it
		// mainWin.getPathString().setText(lp.getPair().currentDirectory);
		// listPanes.size();
		// for(int i = 0; i < listPanes.size(); ++i) {
		// if(listPanes.)
		// }
		DirectoryShownFiles currentShownDirectory = fileContentsDisplayer.bridge.currentlyShownDirs
				.get(listPanes.indexOf(lp));
		mainWin.getLabelsNavigationPanel().removeAll();
		// TODO: Check if this works
		// currentShownDirectory.
		// for()
		mainWin.getLabelsNavigationPanel()
				.add(new ExactNavigationButton(mainWin, currentShownDirectory,
						currentShownDirectory.getPopulator().categoryName, new ArrayList<>()));
		ArrayList<String> arr = new ArrayList<>();
		for (String s : currentShownDirectory.getPwd()) {
			arr.add(s);
			mainWin.getLabelsNavigationPanel()
					.add(new JLabel("/"));
			mainWin.getLabelsNavigationPanel()
					.add(new ExactNavigationButton(mainWin, currentShownDirectory, s,
							new ArrayList<>(arr)));
		}
		// NavigationButton.setDirectoryShownFiles(currentShownDirectory);
		// NavigationButton.updateButtons();
		NavigationButtonsGroup.getGroup(mainWin).setDirectoryShownFiles(currentShownDirectory);
	}
}
