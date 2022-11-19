package org.AOOPProject;

import java.io.File;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Desktop;

public class FileDisplayerList extends JList<File> {
	public DirectoryShownFiles getDsf() {
		return dsf;
	}

	public void setDsf(DirectoryShownFiles dsf) {
		this.dsf = dsf;
	}

	DirectoryShownFiles dsf = null;
	MainWindow mainWindow = null;

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	void init(FileDisplayerView view) {
		setCellRenderer(view);
		view.setView(this);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Object source = evt.getSource();
				FileDisplayerList list = (FileDisplayerList) source;
				switch (evt.getButton()) {
					// Note: left click
					case MouseEvent.BUTTON1:
						// Note: Double click
						if (evt.getClickCount() == 2) {
							int index = list.locationToIndex(
									evt.getPoint());
							File selectedFile = list.getModel()
									.getElementAt(index);
							if (selectedFile.isDirectory()) {
								RealFileSystemPopulator pop = new RealFileSystemPopulator(
										selectedFile);
								// NavigationButtonsGroup.getGroup(mainWindow);
								dsf.hist.push(pop);
								dsf.getBridge().update();
							} else {

								try {
									Desktop.getDesktop().open(selectedFile);
								} catch (Exception e) {
									// TODO: (Maybe) Make this show a popup dialog
									// that tells the user an error occurred
									System.err.println("Error opening the file "
											+ selectedFile.getAbsolutePath()
											+ "\nError message: "
											+ e.getMessage());
								}
								// TODO:
								// https://stackoverflow.com/questions/550329/how-to-open-a-file-with-the-default-associated-program
								// Use the link above to open files (that are not
								// directories)
							}
						}
						break;
					case MouseEvent.BUTTON2:
					case MouseEvent.BUTTON3:
						// TODO: (Urgent) this; make it show a dialog or something (like what
						// most file explorers do when right clicking) (Search stackoverflow for
						// popups)

						// default:
						// System.out.println(evt.getButton());
				}
				// else if (evt.getClickCount() == 3) {
				// int index = list.locationToIndex(evt.getPoint());
				// }
			}
		});
		revalidate();
		repaint();
		// updateUI();
	}

	void setView(FileDisplayerView view) {
		init(view);
	}

	public FileDisplayerList(FileDisplayerView view, Vector<? extends File> listData) {
		super(listData);
		init(view);
	}

	public FileDisplayerList(FileDisplayerView view, File[] listData) {
		super(listData);
		init(view);
	}

	public FileDisplayerList(FileDisplayerView view, ListModel<File> dataModel) {
		super(dataModel);
		init(view);
	}

	public FileDisplayerList(FileDisplayerView view) {
		super();
		init(view);
	}

	public FileDisplayerList() {
		super();
		init(FileDisplayerView.geDefault());
	}
}
