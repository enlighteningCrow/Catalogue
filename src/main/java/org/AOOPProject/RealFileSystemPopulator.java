package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class RealFileSystemPopulator extends FileSystemPopulator {
	public RealFileSystemPopulator(String categoryName,
			String searchDirectory) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		rootFile = new File(searchDirectory.replace("~", System.getProperty("user.home")));
		System.out.println(rootFile);
		update();
	}

	public RealFileSystemPopulator(File searchDirectory) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		// this(searchDirectory.getName(), searchDirectory.getPath());
		setRootFile(searchDirectory);
		System.out.println(rootFile);
		update();
	}

	public RealFileSystemPopulator(String categoryName, File searchDirectory) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this(searchDirectory.getName(), searchDirectory.getPath());
	}

	File rootFile;

	@Override
	public void update() {
		// System.out.println(rootFile);
		contents.clear();
		contents = new TreeSet<File>(comparator);
		File[] files = rootFile.listFiles();
		if (files != null)
			for (File i : files) {
				this.contents.add(i);
			}
	}

	@Override
	public <T extends FileFilter> void populate(int depth, String[] searchPath, File currentFile,
			Class<T> filterType) {
		return;

	}

	@Override
	public void addFilters(Class<? extends FileFilter> filter, String pattern) {
		return;

	}

	@Override
	public void addFilters(Class<? extends FileFilter> filter, Collection<String> pattern) {
		return;

	}

	@Override
	public void addFilters(Class<? extends FileFilter> filter, String[] pattern) {
		return;

	}

	@Override
	public void setFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		return;

	}

	@Override
	public void addFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		return;

	}

	public File getRootFile() {
		return rootFile;
	}

	public void setRootFile(File rootFile) {
		String name = rootFile.getName();
		if (name.trim().length() != 0)
			this.categoryName = name;
		else
			this.categoryName = rootFile.getPath();
		this.rootFile = rootFile;
	}

	@Override
	public FileSystemPopulator clone() {
		// TODO: Check if this is correct
		return new RealFileSystemPopulator(categoryName, rootFile);
	}
}
