package org.AOOPProject;

import java.io.File;
import java.util.Comparator;

public class FileComparators {
    static public class NameAscendingComparator implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            return o1.toPath().getFileName().compareTo(o2.toPath().getFileName());
        }
    }

    static public class NameDescendingComparator implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            return o2.toPath().getFileName().compareTo(o1.toPath().getFileName());
        }
    }

    // TODO: This. Also add the menu item using ViewButtonsGroup
    static public class TypeAscendingComparator implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            if (o1.isDirectory() != o2.isDirectory())
                return o1.isDirectory() ? -1 : 1;
            else
                return o1.toPath().getFileName().compareTo(o2.toPath().getFileName());
        }
    }

    static public class TypeDescendingComparator implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            if (o1.isDirectory() != o2.isDirectory())
                return o1.isDirectory() ? 1 : -1;
            else
                return o1.toPath().getFileName().compareTo(o2.toPath().getFileName());
        }
    }
}
