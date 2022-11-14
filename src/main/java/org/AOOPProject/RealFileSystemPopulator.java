package org.AOOPProject;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class RealFileSystemPopulator extends FileSystemPopulator{
	public RealFileSystemPopulator(FileContentsDisplayer fileContentsDisplayer, String categoryName,
			String searchDirectory) {
		this.fileContentsDisplayer = fileContentsDisplayer;
		this.categoryName = categoryName;
        file_temp = new File(searchDirectory);
		update();
	}

    File file_temp;

    @Override
    public void update(){
        contents.clear();
        contents = new TreeSet<File>(comparator);
        for (File i : file_temp.listFiles()){
            this.contents.add(i);
        }
    }

    @Override
    public <T extends FileFilter> void populate(int depth, String[] searchPath, File currentFile, Class<T> filterType) {
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
}