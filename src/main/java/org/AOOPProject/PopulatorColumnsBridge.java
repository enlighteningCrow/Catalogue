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

	/**
	 * @param fileContentsDisplayer
	 */
	PopulatorColumnsBridge(FileContentsDisplayer fileContentsDisplayer) {
		this.fileContentsDisplayer = fileContentsDisplayer;
	}

	static class DirectoryShownFiles {
		ArrayList<String> pwd;
		FileSystemPopulator populator;

		DirectoryShownFiles(Collection<String> pwd, FileSystemPopulator populator) {
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
				new FileSystemPopulator(this.fileContentsDisplayer, file.getName(),
						file.toString())));
	}

	void addNewShownDirectory(Collection<String> pathFromCategory, FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		currentlyShownDirs.add(new DirectoryShownFiles(pathFromCategory, populator));
	}

	void addNewShownDirectory(FileSystemPopulator populator) {
		// TODO: (Not sure if necessary but check here if bug occurs): send a deep copy
		// of populator instead of itself
		currentlyShownDirs.add(new DirectoryShownFiles(new ArrayList<String>(), populator));
	}

	void updatePopulators() {
		for (DirectoryShownFiles i : currentlyShownDirs) {
			i.populator.update();
		}
	}

	void update() {
		updatePopulators();
		this.fileContentsDisplayer.handler.models.clear();
		// handler.models.subList(1, handler.models.size()).clear();
		// this.fileContentsDisplayer.handler.models.add(new PairFSModelDirectory(
		// new FileSystemModel(
		// this.fileContentsDisplayer.populator.contents),
		// ""));
		for (DirectoryShownFiles i : currentlyShownDirs) {
			// handler.models.addAll();
			// var j = handler.models.add();
			// new FileSystemPopulator(this, , null)
			// TODO: Make a populator for each of the things in the currentlyShownDirs
			if (i.pwd.size() != 0)
				this.fileContentsDisplayer.handler.models
						.add(new PairFSModelDirectory(
								new FileSystemModel(
										i.populator.contents),
								i.pwd.get(i.pwd.size() - 1)));
			else
				this.fileContentsDisplayer.handler.models
						.add(newPairFSModelDirectory(i.populator, i.populator.categoryName));
			// handler.models.add();
			// handler.models;
		}
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

	PairFSModelDirectory newPairFSModelDirectory(FileSystemPopulator populator, String categoryName) {
		return new PairFSModelDirectory(new FileSystemModel(
				populator.contents.toArray(new File[populator.contents.size()])), categoryName);
	}
}
