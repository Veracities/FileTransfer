package File;

import java.io.*;
import java.net.*;

public class fileclient{
  Socket sr;
  public fileclient(int port, String host, String path) {
    try {
      sr = new Socket(host, port);
      fileC(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void fileC(String path) throws IOException {
    // Where to store the data when transfering
    byte[] b = new byte[2002];
    
    InputStream is = sr.getInputStream();
    // Destination path
    FileOutputStream fr = new FileOutputStream(path);
    
    // Read data from server then write to new file
    is.read(b, 0,b.length);
    fr.write(b, 0, b.length);
    
    fr.close();
    System.out.println("File transfer success!");
  }
  
  public static void main(String[] args) {
    fileclient fc = new fileclient(5000,"localhost","D:\\copied.txt");
  } 
}