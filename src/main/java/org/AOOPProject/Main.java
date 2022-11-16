package org.AOOPProject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

// public class Main {
//     class A {
//         int a;

//         public A(Integer a) {
//             this.a = a;
//         }
//     }

//     public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException {
//         // System.out.println("Hello world!");
//         // new MainWindow();
//         String testStr = "/usr/local/bin/..";
//         File file = new File(testStr);
//         for (String i : testStr.split("/"))
//             System.out.println(i);
//         System.out.println(file);
//         System.out.println(file.exists());
//         for (File i : file.listFiles())
//             System.out.println(i);
//         File file2 = new File(System.getProperty("user.home"));
//         System.out.println(file2);
//         System.out.println(file2.exists());
//         File file3 = new File("/");
//         System.out.println(file3);
//         System.out.println(file3.exists());
//         // Pattern.compile("*");
//         // TODO: Check if the Glob works (check if File.toPath() gives absolute path or
//         // path tail)
//         System.out.println(file2.toPath().getFileName());
//         PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:twi*mel");
//         System.out.println(matcher.matches(file2.toPath().getFileName()));
//         System.out.println(matcher.matches(file2.toPath()));
//         String[] paths = { "~/*", "/*" };
//         // FileContentsDisplayer i = new FileContentsDisplayer(paths);
//         // System.out.println(i.populator.contents);
//         // i.setVisible(true);
//         // JFrame frame = new JFrame();
//         // frame.add(i);
//         // frame.setVisible(true);
//         // i.pack();
//         Class i = A.class;
//         i.getConstructor(Integer.class.getClasses());
//     }

// }

// Java program to demonstrate getConstructors() method

import java.util.*;

class Main {

        public Object obj;

        private Main() {

                class Arr {
                }
                ;

                obj = new Arr();
        }

        public static void main(String[] args)
                        throws ClassNotFoundException {
                // returns the Class object for this class
                // Class myClass = Class.forName("Main");

                // System.out.println("Class represented by myClass: "
                // + myClass.toString());

                // // Get the constructors of myClass
                // // using getConstructors() method
                // System.out.println(
                // "Constructors of myClass: "
                // + Arrays.toString(
                // myClass.getConstructors()));
                File file = new File("/jaiodsfjoaidsf");
                System.out.println(file.exists());
                // for (File f : file.listFiles())
                // System.out.println(f);
        }
}

// public class Main {
// public Main(String str) {
// System.out.println(str);
// }

// public Main(int a, int b) {
// System.out.println("Sum is " + (a + b));
// }

// public static void main(String[] args) throws Exception {
// Main a = new Main(24, 436);
// Class<Main> mainClass = Main.class;
// Constructor<Main> constructorStr = mainClass.getConstructor(String.class);
// constructorStr.newInstance("Hello, world!");

// Constructor<Main> constructorInts = mainClass.getConstructor(int.class,
// int.class);
// constructorInts.newInstance(2, 3);
// }
// }