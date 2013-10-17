import java.util.*;
import java.io.*;

public abstract class FileIO {

   protected BufferedReader in;
   protected DataOutputStream out;
   
   public abstract void setup(String filename) throws FileNotFoundException, IOException;
   
   public void write(String message) {
      try {
         out.writeUTF(message);
      } catch(Exception e) {
         e.printStackTrace();
        }
   }
   
   public String read() {
      try {
         return in.readLine();
      } catch(Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
}