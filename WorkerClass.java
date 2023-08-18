import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
* This class is the main class of the program. It is responsible for the welcome menu and login
* logic. It also creates the report class and starts it. JFrames are used to display the welcome
* menu and JOptionPane is used to display messages to the user to collect input.
*/
public class WorkerClass {

  private boolean LoggedIn = false; // used for the program to keep track if a user is logged in.
  private final ArrayList<UserClass> Users = new ArrayList<>(); // stores all registered users.

  WorkerClass() {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
  * This is the start() method. It is called from the main method in Main.java. It is responsible
  * for choosing between displaying the welcome menu or starting the report class. If the user is
  * not logged in, the welcome menu is displayed. If the user is logged in, the report class is
  * started.
  */
  public void start() {
    if (!LoggedIn) {
      welcomeMenu();
    } else {
      new ReportClass();
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
  * This is the login() method. It is called from the welcomeMenu() method. It is responsible for
  * logging in a user. It uses a while loop to keep asking for a username and password until a
  * valid username and password are entered. If the user is not registered, the user is prompted to
  * first register. If the user is registered, the user is prompted to enter a valid username and
  * password.
   */
  private void login(ArrayList<UserClass> users) {
    String userName;  // stores the username entered by the user.
    String password;  // stores the password entered by the user.
    boolean isValid = false; // used to keep track if the username and password have been validated.

    // if there are no users registered, the user is prompted to register.
    if (users.isEmpty()) {
      showNoUsersRegisteredMsg();
      welcomeMenu();
      return;
    }
    // while loop to keep asking for a username and password until a valid username and password are
    // entered.
    while (!isValid) {
      userName = getUserInput("Enter your username: ");
      password = getUserInput("Enter your password: ");
      // for loop to check if the username and password entered match those of a register user.
      for (UserClass user : users) {
        if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
          isValid = true;
          LoggedIn = true;
          new ReportClass();
          break;
          // if the username and password entered do not match those of a registered user, the user
          // is prompted to enter a valid username and password.
        } else {
          showInvalidCredentialsMsg();
          welcomeMenu();
        }
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is a simple method to display a message to the user if the username and password entered
   * do not match those of a registered user.
   */
  private void showInvalidCredentialsMsg() {
    JOptionPane.showMessageDialog(
        null,
        "Invalid username or password. Please try again.",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is a simple method to display a message to the user if there are no registered users.
   */
  private void showNoUsersRegisteredMsg() {
    JOptionPane.showMessageDialog(
        null,
        "No users registered. Please register before logging in.",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method displays a message to the user and collects input from the user.
   */
  private String getUserInput(String prompt) {
    return JOptionPane.showInputDialog(
        null,
        prompt,
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the welcomeMenu() method. It is called from the start() method. It is responsible for
   * displaying the welcome menu and prompting the user to choose an option. The user can choose to
   * register, login, or quit the program.
   */
  public void welcomeMenu() {
    JFrame frame = new JFrame("EasyKanban"); // creates a JFrame to display the welcome menu.

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(450, 115); // sets the size of the JFrame.
    frame.setLayout(new FlowLayout()); // sets the layout of the JFrame.

    /* creates two JLabels to display messages to the user. The labels are then added to
     * the JFrame
     */

    JLabel label = new JLabel("Welcome to EasyKanban! Please choose an option.\n");
    JLabel label1 = new JLabel(
        "NOTE: You must register and then login before you can create tasks.\n");

    frame.add(label);
    frame.add(label1);

    JButton quitButton = new JButton("Quit"); // creates a JButton to quit the program.
    JButton loginButton = new JButton("Login"); // creates a JButton to login a user.
    JButton registerButton = new JButton("Register"); // creates a JButton to register a user.

    quitButton.addActionListener(ButtonClicked -> System.exit(0)); // quits the program.

    // calls the login() method to log in a user and closes the JFrame.
    loginButton.addActionListener(ButtonClicked -> {
      frame.dispose();
      login(Users);
    });
    // calls the registerUser() method to register a user and then recursively calls the
    // welcomeMenu() method.
    registerButton.addActionListener(ButtonClicked -> {
      UserClass newUser = UserClass.registerUser();
      Users.add(newUser);
      welcomeMenu();
    });

    frame.add(registerButton);  // adds the registerButton to the JFrame.
    frame.add(loginButton); // adds the loginButton to the JFrame.
    frame.add(quitButton);  // adds the quitButton to the JFrame.

    frame.setLocationRelativeTo(null); // centers the JFrame on the screen.
    frame.setVisible(true); // makes the JFrame visible.
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//

