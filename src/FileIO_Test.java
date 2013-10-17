/*
 * After the programs are setup, this main method should execute correctly and start reading System.out into the Swing terminal that shows up.
 * Might also port to a QT GUI?
 * Essentially, this is the test program aiming to make it as easy as possible for the end user.
 */
 
public class FileIO_Test {

   public static void main(String[] args) {
      JavaTerminalEmulator jte;
      try {
         jte = new JavaTerminalEmulator(); /* Sets up the terminal emulator with default values, essenially making it as easy as possible to start up the emulator. */
                                           /* There will eventually be options for background and text color, keyboard shortcuts, and fonts, along with the file to write to */
      } catch(Exception e) {
         /* The output here from a e.printStackTrace() should tell the user exactly what went wrong, which will probably need an extention of the Exception class */
         e.printStackTrace();
      }
      /* Testing some outputs. These should not show up in the IDE's terminal, but instead in the Swing GUI that shows up. */
      System.out.println("1");
      System.out.print("a b");
      System.out.println(" c");
      System.out.println("abc def ghi jk lm nopq rstuv wxyza bcdefg hijklm no pqr stu vwx yz abcde fghij klmn opqr stuvwxyza bcdef ghi jklmn opqr st uvw xyz"); /* Hopefully this line will wrap. */
                                                                                                                          /* I'm not exactly what a normal terminal does here. */
                                                                                                                          
   }
}