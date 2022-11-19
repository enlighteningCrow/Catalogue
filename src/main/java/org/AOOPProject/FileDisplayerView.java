package org.AOOPProject;

import java.io.File;

import javax.swing.ListCellRenderer;

public interface FileDisplayerView extends ListCellRenderer<File>, FileDisplayerLayout {
	static public FileDisplayerView geDefault() {
		return new DetailsView();
	}
}
