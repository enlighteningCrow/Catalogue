package org.AOOPProject;

import java.awt.GridBagConstraints;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;

// import org.AOOPProject.FileContentsDisplayer.ListPane;
import org.AOOPProject.FileContentsDisplayer;

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
	// -TODO: Change this class to contain the variable "populator" as the root of
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
		modelsSize = this.fileContentsDisplayer.maxColumnNumber;
		while (listPanes.size() < modelsSize) {
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
				final ListPane lp = item;

				public void focusGained(java.awt.event.FocusEvent evt) {
					currentActiveList = lp;
				}
			});
		}
		while (listPanes.size() > models.size()) {
			this.fileContentsDisplayer.remove(listPanes.get(listPanes.size() - 1).pane);
			listPanes.remove(listPanes.size() - 1);
		}
		for (int i = 0; i < listPanes.size(); ++i) {
			listPanes.get(i).list.setModel(models.get(i + models.size() - listPanes.size()).model);
			// listPanes.get(i).pane.revalidate();
			// listPanes.get(i).list.revalidate();
			// lists.get(i).
		}
	}
}
