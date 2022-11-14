package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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

    // return;: check the regex part, something wrong
    public RegexFileFilter() {
        this.pattern = Pattern.compile("");
    }

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