import javax.swing.*;
import java.util.Objects;
/*
 * This class is used to validate user input entered by the user. It uses JOptionPane to display
 * messages to the user if the input is invalid. All user input is passed through to this class to
 * be validated. Try and catch are used to catch any exceptions that may occur from parsing the
 * input.
 */
public class InputValidationClass {

  InputValidationClass() {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This method is used to validate the input for the number of tasks to be created. It will
    * display a message to the user if the input is invalid. It returns true if the input is valid
    * and false if the input is invalid.
   */
  public boolean checkNumTasks(String input) {
    int numTasksInt; // stores the number of tasks as an integer.
    try {
      // displays a message to the user if the input is not a number.
      numTasksInt = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid number.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    // displays a message to the user if the number of tasks is less than 1.
    if (numTasksInt < 1) {
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid number.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This method is used to validate the input for the developer's last name to be created. It will
    * display a message to the user if the input is invalid. It returns true if the input is valid
    * and false if the input is invalid.
   */
  public boolean checkDeveloperLastName(String input) {
    try {
      if (input.equals("")) { // displays a message to the user if the input is empty.
        JOptionPane.showMessageDialog(
            null,
            "Last name cannot be empty.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
    } catch (NullPointerException e) {  // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "Last name cannot be empty.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the developer's first name to be created. It will
   * display a message to the user if the input is invalid. It returns true if the input is valid
   * and false if the input is invalid.
   */
  public boolean checkDeveloperFirstName(String input) {
    try {
      if (input.equals("")) { // displays a message to the user if the input is empty.
        JOptionPane.showMessageDialog(
            null,
            "First name cannot be empty.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
    } catch (NullPointerException e) { // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "First name cannot be empty.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the name of a task. It will
   * display a message to the user if the input is invalid. It returns true if the input is valid
   * and false if the input is invalid.
   */
  public boolean checkTaskName(String input) {
    try {
      if (input.equals("")) { // displays a message to the user if the input is empty.
        JOptionPane.showMessageDialog(
            null,
            "Task name cannot be empty.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
    } catch (NullPointerException e) {  // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "Task name cannot be empty.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the description of a task. It will
   * display a message to the user if the input is invalid. It returns true if the input is valid
   * and false if the input is invalid. The description cannot be empty and cannot be longer than
   * 50 characters.
   */
  public boolean checkTaskDescription(String input) {
    try {
      if (input.equals("")) { // displays a message to the user if the input is empty.
        JOptionPane.showMessageDialog(
            null,
            "Task description cannot be empty.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      } else if (input.length() > 50) { // displays a message to the user if the input is too long.
        JOptionPane.showMessageDialog(
            null,
            "Task description cannot be longer than 50 characters.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
    } catch (NullPointerException e) { // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "Task description cannot be empty.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the duration of a task. It will
   * display a message to the user if the input is invalid. It returns true if the input is valid
   * and false if the input is invalid. The duration must be greater than 0.
   */
  public boolean checkTaskDuration(String input) {
    try {
      int durationInt = Integer.parseInt(input);
      if (durationInt < 1) {  // displays a message to the user if the input is less than 1.
        JOptionPane.showMessageDialog(
            null,
            "Task duration must be greater than 0.",
            "EasyKanban",
            JOptionPane.INFORMATION_MESSAGE);
        return false;
      }
      // displays a message to the user if the input is not a number.
    } catch (NumberFormatException | NullPointerException e) {
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid number.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the status of a task. It will
   * display a message to the user if the input is invalid. It returns true if the input is valid
   * and false if the input is invalid. It only checks that the status is not null or empty as the
   * status is set by buttons with pre-defined values.
   */
  public boolean checkTaskStatus(String input) {
    // null check
    return !Objects.requireNonNull(input).isEmpty();
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the username of a user. It will display a message
   * to the user if the input is invalid. It returns true if the input is valid and false if the
   * input is invalid. The username must be less than 5 characters and must contain an underscore.
   */
  public boolean validateUserName(String input) {
    try {
      // checks that the input is not empty, is less than 5 characters, and contains an underscore.
      if (!Objects.equals(input, "") && input.length() <= 5 && input.contains("_")) {
        return true;
      }
      JOptionPane.showMessageDialog( // displays a message to the user if the input is invalid.
          null,
          "Please enter a valid username.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    } catch (NullPointerException e) { // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid username.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the password of a user. It will display a message
   * to the user if the input is invalid. It returns true if the input is valid and false if the
   * input is invalid. The password must be at least 8 characters long, contain an uppercase letter,
   * a number, and a special character.
   */
  public boolean validatePassword(String input) {
    try {
      // checks that the input is not empty, is at least 8 characters long, contains an uppercase
      // letter, a number, and a special character.
      if (!Objects.equals(input, "") &&
          input.length() >= 8 &&
          input.matches(".*[A-Z].*") &&
          input.matches(".*[0-9].*") &&
          input.matches(".*[!@#$%^&*].*")) {
        return true;
      }
    } catch (NullPointerException e) { // displays a message to the user if the input is null
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid password.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return false;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to validate the input for the name of a task. It will display a message
   * to the user if the input is invalid. It returns true if the input is valid and false if the
   * input is invalid. The name cannot be empty.
   */
  public boolean validateName(String input) {
    if (input.equals("")) { // displays a message to the user if the input is empty.
      JOptionPane.showMessageDialog(
          null,
          "Please enter a valid name.",
          "EasyKanban",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    if (!Objects.requireNonNull(input).isEmpty()) { // checks that the input is not empty.
      return true;
    }
    JOptionPane.showMessageDialog(  // displays a message to the user if the input is invalid.
        null,
        "Please enter a valid name.",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
    return false;
  }
}
//---------------------------------------------END-OF-FILE----------------------------------------//




