import javax.swing.*;
import javax.swing.text.*;
import java.io.*;

public class JavaTerminalEmulator {
   
   private JFrame frame;
   private TerminalEmulator te;
   
   /* We'll need more constructors eventually. */
   public JavaTerminalEmulator() throws BadLocationException, FileNotFoundException, IOException {
      setupGUI();
   }
   
   /* This will eventually take parameters for color and whatnot */
   public void setupGUI() throws BadLocationException, FileNotFoundException, IOException  { 
      te = new TerminalEmulator();
      
      /* Sets the swing look and feel to that of the system one. */
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch(Exception e) {
         /* Nothing. Should just use the default look and feel if an error occurs. */
      }

        
      frame = new JFrame("Java Terminal Emulator"); /* For now. */
      frame.setSize(TerminalEmulator.WIDTH, TerminalEmulator.HEIGHT);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(te);
      frame.setVisible(true);
   }
   
}
   
   