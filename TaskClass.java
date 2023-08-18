import javax.swing.*;
import java.util.ArrayList;

public class TaskClass {
  /*
    * This class is used to create Task objects. It contains the following attributes: taskName,
    * developerFirstName, developerLastName, taskNumber, duration, status, ID, and description. It
    * also contains the following methods: getters, setters, toString, and registerTask.
    * registerTask is used to register a new task. It uses JOptionPane to display messages to the
    * user to collect input. It also uses the InputValidationClass to validate the input entered by
    * the user. It then returns the new task.
   */

  private final InputValidationClass Validate =
      new InputValidationClass();  // used to validate input.
  private String TaskName = ""; // stores the name of the task.
  private String DeveloperFirstName = ""; // stores the first name of the developer.
  private String DeveloperLastName = "";  // stores the last name of the developer.
  private int TaskNumber = 0; // stores the number of the task.
  private int Duration = 0; // stores the duration of the task.
  private String Status = ""; // stores the status of the task.
  private String ID = ""; // stores the ID of the task.
  private String Description = "";  // stores the description of the task.

  public TaskClass() {
    // default constructor
  }
  //----------------------------------------------------------------------------------------------//

  // getters
  /* This method is used to get the name of the task. */
  public String getName() {
    return TaskName;
  }
  /* This method is used to get the first name of the developer. */
  public String getDeveloperFirstName() {
    return DeveloperFirstName;
  }
  /* This method is used to get the last name of the developer. */
  public String getDeveloperLastName() {
    return DeveloperLastName;
  }
  /* This method is used to get the number of the task. */
  public int getNumber() {
    return TaskNumber;
  }
  /* This method is used to get the duration of the task. */
  public int getDuration() {
    return Duration;
  }
  /* This method is used to get the status of the task. */
  public String getStatus() {
    return Status;
  }
  /* This method is used to get the ID of the task. */
  public String getID() {
    return ID;
  }
  /* This method is used to get the description of the task. */
  public String getDescription() {
    return Description;
  }
  /* This method is used to get the developer of the task. */
  public String getDeveloper() {
    return DeveloperFirstName + " " + DeveloperLastName;
  }
  //----------------------------------------------------------------------------------------------//
  // setters
  /* This method is used to set the name of the task. */
  public void setName(String name) {
    this.TaskName = name;
  }
  /* This method is used to set the first name of the developer. */
  public void setDeveloperFirstName(String developerFirstName) {
    this.DeveloperFirstName = developerFirstName;
  }
  /* This method is used to set the last name of the developer. */
  public void setDeveloperLastName(String developerLastName) {
    this.DeveloperLastName = developerLastName;
  }
  /* This method is used to set the number of the task. */
  public void setNumber(int number) {
    this.TaskNumber = number;
  }
  /* This method is used to set the duration of the task. */
  public void setDuration(int duration) {
    this.Duration = duration;
  }
  /* This method is used to set the status of the task. */
  public void setStatus(String status) {
    this.Status = status;
  }
  /* This method is used to set the ID of the task. */
  public void setID(String ID) {
    this.ID = ID;
  }
  /* This method is used to set the description of the task. */
  public void setDescription(String description) {
    this.Description = description;
  }
  //----------------------------------------------------------------------------------------------//

  /* Overrided toString method. Returns all the information contained in a Task object as
   * a single well formatted String as needed by the ReportClass
   */
  @Override
  public String toString() {
    return "Task Name: " + TaskName + "\n" +
        "Developer: " + DeveloperFirstName + " " + DeveloperLastName + "\n" +
        "Task Number: " + TaskNumber + "\n" +
        "Duration: " + Duration + "\n" +
        "Status: " + Status + "\n" +
        "ID: " + ID + "\n" +
        "Description: " + Description + "\n";
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to register a new task. It uses JOptionPane to display messages to the
   * user to collect input. It also uses the InputValidationClass to validate the input entered by
   * the use to check that they have entered a number. If the user input is valid it adds it to
   * tasks array list. If the user input is invalid it calls itself again to ask the user to enter
   * a valid input.
   */
  public int addTasks(ArrayList<TaskClass> tasks) {
    int numTasks; // stores the number of tasks to be created.

    String input = JOptionPane.showInputDialog( // ask the user to enter the number of tasks.
        null,
        "How many tasks would you like to create?",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    numTasks = Validate.checkNumTasks(input) ? Integer.parseInt(input) : addTasks(tasks); // check
    // that the user has entered a number. If they have not, call the method again.

    while (tasks.size() < numTasks) { // create the number of tasks the user has entered.
      tasks.add(makeTask(tasks.size() + 1));
      displayTask(tasks.get(tasks.size() - 1));
    }
    return numTasks;  // return the number of tasks created.
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This method is used to make new tasks. It calls every method required to create a new task.
    * It then returns the new task.
   */
  public TaskClass makeTask(int taskNumber) {
    TaskClass task = new TaskClass();
    task.TaskNumber = taskNumber;
    task.makeTaskName();
    task.makeTaskDescription();
    task.enterTaskDuration();
    task.chooseTaskStatus();
    task.makeTaskDeveloperFirstName();
    task.makeTaskDeveloperLastName();
    task.generateTaskID();
    return task;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method takes in a task object as a paremeter. It uses StringBuilder to create a string
   * containing all the information about the task. It then uses JOptionPane to display the string
   * to the user.
   */

  public void displayTask(TaskClass task) {
    StringBuilder taskDetails = new StringBuilder();
    taskDetails.append("Task Status: ").append(task.getStatus()).append("\n");
    taskDetails.append("Developer Details: ").append(task.getDeveloperFirstName()).append(" ")
        .append(task.getDeveloperLastName()).append("\n");
    taskDetails.append("Task Number: ").append(task.getNumber()).append("\n");
    taskDetails.append("Task Name: ").append(task.getName()).append("\n");
    taskDetails.append("Task Description: ").append(task.getDescription()).append("\n");
    taskDetails.append("Task ID: ").append(task.getID()).append("\n");
    taskDetails.append("Duration: ").append(task.getDuration()).append(" hours\n");

    // print out the task details
    JOptionPane.showMessageDialog(
        null,
        taskDetails,
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * Generates the taskID. It uses the first two letters of the task name, the task number and the
   * last three letters of the developer's first name. It then converts the string to uppercase.
   * This method is called by the makeTask method.
   */
  private void generateTaskID() {
    this.ID = TaskName.substring(0, 2) + ":" + TaskNumber + ":" + DeveloperFirstName.substring(
        DeveloperFirstName.length() - 3);
    this.ID = ID.toUpperCase();
  }
  //----------------------------------------------------------------------------------------------//
  /*
    * This method is used to enter the take in the developer's last name. It uses JOptionPane to
    * display messages to the user to collect input. It also uses the InputValidationClass to
    * validate the input entered by the use to check that they have entered a valid name. If the
    * user input is valid it sets the DeveloperLastName to the input. If the user input is invalid
    * it calls itself again to ask the user to enter a valid input.
   */
  private String makeTaskDeveloperLastName() {
    String input; // stores the user input.

    input = JOptionPane.showInputDialog(
        null,
        "Enter the developer's last name: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    this.DeveloperLastName =
        Validate.checkDeveloperLastName(input) ? input : makeTaskDeveloperLastName(); // check that
    // the user has entered a valid name. If they have not, call the method again.
    return DeveloperLastName;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to enter the take in the developer's first name. It uses JOptionPane to
   * display messages to the user to collect input. It also uses the InputValidationClass to
   * validate the input entered by the use to check that they have entered a valid name. If the
   * user input is valid it sets the DeveloperFirstName to the input. If the user input is invalid
   * it calls itself again to ask the user to enter a valid input.
   */
  private String makeTaskDeveloperFirstName() {
    String input; // stores the user input.

    input = JOptionPane.showInputDialog(
        null,
        "Enter the developer's first name: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    this.DeveloperFirstName =
        Validate.checkDeveloperFirstName(input) ? input : makeTaskDeveloperFirstName(); // check
    // that the user has entered a valid name. If they have not, call the method again.
    return DeveloperFirstName;
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This method is used to enter the take in the TaskName. It uses JOptionPane to
   * display messages to the user to collect input. It also uses the InputValidationClass to
   * validate the input entered by the use to check that they have entered a valid name. If the
   * user input is valid it sets the TaskName to the input. If the user input is invalid
   * it calls itself again to ask the user to enter a valid input.
   */
  public String makeTaskName() {
    String input; // stores the user input.

    input = JOptionPane.showInputDialog(
        null,
        "Enter the task name: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    this.TaskName = Validate.checkTaskName(input) ? input : makeTaskName(); // check that the user
    // has entered a valid name. If they have not, call the method again.
    return TaskName;
  }
  /*
   * This method is used to enter the take in the TaskDescription. It uses JOptionPane to
   * display messages to the user to collect input. It also uses the InputValidationClass to
   * validate the input entered by the use to check that they have entered a valid description of
   * less than 50 characters. If the user input is valid it sets the TaskDescription to the input.
   * If the user input is invalid it calls itself again to ask the user to enter a valid input.
   */
  public String makeTaskDescription() {
    String input; // stores the user input.

    input = JOptionPane.showInputDialog(
        null,
        "Enter the task description: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);
    // check that the user has entered a valid description. If they have not, call the method again.
    this.Description = Validate.checkTaskDescription(input) ? input : makeTaskDescription();
    return Description;
  }
  //----------------------------------------------------------------------------------------------//
  /*
  * This method takes in user input for the task duration. It uses JOptionPane to display messages
  * to the user to collect input. It also uses the InputValidationClass to validate the input
  * entered by the use to check that they have entered a valid duration. If the user input is
  * valid it sets the Duration to the input. If the user input is invalid it calls itself again to
  * ask the user to enter a valid input.
  */
  public int enterTaskDuration() {
    String input; // stores the user input.

    input = JOptionPane.showInputDialog(
        null,
        "Enter the task duration: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE);

    // check that the user has entered a valid duration. If they have not, call the method again.
    this.Duration =
        Validate.checkTaskDuration(input) ? Integer.parseInt(input) : enterTaskDuration();
    return Duration;
  }
  //----------------------------------------------------------------------------------------------//
  /*
  * This method sets the status of the task. It can be "To Do", "In Progress" or "Done". It uses
  * JOptionPane to display messages to the user to collect input. It also uses the
  * InputValidationClass to validate the input entered by the use to check that they have entered a
  * valid status. If the user input is valid it sets the Status to the input. If the user input is
  * invalid it calls itself again recursively to ask the user to enter a valid input.
   */
  public String chooseTaskStatus() {
    String[] options; // stores the options for the JOptionPane.
    String input; // stores the user input.
    options = new String[]{
        "To Do", "In Progress", "Done" // the options for the JOptionPane.
    };

    input = (String) JOptionPane.showInputDialog( // display the JOptionPane and casts the input to
        null,                                     // a string.
        "Choose the task status: ",
        "EasyKanban",
        JOptionPane.INFORMATION_MESSAGE,
        null,
        options,
        options[0]);
    // check that the user has entered a valid status. If they have not, call the method again.
    this.Status = Validate.checkTaskStatus(input) ? input : chooseTaskStatus();
    return Status;
  }
}
//---------------------------------END-OF-FILE----------------------------------------------------//
