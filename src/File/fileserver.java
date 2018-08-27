package File;

import java.io.*;
import java.net.*;

public class fileserver {
   static String spath = "D:\\testing.txt";
  
  public fileserver(String path) {
    spath = path;
  }
  
  public static void main(String[] args) throws Exception {
    // Initalize Socket
    ServerSocket s = new ServerSocket(5000);
    Socket sr = s.accept();
    
    // Location of the file
    File file = new File(spath);
    FileInputStream fr = new FileInputStream(file);
    BufferedInputStream br = new BufferedInputStream(fr);
    
    OutputStream os = sr.getOutputStream();
    
    //Read file into array
    byte content[];
    long fileLen = file.length();
    int size = 10000;
    content = new byte[size];
    br.read(content,0,size);
    os.write(content);
    System.out.println("Sending file...");
    
    os.flush();
    sr.close();
    s.close();
    System.out.println("File Transferred");
  }
}
