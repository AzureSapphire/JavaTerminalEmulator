import java.util.*;
import java.io.*;

/* For testing only */
import javax.swing.*;

public class JTE_FileIO extends FileIO {
   
   public JTE_FileIO() throws FileNotFoundException, IOException {
      setup("default.jte");
   }
   
   public JTE_FileIO(String filename) throws FileNotFoundException, IOException {
      setup(filename);
   }
   
   @Override
   public void setup(String filename) throws FileNotFoundException, IOException {
      out = new DataOutputStream(new FileOutputStream(filename));   
      in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));  /* Wrapping to inherit useful methods */
      System.setOut(new PrintStream(out)); /* Sets the default system output stream, so System.out is redirected to the file. */
   }
   
}