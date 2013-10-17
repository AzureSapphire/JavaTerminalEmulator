/* This is a JPanel that will eventually be implemented in the JavaTerminalEmulator for the final GUI.
 * TODO: fonts, colors, etc.
 * TODO: Input!
 */
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TerminalEmulator extends JPanel {
   
   protected JTextPane textPane;
   protected boolean run = true;
   protected JTE_FileIO f;
   protected StyledDocument doc;
   
   public final int HEIGHT = 300;
   public final int WIDTH = 500;
   
   public TerminalEmulator() throws BadLocationException, FileNotFoundException, IOException {
      setup();
   }
   
   /* Add more constructors for color, font, etc. */
   
   
   public void setup() throws BadLocationException, FileNotFoundException, IOException {    
       textPane = new JTextPane();
       textPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
       add(textPane);
       doc = textPane.getStyledDocument();
       f = new JTE_FileIO();
       
       /* Creates a new Thread handled by Swing to constantly read in from the file and display the output in the GUI. */
       /* If we didn't create a separate thread, the GUI would freeze up. */
       new SwingWorker<Object, Object>() {
         protected Object doInBackground() throws Exception {
            while(run == true) {
               if(f.in.ready()) {
                  String text = f.read();
                  try {
                     doc.insertString(doc.getLength(), text + "\n", null);
                     Thread.sleep(100);
                  } catch(Exception e) {
                     e.printStackTrace();
                  }
               }
            }
            return null;
         }
       }.execute();
       
   }
   
   /* This is only for testing, all of this will be actually done in the constructor of JavaTerminalEmulator. */
   public static void main(String[] args) {
      JFrame frame = new JFrame("Title");
      frame.setSize(500,500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      try {
         frame.add(new TerminalEmulator());
      } catch(Exception e) {
         e.printStackTrace();
      }
      frame.pack();
      frame.setVisible(true);
      
      
      
      /* Some code I wrote a long time ago, a guessing game in the terminal */
      //Declaring stuff
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int random;
		int guess = 0;
		int counter = 0;
		String win;
		
		//Input a win message
		System.out.println("Enter your desired win message:");
		win = in.nextLine();
		
		//Random number
		random = r.nextInt(1000)+1;
		
		
		//Here begins the loop, utilising do-while
		do {
		System.out.println("Enter your guess, 1 through 1000:  ");
		guess = in.nextInt();
		
		if (guess > random) {
		System.out.println("Too High!");
		counter = counter + 1;
		}
		
		else if (guess < random) {
		System.out.println("Too Low!");
		counter = counter + 1;
		}
		
		else if (guess == random) {
		System.out.println("RIGHT!!!");
		System.out.println(win);
		System.out.println("Number of guesses used:  " + counter);
		System.exit(0);
		}
		else { //do nothing here
		}
		}
		
		while (guess != random);

   }
   
}