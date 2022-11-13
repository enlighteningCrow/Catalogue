package org.AOOPProject;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.AbstractListModel;

/**
 * This class is used to provide a model for the file system; used as
 * 
 * Backend for the lists in ListColumnHandler
 */
public class FileSystemModel extends AbstractListModel<File> {
	File[] files;

	public FileSystemModel(File[] files) {
		this.files = files;
	}

	public FileSystemModel(Collection<File> files) {
		Object[] fiArr = files.toArray();
		this.files = Arrays.copyOf(fiArr, fiArr.length, File[].class);
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	@Override
	public File getElementAt(int index) {
		return files[index];
	}

	@Override
	public int getSize() {
		return files.length;
	}

}
