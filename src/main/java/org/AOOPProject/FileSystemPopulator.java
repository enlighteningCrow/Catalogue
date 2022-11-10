package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// TODO: (Maybe?) Change this to private/public
/**
 * Class used to create an array of Files found from the specified paths
 */
public class FileSystemPopulator {
    /**
     *
     */
    private final FileContentsDisplayer fileContentsDisplayer;
    // Note: path strings with '/' separator
    String[] searchPathsRegex;
    String[] searchPathsGlob;
    // ArrayList<File> contents = new ArrayList<File>();
    TreeSet<File> contents = new TreeSet<File>();

    /**
     * Consturctor from regex and glob patterns
     * 
     * @param searchPathsRegex      The array of regex patterns
     * @param searchPathsGlob       The array of glob patterns
     * @param fileContentsDisplayer TODO
     */
    public FileSystemPopulator(FileContentsDisplayer fileContentsDisplayer, String[] searchPathsRegex,
            String[] searchPathsGlob) {
        this.fileContentsDisplayer = fileContentsDisplayer;
        this.searchPathsRegex = searchPathsRegex;
        this.searchPathsGlob = searchPathsGlob;
        update();
    }

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
     * Used for filtering files with regex patterns
     */
    public class RegexFileFilter implements FileFilter {
        protected Pattern pattern;

        public Pattern getPattern() {
            return pattern;
        }

        public void setPattern(Pattern pattern) {
            this.pattern = pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        // -TODO: check the regex part, something wrong
        public RegexFileFilter(String pattern) {
            try {
                this.pattern = Pattern.compile(pattern);
            } catch (PatternSyntaxException e) {
                System.err.println(e);
            }
        }

        @Override
        public boolean accept(File pathname) {
            return pattern.matcher(pathname.getName()).matches();
        }

    }

    /**
     * Used for filtering files with glob patterns
     */
    public class GlobFileFilter implements FileFilter {
        PathMatcher matcher;

        public void setGlob(String glob) {
            this.matcher = FileSystems.getDefault().getPathMatcher(glob);
        }

        public GlobFileFilter(PathMatcher matcher) {
            this.matcher = matcher;
        }

        public GlobFileFilter(String glob) {
            // TODO: Fix this
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
        }

        @Override
        public boolean accept(File pathname) {
            return matcher.matches(pathname.toPath().getFileName());
        }
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
        try {
            filterType.getConstructor(String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (depth == searchPath.length - 1) {
            try {
                for (File i : currentFile.listFiles(
                        filterType.getConstructor(String.class)
                                .newInstance(searchPath[depth])))
                    contents.add(i);
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        else if (depth < searchPath.length) {
            try {
                for (File file : currentFile.listFiles(
                        filterType.getConstructor(String.class)
                                .newInstance(searchPath[depth])))
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
                    pathComps[0] = "/";
                populate(0, pathComps, new File(pathComps[0]), filterType);
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
        for (Class<? extends FileFilter> i : filters) {
            // TODO: Continue this; make paths for each of the filters.
            updateS(searchPaths, i);
        }
        // updateS(searchPathsRegex, RegexFileFilter.class);
        // updateS(searchPathsGlob, GlobFileFilter.class);
        // contents.sort(this.fileContentsDisplayer.fileSortComparator);
        // Collection.sort(contents, this.fileContentsDisplayer.fileSortComparator);
        // var i = GlobFileFilter.class;
        // Collection.sort(contents, this.fileContentsDisplayer.fileSortComparator);
    }

    public Comparator<File> comparator = new FileComparators.NameAscendingComparator();

    public void setComparator(Comparator<File> comp) {
        comparator = comp;
        update();
    }

    public ArrayList<Class<? extends FileFilter>> filters = new ArrayList<>(
            Arrays.asList(RegexFileFilter.class, GlobFileFilter.class));

    public void setFilters(Collection<Class<? extends FileFilter>> list) {
        filters.clear();
        filters.addAll(list);
        update();
    }
}