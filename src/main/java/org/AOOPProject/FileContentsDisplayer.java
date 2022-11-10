/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.AOOPProject;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// import javax.swing.AbstractListModel;
// import javax.swing.JList;
// import javax.swing.JScrollPane;
import javax.swing.*;

import java.awt.*;

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
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                setLayout(new java.awt.GridBagLayout());
        }// </editor-fold>//GEN-END:initComponents

        // Additional variables
        // private File currentPath;

        /**
         * This class is used to provide a model for the file system; used as
         * 
         * Backend for the lists in ListColumnHandler
         */
        class FileSystemModel extends AbstractListModel<File> {
                File[] files;

                public FileSystemModel(File[] files) {
                        this.files = files;
                }

                public FileSystemModel(ArrayList<File> files) {
                        this.files = (File[]) files.toArray();
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

        /**
         * The current path: eg. {home, Downloads, downloadedFile1.txt}
         */
        File[] currentFilePath;

        // -TODO: Make a class to handle a an array of JList that stores the files and
        // update them and their models
        // Note: Only one layer deeper than the currently selected file
        // (currentFilePath[currentFilePath.length - 1]) should be shown in the jLists.
        // TODO: Make a variable (setting) to store the maximum number of columns up the
        // directory that should be shown
        // TODO: manage the cursor position with shortcuts from the keyboard.
        /**
         * the maximum number of columns to show on the screen at any moment (drop down
         * lists / jLists)
         */
        int maxColumnNumber;

        // private File[] getLeftCol() {
        // // if (currentFilePath.length == 0) {
        // // return currentFilePath[currentFilePath.length -1 ]
        // // }
        // return new File[0];
        // }

        // private File[] getMiddleCol() {
        // // return currentPath.getParentFile().listFiles();
        // return new File[0];
        // }

        // private File[] getRightCol() {
        // // return currentPath.listFiles();
        // return new File[0];
        // }

        // private FileSystemModel leftModel = new FileSystemModel(getLeftCol()),
        // middleModel = new FileSystemModel(getMiddleCol()),
        // righModel = new FileSystemModel(getRightCol());

        // private void updateMiddleModel() {
        // middleModel.setFiles(currentPath.getParentFile().listFiles());
        // }

        // TODO: Change this to private/protected when done debugging
        /**
         * The file populator for the class
         */
        public FileSystemPopulator populator;
        // TODO: Make a setter function for the below variable; make it also update the
        // GUI when called.
        /**
         * The comparator used to sort the files;
         */
        public Comparator<File> fileSortComparator = new FileComparators.NameAscendingComparator();
        // -TODO: Change the below jLists; use a resizable array of them instead, such
        // that
        // there can be a variable number for columns

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
        public FileContentsDisplayer(String[] fileSearchPathsRegex, String[] fileSearchPathsGlob) {
                populator = new FileSystemPopulator(this, fileSearchPathsRegex, fileSearchPathsGlob);
                currentFilePath = new File[0];
                initComponents();
        }

        /**
         * Constructor from a an array of glob strings
         * 
         * @param fileSearchPathsGlob the glob strings array
         */
        public FileContentsDisplayer(String[] fileSearchPathsGlob) {
                populator = new FileSystemPopulator(this, new String[0], fileSearchPathsGlob);
                currentFilePath = new File[0];
                initComponents();
        }

        /**
         * enum to pass to the function below; used to identify whehter aray of strings
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
        public FileContentsDisplayer(String[] fileSearchPathsUnspecified, Mode mode) {
                switch (mode) {
                        case GLOB:
                                populator = new FileSystemPopulator(this, new String[0], fileSearchPathsUnspecified);
                                break;
                        case REGEX:
                                populator = new FileSystemPopulator(this, fileSearchPathsUnspecified, new String[0]);
                                break;
                        default:
                                populator = new FileSystemPopulator(this, new String[0], new String[0]);
                                break;
                }
                currentFilePath = new File[0];
                initComponents();
        }

        ListColumnsHandler handler = new ListColumnsHandler(this, 3);

        void update() {
                populator.update();
                handler.update();
                bridge.update();
        }

        /**
         * Creates a deep copy of this object
         * 
         * @return a deep copy of this object
         */
        public FileContentsDisplayer copy() {
                // TODO: create a method to deep copy the members of this class into a new
                // object.
                // Purpose: for splits
                // TODO: create a class inheriting JPanel that helps handle splitting in a grid
                // (like in vim's ctrl+w s/v/c) and implement a way to move between splits (like
                // in vim's ctrl+w h/j/k/l)
                return new FileContentsDisplayer();
        }

        // TODO: Make methods to navigate the tree (eg. go to parent directory, go to
        // first child directory, etc.)
        // TODO: Make methods to navigate the lists themselves (maybe add them as
        // shortcut keys, where h, j, k, l and left, down, up, right move the cursor
        // around the interface)
        // TODO: GUI: settings: paths to search: make a GUI (like vscode settings ui) to
        // edit them
        // TODO: Make a class to read the JSON
        // TODO: (Maybe) Use the File Dialog in the vscode ui to select for paths to add
        // TODO: (Continued) (Maybe) GUI: add button to insert wildcard (regex or glob)
        // TODO: Connect the leftmost buttons to the searchPathsRegex,Glob
        // TODO: Connect the upper textedit to represent the current path (pwd)
        // TODO: Make a way to edit the outer folders while making the inner folders
        // remain (in the alternative data structre (not tree, but descriptions based
        // structure))
        // TODO: Hi
        // HELLO IAIAIAIAIAIAIA
        class PopulatorColumnsBridge {
                ArrayList<File> pwd;

                void changeRoot(int index) {
                        pwd.clear();
                        pwd.add(populator.contents.get(index));
                        // jasiodfjoaisdjfoasjdif
                        update();
                }

                void update() {
                        handler.models.clear();
                        // handler.models.subList(1, handler.models.size()).clear();
                        // handler.models.add(new FileSystemModel(populator.contents));
                        for (File i : pwd) {
                                // new FileSystemPopulator(this, , null)
                        }
                }
        }

        PopulatorColumnsBridge bridge = new PopulatorColumnsBridge();
}