package File;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class filetrans {  
  public static void main(String[] args) {
    String path;
    int port = 5000;
    filetrans ft = new filetrans();
    //String beginPath = ft.getPath(0);
    //String endPath = ft.getPath(1);s
    //port = ft.getPort();
    fileserver fs = new fileserver(port);
  }
  
  private String getPath(int option) {
    String path = "";
    Scanner read = new Scanner(System.in);
    if (option == 0) {
      System.out.print("Please Enter the path of the file: ");
    }
    else if (option == 1){
      System.out.print("Please enter the path of the destination: ");
    }
    path = read.nextLine();
    
    return path;
  }
  
  private int getPort() {
     int port = 0;
     Scanner read = new Scanner(System.in);
     System.out.print("Please Enter the port number: ");
     port = read.nextInt();
     return port;
  }
  
}
