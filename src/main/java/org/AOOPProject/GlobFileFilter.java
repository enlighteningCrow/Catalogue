package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

/**
 * Used for filtering files with glob patterns
 */
public class GlobFileFilter implements FileFilter {
    PathMatcher matcher;

    public void setGlob(String glob) {
        this.matcher = FileSystems.getDefault().getPathMatcher(glob);
    }

    public GlobFileFilter() {
        matcher = FileSystems.getDefault().getPathMatcher("glob:");
    }

    public GlobFileFilter(String glob) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
    }

    @Override
    public boolean accept(File pathname) {
        return matcher.matches(pathname.toPath().getFileName());
    }
}