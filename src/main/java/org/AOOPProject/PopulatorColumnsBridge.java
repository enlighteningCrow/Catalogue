package org.AOOPProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.AOOPProject.ListColumnsHandler.PairFSModelDirectory;

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

	static class DirectoryShownFiles {
		ArrayList<String> pwd;
		VirtualFileSystemPopulator populator;

		DirectoryShownFiles(Collection<String> pwd, VirtualFileSystemPopulator populator) {
			this.pwd = new ArrayList<>(pwd);
			this.populator = populator;
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
				new VirtualFileSystemPopulator(this.fileContentsDisplayer, file.getName(),
						file.toString())));
		update();
	}

	void addNewShownDirectory(Collection<String> pathFromCategory, VirtualFileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void addNewShownDirectory(VirtualFileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setActiveColumnDirectory(Collection<String> pathFromCategory, VirtualFileSystemPopulator populator) {
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

	void setActiveColumnDirectory(VirtualFileSystemPopulator populator) {
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

	void setFirstColumnDirectory(Collection<String> pathFromCategory, VirtualFileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setFirstColumnDirectory(VirtualFileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
		else
			currentlyShownDirs.set(0, new DirectoryShownFiles(new ArrayList<String>(), populator));
		update();
	}

	void setLastColumnDirectory(Collection<String> pathFromCategory, VirtualFileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator and pathFromCategory instead of themselves
		if (currentlyShownDirs.size() == 0)
			currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
		else
			currentlyShownDirs.set(currentlyShownDirs.size() - 1, new DirectoryShownFiles(pathFromCategory, populator));
		update();
	}

	void setLastColumnDirectory(VirtualFileSystemPopulator populator) {
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
		for (DirectoryShownFiles i : currentlyShownDirs) {
			i.populator.update();
		}
	}

	void update() {
		updatePopulators();
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
			if (i.pwd.size() != 0)
				handler.models
						.add(new PairFSModelDirectory(
								new FileSystemModel(
										i.populator.contents),
								i.pwd.get(i.pwd.size() - 1)));
			else
				handler.models
						.add(newPairFSModelDirectory(i.populator, i.populator.categoryName));
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

	PairFSModelDirectory newPairFSModelDirectory(File[] model, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				model), categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(Collection<File> model, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				model), categoryName);
	}

	PairFSModelDirectory newPairFSModelDirectory(VirtualFileSystemPopulator populator, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				populator.contents.toArray(new File[populator.contents.size()])), categoryName);
	}
}
