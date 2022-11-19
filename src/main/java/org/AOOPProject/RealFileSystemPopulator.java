package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

import org.AOOPProject.ListColumnsHandler.PairFSModelDirectory;

public class RealFileSystemPopulator extends FileSystemPopulator {
	public RealFileSystemPopulator(String categoryName,
			File searchDirectory, Collection<String> pwd) {
		this.categoryName = categoryName;
		this.pwd = new ArrayList<>(pwd);
		rootFile = searchDirectory;
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

	public RealFileSystemPopulator(File searchDirectory) {
		this(utils.getName(searchDirectory), searchDirectory, new ArrayList<>());
	}

	public RealFileSystemPopulator(String categoryName, File searchDirectory) {
		this(searchDirectory.getName(), searchDirectory.getPath());
	}

	File rootFile;

	@Override
	public void update() {
		contents.clear();
		contents = new TreeSet<File>(comparator);
		File[] files = new File(rootFile.getAbsolutePath() + String.join("/", pwd)).listFiles();
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
		this.categoryName = utils.getName(rootFile);
		this.rootFile = rootFile;
		reposition();
	}

	@Override
	public FileSystemPopulator clone() {
		return new RealFileSystemPopulator(categoryName, rootFile, pwd);
	}

	private static void repositionR(RealFileSystemPopulator pop) {
		String[] pathComps = pop.getRootFile().getAbsolutePath().replace('\\', '/').split("/");
		pop.rootFile = Paths.get(pop.getRootFile().getAbsolutePath()).getRoot().toFile();
		for (int i = 1; i < pathComps.length; ++i) {
			String s = pathComps[i];
			if (s.trim().length() != 0)
				pop.pwd.add(s);
		}
	}

	private static void reposition(RealFileSystemPopulator pop) {
		if (pop.pwd.size() != 0) {
			ArrayList<String> prev = new ArrayList<>(pop.pwd);
			pop.pwd.clear();
			repositionR(pop);
			pop.pwd.addAll(prev);
		} else
			repositionR(pop);
		pop.categoryName = utils.getName(pop.rootFile);
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

	@Override
	PairFSModelDirectory getPairFSModelDirectory() {
		String currentPath = "";
		int i = pwd.size();
		while (currentPath.trim().length() == 0 && i > 0) {
			currentPath = pwd.get(--i);
		}
		if (currentPath.trim().length() == 0)
			currentPath = categoryName;
		return new PairFSModelDirectory(new FileSystemModel(contents), currentPath);
	}
}
