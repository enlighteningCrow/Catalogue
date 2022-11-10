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
    // -TODO: Maybe add more comparators, and insert them into the
    // Hello I
}
