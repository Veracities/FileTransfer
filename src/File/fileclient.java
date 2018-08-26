package File;

import java.io.*;
import java.net.*;

public class fileclient {
  int portNum;
  String cpath;
  
  public fileclient(int port, String path) {
    portNum = port;
    cpath = path;
  }
  
  public static void main(String[] args) throws Exception {
    Socket sr = new Socket("localhost", 5643);
    // Byte array to store data during transfer
    byte b[] = new byte[4000];
    InputStream is = sr.getInputStream();
    FileOutputStream fr = new FileOutputStream("D:\\");
    
    // Read data from byte array
    is.read(b,0,b.length);
    // Write the file to the destination
    fr.write(b,0,b.length);
   
    fr.close();
    sr.close();
  }

}
