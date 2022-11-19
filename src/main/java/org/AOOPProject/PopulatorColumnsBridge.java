package org.AOOPProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

class PopulatorColumnsBridge {
	/**
	 *
	 */
	private final FileContentsDisplayer fileContentsDisplayer;
	ListColumnsHandler handler;

	/**
	 * @param fileContentsDisplayer
	 */
	PopulatorColumnsBridge(FileContentsDisplayer fileContentsDisplayer) {
		this.fileContentsDisplayer = fileContentsDisplayer;
		handler = this.fileContentsDisplayer.handler;
	}

	class DirectoryShownFiles {
		public ArrayList<String> getPwd() {
			return hist.getCurrent().pwd;
		}

		public void setPwd(ArrayList<String> pwd) {
			hist.getCurrent().pwd = pwd;
		}

		public FileSystemPopulator getPopulator() {
			return hist.getCurrent();
		}

		public void setPopulator(FileSystemPopulator populator) {
			hist.setCurrent(populator);
		}

		NavigationHistory hist = null;

		void initHistory() {
			if (hist != null) {
				System.err.println("This object has already been init");
				return;
			}
			hist = new NavigationHistory(FileSystemPopulator.getDefault());
		}

		void initHistory(FileSystemPopulator populator) {
			if (hist != null) {
				System.err.println("This object has already been init");
				return;
			}
			hist = new NavigationHistory(populator.clone());
		}

		DirectoryShownFiles(Collection<String> pwd, FileSystemPopulator populator) {
			initHistory();
			this.setPwd(new ArrayList<>(pwd));
			this.setPopulator(populator);
		}

		DirectoryShownFiles(Collection<String> pwd, FileSystemPopulator populator,
				Collection<FileSystemPopulator> hist) {
			initHistory();
			this.setPwd(new ArrayList<>(pwd));
			this.setPopulator(populator);
		}

		PopulatorColumnsBridge getBridge() {
			return PopulatorColumnsBridge.this;
		}
	}

	ArrayList<DirectoryShownFiles> currentlyShownDirs = new ArrayList<>();

	void addNewShownDirectory(File file) {
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(),
				new RealFileSystemPopulator(file.getName(),
						file.toString())));
		update();
	}

	void addNewShownDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void addNewShownDirectory(FileSystemPopulator populator) {
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setActiveColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		if (handler.getCurrentActiveListIndex() == -1)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - handler.getCurrentActiveListIndex(),
					new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setActiveColumnDirectory(FileSystemPopulator populator) {
		int currentActiveListIndex;
		if ((currentActiveListIndex = handler.getCurrentActiveListIndex()) == -1)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - currentActiveListIndex,
					new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setFirstColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setFirstColumnDirectory(FileSystemPopulator populator) {
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setLastColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - 1,
					new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setLastColumnDirectory(FileSystemPopulator populator) {
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - 1,
					new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void updatePopulators() {
		for (DirectoryShownFiles i : currentlyShownDirs)
			if (i.hist != null) {
				i.getPopulator().update();
			}
	}

	void update() {
		updatePopulators();
		handler.models.clear();
		for (DirectoryShownFiles i : currentlyShownDirs) {
			handler.models.add(i.getPopulator().getPairFSModelDirectory());
		}
		handler.update();
		fileContentsDisplayer.revalidate();
		fileContentsDisplayer.repaint();
	}

}
