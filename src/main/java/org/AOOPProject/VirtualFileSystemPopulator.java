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

import org.AOOPProject.ListColumnsHandler.PairFSModelDirectory;

/**
 * Class used to create an array of Files found from the specified paths
 */
public class VirtualFileSystemPopulator extends FileSystemPopulator {
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
		this.categoryName = categoryName;
		addFilters(RegexFileFilter.class, searchPathsRegex);
		addFilters(GlobFileFilter.class, searchPathsGlob);
		update();
	}

	public VirtualFileSystemPopulator(String categoryName, Class<? extends FileFilter> filter,
			Collection<String> pattern) {
		this.categoryName = categoryName;
		addFilters(filter, pattern);
		update();
	}

	public VirtualFileSystemPopulator(String categoryName,
			Class<? extends FileFilter> filter, String[] pattern) {
		this.categoryName = categoryName;
		addFilters(filter, pattern);
		update();
	}

	public VirtualFileSystemPopulator(String categoryName,
			HashMap<Class<? extends FileFilter>, ArrayList<String>> map) {
		this.categoryName = categoryName;
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
			constructor = filterType.getConstructor(new Class[] { String.class });
			T inst = constructor.newInstance(searchPath[depth]);
			files = currentFile.listFiles(inst);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		if (depth == searchPath.length - 1) {
			try {
				for (File i : files)
					contents.add(i);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		else if (depth < searchPath.length) {
			try {
				for (File file : files)
					populate(depth + 1, searchPath, file, filterType);
			} catch (Exception e) {
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
			if (pathComps[0].equals("~")) {
				populate(1, pathComps, new File(System.getProperty("user.home")),
						filterType);
			} else {
				if (pathComps[0].length() == 0)
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
			updateS(Arrays.copyOf(i.getValue().toArray(), i.getValue().size(), String[].class), i.getKey());
		}
	}

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
		filters.putAll(map);
		update();
	}

	@Override
	public FileSystemPopulator clone() {
		return new VirtualFileSystemPopulator(categoryName, filters);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("VirtualFileSystemPopulator [{");
		boolean first = true;
		for (Entry<Class<? extends FileFilter>, ArrayList<String>> i : filters.entrySet()) {
			if (first)
				first = false;
			else
				builder.append(", ");
			builder.append(i);
		}
		builder.append("}");

		for (String i : pwd) {
			builder.append('/');
			builder.append(i);
		}
		return builder + "]";
	}

	@Override
	PairFSModelDirectory getPairFSModelDirectory() {
		if (pwd.size() != 0) {
			File file = null;
			for (File i : this.contents) {
				if (i.getName().equals(pwd.get(0))) {
					file = i;
					break;
				}
			}
			if (file == null) {
				System.err.println("File with name " + this.categoryName + "/"
						+ pwd
						+ " does not exist in virtual root " + this.categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						this.contents), this.categoryName);
			}
			file = new File(
					file.getAbsolutePath() + "/" + String.join("/",
							pwd.subList(1, pwd.size())));
			if (!file.exists()) {
				System.err.println("File with name " + file + " does not exist in virtual root "
						+ this.categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						this.contents), this.categoryName);
			}
			File[] files = file.listFiles();
			if (files == null) {
				System.err.println("File with name " + file + " does not exist in virtual root "
						+ this.categoryName);
				return new PairFSModelDirectory(new FileSystemModel(
						this.contents), this.categoryName);
			}
			return new PairFSModelDirectory(new FileSystemModel(
					files), pwd.get(pwd.size() - 1));
		} else
			return new PairFSModelDirectory(new FileSystemModel(
					this.contents), this.categoryName);
	}
}
