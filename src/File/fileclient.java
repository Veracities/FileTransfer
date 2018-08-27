package File;

import java.io.*;
import java.net.*;

public class fileclient {
  static String cpath = "D:\\copied.txt";
  
  public fileclient(String path) {
    cpath = path;
  }
  
  public static void main(String[] args) throws Exception {
    //Initialize socket
    Socket socket = new Socket("localhost", 5000);
    byte[] content = new byte[10000];
    
    //Initialize the FileOutputStream to the output file's full path.
    FileOutputStream fr = new FileOutputStream(cpath);
    BufferedOutputStream br = new BufferedOutputStream(fr);
    InputStream is = socket.getInputStream();
    
    //No of bytes read in one read() call
    int bytesRead = 0; 
    
    while((bytesRead=is.read(content))!=-1)
        br.write(content, 0, bytesRead); 
    
    br.flush(); 
    socket.close(); 
    System.out.println("File transferred successfully!");
  }

}
