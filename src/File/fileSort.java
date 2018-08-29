package File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class fileSort {
  public static void main(String[] args) {
    File currDir = new File(".");
    ArrayList<String> newlist = new ArrayList<String>();
    newlist = getAllFiles(currDir); 
    // Sort files alphabetically
    Collections.sort(newlist);
    // Print all files
    toString(newlist);
  }   
  
  private static ArrayList<String> getAllFiles(File currDir) {
    // List all files in the curr directory
    File[] filelist = currDir.listFiles();
    ArrayList<String> newlist = new ArrayList<String>();
    for (File f: filelist) {
      // Check if its a directory
      if (f.isDirectory()) {
        //getAllFiles(f); for subdir
        newlist.add(f.getName());
      }
      // Check if its a file
      else if (f.isFile()) {
        newlist.add(f.getName());
      }
    }
    return newlist;
  }
  
  private static void toString(ArrayList<String> filelist) {
    for (String i: filelist) {
      System.out.println(i);
    }
  }
}
