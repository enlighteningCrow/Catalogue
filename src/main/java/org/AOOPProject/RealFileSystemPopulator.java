package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class RealFileSystemPopulator extends FileSystemPopulator {
	public RealFileSystemPopulator(String categoryName,
			File searchDirectory, Collection<String> pwd) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		this.pwd = new ArrayList<>(pwd);
		rootFile = searchDirectory;
		// System.out.println(rootFile);
		reposition();
		update();
	}

	public RealFileSystemPopulator(String categoryName,
			String searchDirectory, Collection<String> pwd) {
		this(categoryName, new File(searchDirectory.replace("~", System.getProperty("user.home"))), pwd);
	}

	public RealFileSystemPopulator(String categoryName, String searchDirectory) {
		this(categoryName, searchDirectory, new ArrayList<>());
	}

	static String getName(File file) {
		String name = file.getName();
		if (name.trim().length() == 0)
			name = file.getPath();
		return name;
	}

	public RealFileSystemPopulator(File searchDirectory) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		// this(searchDirectory.getName(), searchDirectory.getPath());
		// setRootFile(searchDirectory);
		// // System.out.println(rootFile);
		// update();

		this(getName(searchDirectory), searchDirectory, new ArrayList<>());
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
			for (File i : files)
				this.contents.add(i);

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
		this.categoryName = getName(rootFile);
		this.rootFile = rootFile;
		reposition();
	}

	@Override
	public FileSystemPopulator clone() {
		// TODO: Check if this is correct
		return new RealFileSystemPopulator(categoryName, rootFile, pwd);
	}

	private static void repositionR(RealFileSystemPopulator pop) {
		String[] pathComps = pop.getRootFile().getAbsolutePath().replace('\\', '/').split("/");
		// System.out.println(Paths.get(pop.getRootFile().getPath()).getRoot().toFile());
		// System.out.println(Paths.get(pop.getRootFile().getAbsolutePath()));
		// System.out.println(Paths.get(pop.getRootFile().getAbsolutePath()).getRoot());
		pop.rootFile = Paths.get(pop.getRootFile().getAbsolutePath()).getRoot().toFile();
		for (int i = 1; i < pathComps.length; ++i) {
			String s = pathComps[i];
			// System.out.println(s);
			if (s.trim().length() != 0)
				pop.pwd.add(s);
		}
		// System.out.println(pop.pwd);
	}

	private static void reposition(RealFileSystemPopulator pop) {
		if (pop.pwd.size() != 0) {
			// System.err.println("Populator pwd not empty");
			ArrayList<String> prev = new ArrayList<>(pop.pwd);
			pop.pwd.clear();
			repositionR(pop);
			pop.pwd.addAll(prev);
		} else
			repositionR(pop);
		pop.categoryName = getName(pop.rootFile);
	}

	public void reposition() {
		reposition(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("RealFileSystemPopulator [");
		builder.append(rootFile);
		for (String i : pwd) {
			builder.append('/');
			builder.append(i);
		}
		return builder + "]";
	}

}
