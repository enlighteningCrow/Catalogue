package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

// TODO: (Maybe?) Change this to private/public
/**
 * Class used to create an array of Files found from the specified paths
 */
// TODO: Use inheritance to make a RootFileSystemPopulator; Create the interface
// and differentiate between the ones used for normal paths and the root one
// public interface FileSystemPopulator;

public class VirtualFileSystemPopulator extends FileSystemPopulator {
	/**
	 *
	 */
	// Note: path strings with '/' separator
	// String[] searchPathsRegex;
	// String[] searchPathsGlob;
	// HashMap searchPaths
	// ArrayList<File> contents = new ArrayList<File>();
	/**
	 * Consturctor from regex and glob patterns
	 * 
	 * @param searchPathsRegex      The array of regex patterns
	 * @param searchPathsGlob       The array of glob patterns
	 * @param fileContentsDisplayer TODO
	 */
	public VirtualFileSystemPopulator(String categoryName,
			String[] searchPathsRegex,
			String[] searchPathsGlob) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		addFilters(RegexFileFilter.class, searchPathsRegex);
		addFilters(GlobFileFilter.class, searchPathsGlob);

		// this.searchPathsRegex = searchPathsRegex;
		// this.searchPathsGlob = searchPathsGlob;
		update();
	}

	// TODO: Use inheritance to differentiate the root (virtual) from the normal
	// files (real)
	// TODO: For each usage of this, use RealFileSystemPopulator instead.
	// public VirtualFileSystemPopulator(FileContentsDisplayer
	// fileContentsDisplayer, String categoryName,
	// String searchDirectory) {
	// this.fileContentsDisplayer = fileContentsDisplayer;
	// this.categoryName = categoryName;
	// addFilters(GlobFileFilter.class, searchDirectory + "/*");
	//
	// // this.searchPathsRegex = searchPathsRegex;
	// // this.searchPathsGlob = searchPathsGlob;
	// update();
	// }

	public VirtualFileSystemPopulator(String categoryName, Class<? extends FileFilter> filter,
			Collection<String> pattern) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		// addFilters(GlobFileFilter.class, "/*");

		// this.searchPathsRegex = searchPathsRegex;
		// this.searchPathsGlob = searchPathsGlob;
		addFilters(filter, pattern);
		update();
	}

	public VirtualFileSystemPopulator(String categoryName,
			Class<? extends FileFilter> filter, String[] pattern) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		// addFilters(GlobFileFilter.class, "/*");

		// this.searchPathsRegex = searchPathsRegex;
		// this.searchPathsGlob = searchPathsGlob;
		addFilters(filter, pattern);
		update();
	}

	public VirtualFileSystemPopulator(String categoryName,
			HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		// this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
		// addFilters(GlobFileFilter.class, "/*");

		// this.searchPathsRegex = searchPathsRegex;
		// this.searchPathsGlob = searchPathsGlob;
		setFilters(map);
		update();
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
	public <T extends FileFilter> void populate(int depth, String[] searchPath, File currentFile,
			Class<T> filterType) {
		Constructor<T> constructor;
		File[] files;
		try {
			// filterType.getConstructor();
			// Class<T>.getConstructor();
			// Class<Integer>.
			// System.out.println(filterType.getConstructor(Void.class.getClasses()));
			// Class
			// Constructor<RegexFileFilter> cnstrctr =
			// RegexFileFilter.class.getConstructor(String.class.getClasses()); // get
			// // the
			// // constructor
			// System.out.println(cnstrctr);
			constructor = filterType.getConstructor(new Class[] { String.class });
			// System.out.println(constructor);
			T inst = constructor.newInstance(searchPath[depth]);
			files = currentFile.listFiles(inst);
			// for (File file : files)
			// System.out.println(file);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		if (depth == searchPath.length - 1) {
			try {
				// Class[] classes = new Class[] { String.class };
				for (File i : files)
					contents.add(i);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		else if (depth < searchPath.length) {
			try {
				// return;: (URGENT) Debug what is wrong with the line below
				for (File file : files)
					populate(depth + 1, searchPath, file, filterType);
			} catch (Exception e) {
				// System.err.println(e);
				e.printStackTrace();
				System.err.println(e.getCause());
			}
		} else
			throw new RuntimeException("Depth could not exceed the length of searchPath");
	}

	/**
	 * Modifies the paths strings before sending it to the populate function
	 * 
	 * @param <T>        The type to use (Eg. RegexFileFilter, GlobFileFilter)
	 * @param paths      The array of search patterns to search for corresponding to
	 *                   the filefilter provided
	 * @param filterType The class of the filefilter (Eg. GlobFileFilter.class,
	 *                   RegexFileFilter.class)
	 */
	private <T extends FileFilter> void updateS(String[] paths, Class<T> filterType) {
		for (String searchPath : paths) {
			searchPath.replace('\\', '/');
			String[] pathComps = searchPath.split("/");
			if (pathComps.length == 0)
				throw new InvalidPathException(searchPath, "search path is empty");
			// TODO: Check if there needs to be more hardcoded path expansions (like ~ into
			// the home directory)
			if (pathComps[0].equals("~")) {
				// TODO: Check if this is right
				populate(1, pathComps, new File(System.getProperty("user.home")),
						filterType);
			} else {
				if (pathComps[0].length() == 0)
					// TODO: Check if this works in Windows OS
					// pathComps[0] = "/";
					populate(1, pathComps, new File("/"), filterType);
				else
					populate(0, pathComps, new File(System.getProperty("user.dir")), filterType);
			}
		}
	}

	/**
	 * Use this function after modifying the attributes to update the contents
	 * variable
	 */
	public void update() {
		contents.clear();
		contents = new TreeSet<File>(comparator);
		for (Entry<Class<? extends FileFilter>, ArrayList<String>> i : filters.entrySet()) {
			// TODO: Continue this; make paths for each of the filters.
			// updateS(searchPaths, i);
			updateS(Arrays.copyOf(i.getValue().toArray(), i.getValue().size(), String[].class), i.getKey());
		}
		// updateS(searchPathsRegex, RegexFileFilter.class);
		// updateS(searchPathsGlob, GlobFileFilter.class);
		// contents.sort(this.fileContentsDisplayer.fileSortComparator);
		// Collection.sort(contents, this.fileContentsDisplayer.fileSortComparator);
		// var i = GlobFileFilter.class;
		// Collection.sort(contents, this.fileContentsDisplayer.fileSortComparator);
	}

	// public ArrayList<Class<? extends FileFilter>> filters = new ArrayList<>(
	// Arrays.asList(RegexFileFilter.class, GlobFileFilter.class));
	public HashMap<Class<? extends FileFilter>, ArrayList<String>> filters = new HashMap<>();

	public void addFilters(Class<? extends FileFilter> filter, String pattern) {
		if (!this.filters.containsKey(filter)) {
			this.filters.put(filter, new ArrayList<>());
		}
		this.filters.get(filter).add(pattern);
	}

	public void addFilters(Class<? extends FileFilter> filter, Collection<String> pattern) {
		if (!this.filters.containsKey(filter)) {
			this.filters.put(filter, new ArrayList<>());
		}
		this.filters.get(filter).addAll(pattern);
	}

	public void addFilters(Class<? extends FileFilter> filter, String[] pattern) {
		if (!this.filters.containsKey(filter)) {
			this.filters.put(filter, new ArrayList<>());
		}
		for (String i : pattern)
			this.filters.get(filter).add(i);
	}

	public void setFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		filters = map;
		update();
	}

	public void addFilters(HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		filters.clear();
		// filters.addAll(list);
		filters.putAll(map);
		update();
	}

	@Override
	public FileSystemPopulator clone() {
		// TODO: Check if this is correct
		return new VirtualFileSystemPopulator(categoryName, filters);
	}
}
