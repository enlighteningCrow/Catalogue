package org.AOOPProject;

//import statements  
import java.lang.reflect.*;

public class ClassgetConstructorExample1 {

   public static void main(String[] args) throws NoSuchMethodException, SecurityException {

      // try {

      // Class<String> clsarray[] = new Class[] { String.class }; // creating array
      Constructor<String> cnstrctr = String.class.getConstructor(String.class.getClasses()); // get the constructor
      System.out.println(cnstrctr); // print the constructor
      // } catch (Exception e) {
      // System.out.println(e); // print exception object
      // }
   }
}