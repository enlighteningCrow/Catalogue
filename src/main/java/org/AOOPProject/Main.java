package org.AOOPProject;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        // new MainWindow();
        String testStr = "/usr/local/bin/..";
        File file = new File(testStr);
        for (String i : testStr.split("/"))
            System.out.println(i);
        System.out.println(file);
        System.out.println(file.exists());
        for (File i : file.listFiles())
            System.out.println(i);
        File file2 = new File(System.getProperty("user.home"));
        System.out.println(file2);
        System.out.println(file2.exists());
        File file3 = new File("/");
        System.out.println(file3);
        System.out.println(file3.exists());
    }
}