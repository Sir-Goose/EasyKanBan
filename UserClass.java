import javax.swing.*;
/*
 * This class is used to create a new user. It stores all the information of a user. It also has a
 * method to register a new user. It uses JOptionPane to display messages to the user to collect
 * input. It also uses the InputValidationClass to validate the input entered by the user.
 */
public class UserClass {

  private String UserName = "";   // stores the username of the user.
  private String Password = "";   // stores the password of the user.
  private String FirstName = "";  // stores the first name of the user.
  private String LastName = "";   // stores the last name of the user.
  private final InputValidationClass Validate =
      new InputValidationClass(); // used to validate input.
  //----------------------------------------------------------------------------------------------//
  // getters
  /* This method is used to get the username of the user. */
  public String getUserName() {
    return UserName;
  }
  /* This method is used to get the password of the user. */
  public String getPassword() {
    return Password;
  }
  /* This method is used to get the first name of the user. */
  public String getFirstName() {
    return FirstName;
  }
  /* This method is used to get the last name of the user. */
  public String getLastName() {
    return LastName;
  }
  //----------------------------------------------------------------------------------------------//
  // setters
  /* This method is used to set the username of the user. */
  public void setUserName(String userName) {
    this.UserName = userName;
  }
  /* This method is used to set the password of the user. */
  public void setPassword(String password) {
    this.Password = password;
  }
  /* This method is used to set the first name of the user. */
  public void setFirstName(String firstName) {
    this.FirstName = firstName;
  }
  /* This method is used to set the last name of the user. */
  public void setLastName(String lastName) {
    this.LastName = lastName;
  }
  //----------------------------------------------------------------------------------------------//
  public UserClass() {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This method is used to register a new user. It will prompt the user to enter a username,
    * password, first name, and last name. It will then display a message to the user with their
    * username, password, first name, and last name. It then returns the new user.
   */
  public static UserClass registerUser() {
    UserClass newUser = new UserClass(); // creates a new user.

    newUser.makeUserName();
    newUser.makePassword();
    newUser.makeFirstName();
    newUser.makeLastName();

    // displays a message to the user with their username, password, first name, and last name.
    JOptionPane.showMessageDialog(
        null,
        "Registration successful! \n" +
            "Your username is: " + newUser.getUserName() + "\n" +
            "Your password is: " + newUser.getPassword() + "\n" +
            "Your first name is: " + newUser.getFirstName() + "\n" +
            "Your last name is: " + newUser.getLastName(),
        "EasyKanban", JOptionPane.INFORMATION_MESSAGE);

    return newUser;
  }
  //----------------------------------------------------------------------------------------------//

  /* This method is used to create a username for the user.
  * It will prompt the user to enter a username. It will then validate the username. If the username
  * is valid, it will return the username. If the username is invalid, it will prompt the user to
  * enter a username again.
  */
  public String makeUserName() {
    String input; // stores the input entered by the user.

    input = JOptionPane.showInputDialog(
        null,
        "Create your username: \n" +
            "It must be no more than 5 characters in length, cannot be blank, and must contain an "
            + "underscore.",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    // validates the username. If the username is valid, it will return the username.
    UserName = Validate.validateUserName(input) ? input : makeUserName();
    return UserName;
  }
  //----------------------------------------------------------------------------------------------//
  /*
  * This method is used to create a password for the user. It will prompt the user to enter a
  * password. It will then validate the password. If the password is valid, it will return the
  * password. If the password is invalid, it will prompt the user to enter a password again.
  */
  public String makePassword() {
    String input; // stores the input entered by the user.

    input = JOptionPane.showInputDialog(
        null,
        "Create your password: \n" +
            "It must contain at least 8 characters, a special character, a number and a capital letter.",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    // validates the password. If the password is valid, it will return the password.
    Password = Validate.validatePassword(input) ? input : makePassword();
    return Password;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to create a first name for the user. It will prompt the user to enter a
   * first name. It will then validate the first name. If the first name is valid, it will return
   * the first name. If the first name is invalid, it will prompt the user to enter a first name
   * again.
   */
  public String makeFirstName() {
    String input; // stores the input entered by the user.

    input = JOptionPane.showInputDialog(
        null,
        "What is your first name: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
    // validates the first name. If the first name is valid, it will return the first name.
    FirstName = Validate.validateName(input) ? input : makeFirstName();
    return FirstName;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to create a last name for the user. It will prompt the user to enter a
   * last name. It will then validate the last name. If the last name is valid, it will return the
   * last name. If the last name is invalid, it will prompt the user to enter a last name again.
   */
  public String makeLastName() {
    String input; // stores the input entered by the user.

    input = JOptionPane.showInputDialog(
        null,
        "What is your last name: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
    // validates the last name. If the last name is valid, it will return the last name.
    LastName = Validate.validateName(input) ? input : makeLastName();
    return LastName;
  }
}
//------------------------------------END-OF-FILE-------------------------------------------------//