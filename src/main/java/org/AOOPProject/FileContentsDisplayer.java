/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.AOOPProject;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author twistingcamel
 */
public class FileContentsDisplayer extends javax.swing.JPanel {
	/**
	 * Creates new form FileContentsDisplayer
	 */

	public FileContentsDisplayer() {
		initComponents();
		update();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				formFocusGained(evt);
			}
		});
		setLayout(new java.awt.GridBagLayout());
	}// </editor-fold>//GEN-END:initComponents

	private void formFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_formFocusGained
	}// GEN-LAST:event_formFocusGained

	/**
	 * the maximum number of columns to show on the screen at any moment (drop down
	 * lists / jLists)
	 */
	int maxColumnNumber;
	/**
	 * The file populator for the class
	 */
	public FileSystemPopulator populator = new RealFileSystemPopulator("sbin",
			"/usr/sbin");
	/**
	 * The comparator used to sort the files;
	 */
	public Comparator<File> fileSortComparator = new FileComparators.NameAscendingComparator();

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables

	public Comparator<File> getFileSortComparator() {
		return fileSortComparator;
	}

	public void setFileSortComparator(Comparator<File> fileSortComparator) {
		this.fileSortComparator = fileSortComparator;
		populator.setComparator(this.fileSortComparator);
	}

	/**
	 * Constructor from a an array of regex and glob strings
	 * 
	 * @param fileSearchPathsRegex the regex strings array
	 * @param fileSearchPathsGlob  the glob strings array
	 */
	public FileContentsDisplayer(String categoryName, String[] fileSearchPathsRegex, String[] fileSearchPathsGlob) {
		populator = new VirtualFileSystemPopulator(categoryName, fileSearchPathsRegex,
				fileSearchPathsGlob);
		// currentFilePath = new File[0];
		initComponents();
		update();
	}

	/**
	 * Constructor from a an array of glob strings
	 * 
	 * @param fileSearchPathsGlob the glob strings array
	 */
	public FileContentsDisplayer(String categoryName, String[] fileSearchPathsGlob) {
		populator = new VirtualFileSystemPopulator(categoryName, GlobFileFilter.class,
				fileSearchPathsGlob);
		// currentFilePath = new File[0];
		initComponents();
		update();
	}

	/**
	 * enum to pass to the function below; used to identify whether array of strings
	 * passed should be interpreted as glob or regex
	 */
	enum Mode {
		GLOB, REGEX
	}

	/**
	 * Constructor used when only one of glob or regex is used (not both)
	 * 
	 * @param fileSearchPathsUnspecified An array of the glob/regex search strings
	 * @param mode                       Specify whether the provided array should
	 *                                   be interpreted as glob or regex
	 */

	ListColumnsHandler handler = new ListColumnsHandler(this, 3);

	void update() {
		bridge.update();
		populator.update();
		handler.update();
	}

	/**
	 * Creates a deep copy of this object
	 * 
	 * @return a deep copy of this object
	 */
	public FileContentsDisplayer copy() {
		return new FileContentsDisplayer();
	}

	PopulatorColumnsBridge bridge = new PopulatorColumnsBridge(this);

	public FileContentsDisplayer(File[] files) {
		initComponents();
		for (File file : files)
			bridge.addNewShownDirectory(file);
		update();
	}

	public FileContentsDisplayer(File file) {
		initComponents();
		bridge.addNewShownDirectory(file);
		update();
	}
}