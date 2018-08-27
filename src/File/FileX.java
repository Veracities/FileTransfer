package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileX {
  public static void main(String[] args) throws IOException {
    Scanner read = new Scanner(System.in);
    FileX fileX = new FileX();
    int option;
    System.out.println("Welcome to FileX!");
    System.out.println("Here are your options: ");
    System.out.println("Option 0: Make a new txt file");
    System.out.println("Option 1: Transfer a file from one location to another");
    //System.out.println("");
    System.out.print("Please enter the option number: ");
    option = read.nextInt();
    if (option == 1) {
      String name = "";
      System.out.print("What would you like to name your file: ");
      name = read.nextLine();
      fileX.makeNewTXT(name);
    }
  }
  
  public void makeNewTXT(String fname) throws IOException {
    String text = "";
    ArrayList<String> textArray = new ArrayList<>();
    BufferedWriter out = null;
    Scanner read = new Scanner(System.in);
    while (!text.equals("exit")) {
      System.out.println("Enter a line that goes into the file, type exit to leave: ");
      text = read.nextLine();
      if (!text.equals("exit")) {
        textArray.add(text);
      }
    }
    try {
      File file = new File(fname + ".txt");
      out = new BufferedWriter(new FileWriter(file));
      for (int i = 0; i < textArray.size(); i++) {  
        out.write(textArray.get(i));
        out.write("\r\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
       out.close(); 
      }
    }
  }
}
