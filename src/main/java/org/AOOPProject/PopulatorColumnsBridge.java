package org.AOOPProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.AOOPProject.ListColumnsHandler.PairFSModelDirectory;
import org.AOOPProject.PopulatorColumnsBridge.DirectoryShownFiles.PairPwdPopulator;

// TODO: Make methods to navigate the tree (eg. go to parent directory, go to
// first child directory, etc.)
// TODO: Make methods to navigate the lists themselves (maybe add them as
// shortcut keys, where h, j, k, l and left, down, up, right move the cursor
// around the interface)
// TODO: GUI: settings: paths to search: make a GUI (like vscode settings ui) to
// edit them
// TODO: Make a class to read the JSON
// TODO: (Maybe) Use the File Dialog in the vscode ui to select for paths to add
// TODO: (Continued) (Maybe) GUI: add button to insert wildcard (regex or glob)
// TODO: Connect the leftmost buttons to the searchPathsRegex,Glob
// TODO: Connect the upper textedit to represent the current path (pwd)
// TODO: Make a way to edit the outer folders while making the inner folders
// remain (in the alternative data structre (not tree, but descriptions based
// structure))
// Hi
// TODO: Hi
// HELLO IAIAIAIAIAIAIA
//TODO: Make all FileSystemPopulators have categoryNames corresponding to the actual path (if it is a real path) or the category name (if it is the virtual root (on the left columns))
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
		// ArrayList<String> pwd;
		// FileSystemPopulator populator;

		public ArrayList<String> getPwd() {
			return hist.get(histIndex).pwd;
		}

		public void setPwd(ArrayList<String> pwd) {
			hist.get(histIndex).pwd = pwd;
			hist.get(histIndex).repositionRealPopulator();
		}

		public FileSystemPopulator getPopulator() {
			return hist.get(histIndex).populator;
		}

		public void setPopulator(FileSystemPopulator populator) {
			hist.get(histIndex).populator = populator;
			hist.get(histIndex).repositionRealPopulator();
		}

		public static class PairPwdPopulator {
			ArrayList<String> pwd;
			FileSystemPopulator populator;

			public PairPwdPopulator(ArrayList<String> pwd, FileSystemPopulator populator) {
				this.pwd = pwd;
				this.populator = populator;
				repositionRealPopulator();
			}

			private void reposition(RealFileSystemPopulator pop) {
				String[] pathComps = pop.getRootFile().getAbsolutePath().replace('\\', '/').split("/");
				// System.out.println(Paths.get(pop.getRootFile().getPath()).getRoot().toFile());
				// System.out.println(Paths.get(pop.getRootFile().getAbsolutePath()));
				// System.out.println(Paths.get(pop.getRootFile().getAbsolutePath()).getRoot());
				pop.setRootFile(Paths.get(pop.getRootFile().getAbsolutePath()).getRoot().toFile());
				for (int i = 1; i < pathComps.length; ++i) {
					String s = pathComps[i];
					// System.out.println(s);
					if (s.trim().length() != 0)
						this.pwd.add(s);
				}
				System.out.println(pwd);
			}

			private void repositionRealPopulator() {
				if (this.populator instanceof RealFileSystemPopulator) {
					if (this.pwd.size() != 0) {
						ArrayList<String> tmp = new ArrayList<>(pwd);
						pwd.clear();
						reposition((RealFileSystemPopulator) populator);
						pwd.addAll(tmp);
					} else {
						reposition((RealFileSystemPopulator) populator);
					}
				}
			}

			public PairPwdPopulator clone() {
				return new PairPwdPopulator(new ArrayList<>(pwd), populator.clone());
			}
		}

		ArrayList<PairPwdPopulator> hist = new ArrayList<>();
		int histIndex = -1;

		void initHistory() {
			if (histIndex != -1) {
				System.err.println("This object has already been init");
				return;
			}
			hist.add(new PairPwdPopulator(null, null));
			histIndex = 0;
		}

		DirectoryShownFiles(Collection<String> pwd, FileSystemPopulator populator) {
			initHistory();
			this.setPwd(new ArrayList<>(pwd));
			this.setPopulator(populator);
			// this.hist = new ArrayList<>();
		}

		DirectoryShownFiles(Collection<String> pwd, FileSystemPopulator populator,
				Collection<PairPwdPopulator> hist) {
			initHistory();
			this.setPwd(new ArrayList<>(pwd));
			this.setPopulator(populator);
			// this.hist = new ArrayList<>(hist);
		}

		PopulatorColumnsBridge getBridge() {
			return PopulatorColumnsBridge.this;
		}
	}

	ArrayList<DirectoryShownFiles> currentlyShownDirs = new ArrayList<>();

	// void changeRoot() {
	// pwd.clear();
	// pwd.add(populator.contents.get(index));
	// // jasiodajsdlfjasldkfjawdsfjoaisdjfoasjdifjaosidfjo ajdfoi ajdf dasf ioajdof
	// ij
	// // jasiodfjHiihihi hjdsajfja. sdajfiaj 5555555555555 oaisdjfoasjdif
	// // kadsfjiajsidfjaihfijasdfaw gggggggggggg

	// // jasiodajsdlfjasldkfjawdsfjoaisdjfoasjdifjaosidfjo ajdfoi ajdf dasf ioajdof
	// ij
	// // jasiodfjHiihihi hjdsajfja. sdajfiaj 5555555555555 oaisdjfoasjdif
	// // kadsfjiajsidfjaihfijasdfaw gggggggggggg
	// update();
	// }

	void addNewShownDirectory(File file) {
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(),
				new RealFileSystemPopulator(file.getName(),
						file.toString())));
		update();
	}

	void addNewShownDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void addNewShownDirectory(FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setActiveColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		int currentActiveListIndex;
		if ((currentActiveListIndex = handler.getCurrentActiveListIndex()) == -1)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - handler.getCurrentActiveListIndex(),
					new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setActiveColumnDirectory(FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		int currentActiveListIndex;
		if ((currentActiveListIndex = handler.getCurrentActiveListIndex()) == -1)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - currentActiveListIndex,
					new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setFirstColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setFirstColumnDirectory(FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setLastColumnDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - 1,
					new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setLastColumnDirectory(FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - 1,
					new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void updatePopulators() {
		for (DirectoryShownFiles i : currentlyShownDirs)
			if (i.histIndex >= 0)
				i.getPopulator().update();
	}

	void update() {
		updatePopulators();
		for (DirectoryShownFiles i : currentlyShownDirs)
			if (i.histIndex >= 0)
				i.hist.get(i.histIndex).repositionRealPopulator();
		handler.models.clear();
		// handler.models.subList(1, handler.models.size()).clear();
		// this.fileContentsDisplayer.handler.models.add(new PairFSModelDirectory(
		// new FileSystemModel(
		// this.fileContentsDisplayer.populator.contents),
		// ""));
		for (DirectoryShownFiles i : currentlyShownDirs) {
			// handler.models.addAll();
			// var j = handler.models.add();
			// new FileSystemPopulator(this, , null)
			// return;: Make a populator for each of the things in the currentlyShownDirs
			if (i.getPwd().size() != 0)
				handler.models
						.add(
								// new FileSystemModel(
								// i.getPopulator().contents),
								// i.getPwd().get(i.getPwd().size() - 1)
								// newPairFSModelDirectory(i.getPopulator(),
								// i.getPwd())
								newPairFSModelDirectory(i) //
						);
			else
				handler.models
						.add(newPairFSModelDirectory(i.getPopulator(),
								i.getPopulator().categoryName));
			// handler.models.add();
			// handler.models;
		}
		handler.update();
		fileContentsDisplayer.revalidate();
		fileContentsDisplayer.repaint();
	}

	PairFSModelDirectory newPairFSModelDirectory(FileSystemModel model, String categoryName) {
		return new PairFSModelDirectory(model, categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(DirectoryShownFiles dsf) {
		// populator.contents.indexOf();
		if (dsf.getPwd().size() != 0) {
			File file = null;
			for (File i : dsf.getPopulator().contents) {
				if (i.getName().equals(dsf.getPwd().get(0))) {
					file = i;
					break;
				}
			}
			// TODO: (Urgent?) change this from printing an error message and resuming to
			// throwing an exception instead. Also change other places to support this.
			// AKA: Make a class PWDInvalidException extends <whatever class exceptions
			// extend from>
			if (file == null) {
				System.err.println("File with name " + dsf.getPopulator().categoryName + "/"
						+ dsf.getPwd()
						+ " does not exist in virtual root " + dsf.getPopulator().categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						dsf.getPopulator().contents), dsf.getPopulator().categoryName);
			}
			file = new File(
					file.getAbsolutePath() + "/" + String.join("/",
							dsf.getPwd().subList(1, dsf.getPwd().size())));
			if (!file.exists()) {
				System.err.println("File with name " + file + " does not exist in virtual root "
						+ dsf.getPopulator().categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						dsf.getPopulator().contents), dsf.getPopulator().categoryName);
			}
			// return new PairFSModelDirectory(new FileSystemModel(
			// populator.contents.toArray(new File[populator.contents.size()])),
			// categoryName);
			File[] files = file.listFiles();
			if (files == null) {
				System.err.println("File with name " + file + " does not exist in virtual root "
						+ dsf.getPopulator().categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						dsf.getPopulator().contents), dsf.getPopulator().categoryName);
			}
			return new PairFSModelDirectory(new FileSystemModel(
					files), dsf.getPwd().get(dsf.getPwd().size() - 1));
		} else
			return new PairFSModelDirectory(new FileSystemModel(
					dsf.getPopulator().contents), dsf.getPopulator().categoryName);

		// return new PairFSModelDirectory(new FileSystemModel(
		// populator.contents), categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(File[] model, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				model), categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(Collection<File> model, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				model), categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(FileSystemPopulator populator, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				populator.contents), categoryName);
		// populator.contents.toArray(new File[populator.contents.size()])
	}
}
