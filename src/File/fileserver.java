package File;

import java.io.*;
import java.net.*;

public class fileserver extends Thread{
  ServerSocket s;
  
  public fileserver(int port) {
    try {
      s = new ServerSocket(port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void run() {
    while (true) {
       try {
         fileclient.main(null);
         Socket sr = s.accept();
         fileS(sr);
       } catch (IOException e) {
         e.printStackTrace();
       }
    } 
  }
  
  public void fileS(Socket sr) throws IOException {
    FileInputStream fr=new FileInputStream("D:\\testing.txt");
    // Byte array to store data when transferring
    byte b[]=new byte[4004];
    
    fr.read(b, 0, b.length);
    OutputStream os = sr.getOutputStream();
    os.write(b, 0, b.length);
    
    fr.close();
  }
  
  public static void main(String[] args) {
    fileserver fs = new fileserver(5000);
    fs.start();
  } 
}