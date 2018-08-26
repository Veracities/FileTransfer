package File;

import java.io.*;
import java.net.*;

public class fileserver {
  private int portNum;
  private String spath;
  
  public fileserver(int port, String path) {
    portNum = port;
    spath = path;
  }
  
  public static void main(String[] args) throws Exception {
    ServerSocket s = new ServerSocket(5643);
    // Accepting the connection from client
    Socket sr = s.accept();
    // Location of the file
    FileInputStream fr = new FileInputStream("D://");
    // Byte Array to store the file during transfer
    byte b[] = new byte[4000];
    
    fr.read(b,0, b.length);
    // Convert byte array to a stream for transfer
    OutputStream os = sr.getOutputStream();
    os.write(b,0,b.length);
    
    fr.close();
    s.close();
  }
}