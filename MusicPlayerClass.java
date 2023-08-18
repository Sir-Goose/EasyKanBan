import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
/*
  * This is the MusicPlayer Class. It is responsible for playing music. It uses the Java Sound API
  * to play music. It uses a JFrame to display two buttons, one to play music and one to stop music.
  * It uses a try-catch block to catch any exceptions that may occur.
 */
public class MusicPlayerClass {

  private Clip Clip = null; // stores the clip that is used to play music.
  //----------------------------------------------------------------------------------------------//

  public MusicPlayerClass() {
    // Default Constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This is the start() method. It is called from the main method in Main.java. It is responsible
    * for creating the JFrame and adding the buttons to it. It also sets the location of the JFrame
    * to the top right of the screen.
   */

  public void start() {
    JFrame frame = new JFrame("Music Player"); // creates the JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the default close operation
    frame.setLayout(new FlowLayout()); // sets the layout of the JFrame

    // creates two JButtons and adds an ActionListener to each of them
    JButton playButton = new JButton("Play");
    playButton.addActionListener(ButtonClicked -> playMusic());

    JButton stopButton = new JButton("Stop");
    stopButton.addActionListener(ButtonCLicked -> stopMusic());

    // adds the JButtons to the JFrame
    frame.add(playButton);
    frame.add(stopButton);

    frame.pack();
    frame.setSize(200, 75); // sets the size of the JFrame

    // Set the location of the JFrame to the top right of the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // gets the screen size
    int screenWidth = screenSize.width;
    frame.setLocation(screenWidth - frame.getWidth(), 0);

    frame.setVisible(true);
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This is the playMusic() method. It is called from the start() method. It is responsible for
    * playing music. It uses the Java Sound API to play music. It uses a try-catch block to catch
    * any exceptions that may occur.
   */
  private void playMusic() {
    try {
      File musicFile = new File("src/metallica.wav"); // creates a File object to store the
                                                               // music
      AudioInputStream audioInputStream = // creates an AudioInputStream to store the music
          AudioSystem.getAudioInputStream(musicFile);
      Clip = AudioSystem.getClip();
      Clip.open(audioInputStream);
      Clip.start(); // starts playing the music
    } catch (Exception e) {
      e.printStackTrace(); // prints the stack trace if an exception occurs
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This is the stopMusic() method. It is called from the start() method when the user clicks the
    * stopButton. It is responsible for stopping the music.
   */
  private void stopMusic() {
    if (Clip != null && Clip.isRunning()) {
      Clip.stop();
      Clip.close();
    }
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//
