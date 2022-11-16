package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

// public class FileSystemRootPopulator {
//
// }
public abstract class FileSystemPopulator {
	protected FileContentsDisplayer fileContentsDisplayer;
	// Note: path strings with '/' separator
	// String[] searchPathsRegex;
	// String[] searchPathsGlob;
	// HashMap searchPaths
	// ArrayList<File> contents = new ArrayList<File>();
	TreeSet<File> contents = new TreeSet<File>();

	String categoryName = "";

	/**
	 * Just a getter
	 * 
	 * @return contents
	 */
	// public ArrayList<File> getContents() {
	// return contents;
	// }
	public TreeSet<File> getContents() {
		return contents;
	}

	/**
	 * Update the variable ${contents} using the populate function with the paths
	 * found from the search
	 * 
	 * @param <T>         The type to use (Eg. RegexFileFilter, GlobFileFilter)
	 * @param depth       The current depth of the search (recursive depth)
	 * @param searchPath  The path that is currently being searched; split into an
	 *                    array. (Eg. "/home/pi/asm" into {"/", "home", "pi", *
	 *                    "asm"})
	 * @param currentFile The current file that is currently being searched (The
	 *                    deepest file reached so far in the recursive search)
	 * @param filterType  The class of the filefilter (Eg. GlobFileFilter.class,
	 *                    RegexFileFilter.class)
	 */
	abstract public <T extends FileFilter> void populate(int depth, String[] searchPath, File currentFile,
			Class<T> filterType);

	abstract public void update();

	public Comparator<File> comparator = new FileComparators.NameAscendingComparator();

	public void setComparator(Comparator<File> comp) {
		comparator = comp;
		update();
	}

	// public ArrayList<Class<? extends FileFilter>> filters = new ArrayList<>(
	// Arrays.asList(RegexFileFilter.class, GlobFileFilter.class));
	public HashMap<Class<? extends FileFilter>, ArrayList<String>> filters = new HashMap<>();

	abstract public void addFilters(Class<? extends FileFilter> filter, String pattern);

	abstract public void addFilters(Class<? extends FileFilter> filter, Collection<String> pattern);

	abstract public void addFilters(Class<? extends FileFilter> filter, String[] pattern);

	abstract public void setFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map);

	abstract public void addFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map);

	abstract public FileSystemPopulator clone();
}