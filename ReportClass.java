import java.util.ArrayList;
import javax.swing.*;
import java.awt.GridLayout;
/*
 * This class consists primarily of a JFrame and various methods to execute the function of the
 * JButtons in the JFrame. The JFrame is used to display the menu to the user and the JButtons are
 * used for the user to execute the various functions of the program. The methods are called from
 * the ActionListeners of the JButtons. JOptionPane is used to display messages to the user.
 * An array list is used to store the tasks created by the user.
 */
public class ReportClass {
  private final ArrayList<TaskClass> Tasks = new ArrayList<>(); // stores all tasks created by the
                                                                // user.
  private final TaskClass Task = new TaskClass(); // used to create a new task.

  //----------------------------------------------------------------------------------------------//
  /*
   * This is the default constructor. It is called from the start() method in WorkerClass.java. It
   * calls the showMenu() method to display the menu to the user upon the creation of a new
   * ReportClass object.
   */
  public ReportClass() {
    showMenu();
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the showMenu() method. It is called from the default constructor. It is responsible for
   * displaying the menu to the user. It uses a JFrame to display the menu and JButtons to allow the
   * user to execute the various functions of the program. The methods called from the JButtons are
   * defined below.
   */
  public void showMenu(){
    JFrame frame = new JFrame("EasyKanban");  // creates a new JFrame.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the default close operation.

    JPanel panel = new JPanel(new GridLayout(8, 1));  // creates a new JPanel
                                                                // with a 1x8 grid layout.

    // Creation of the JButtons.
    JButton buttonA = new JButton("Create Tasks");
    JButton buttonB = new JButton("Display 'Done' Tasks");
    JButton buttonC = new JButton("Display Longest Task");
    JButton buttonD = new JButton("Search Task Name");
    JButton buttonE = new JButton("Display Tasks by Developer");
    JButton buttonF = new JButton("Delete Task");
    JButton buttonG = new JButton("Full Report");
    JButton buttonH = new JButton("Quit");

    // ActionListeners for the JButtons.
    buttonA.addActionListener(ActionEvent -> Task.addTasks(Tasks));
    buttonB.addActionListener(ActionEvent -> displayDoneTasks());
    buttonC.addActionListener(ActionEvent -> displayLongestTask());
    buttonD.addActionListener(ActionEvent ->
            searchTaskName(takeInput("Enter Task Name:")));
    buttonE.addActionListener(ActionEvent ->
            displayTasksByDeveloper(takeInput("Enter Developer Name:")));
    buttonF.addActionListener(ActionEvent ->
            deleteTask(takeInput("Enter Task Name:")));
    buttonG.addActionListener(ActionEvent -> fullReport());
    buttonH.addActionListener(ActionEvent -> System.exit(0));

    // Adding the JButtons to the JPanel.
    panel.add(buttonA);
    panel.add(buttonB);
    panel.add(buttonC);
    panel.add(buttonD);
    panel.add(buttonE);
    panel.add(buttonF);
    panel.add(buttonG);
    panel.add(buttonH);

    // Adding the JPanel to the JFrame.
    frame.getContentPane().add(panel);

    // Display the window.
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the displayTasksByDeveloper() method. It is called from the showMenu() method. It is
   * responsible for displaying all the tasks assigned to a specific developer. It uses a
   * JOptionPane to get the name of the developer from the user. It then uses a for loop to iterate
   * through the array list and display the information about each task assigned to the developer
   * using the printTask() method.
   */
  private void displayTasksByDeveloper(String developer) {
    for (TaskClass task : Tasks) {
      if (task.getDeveloper().equals(developer)) {
        printTask(task);
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the fullReport() method. It is called from the showMenu() method. It is
   * responsible for displaying all the information about every task in the array list. It uses a
   * JOptionPane to display the information to the user. It uses a for loop to iterate through the
   * array list and display the information about each task using the printTask() method.
   */
  private void fullReport() {
    for (TaskClass task : Tasks) {
      printTask(task);
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the deleteTask() method. It is called from the showMenu() method. It is responsible for
   * deleting a task from the array list. It uses a JOptionPane to get the name of the task to be
   * deleted from the user. It then uses a for loop to iterate through the array list and delete the
   * task with the name entered by the user.
   */
  private void deleteTask(String taskName) {
    for (TaskClass task : Tasks) {
      if (task.getName().equals(taskName)) {
        Tasks.remove(task);
        JOptionPane.showMessageDialog(null, "Task Deleted");
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the searchTaskName() method. It is called from the showMenu() method. It is responsible
   * for searching for a task by name and displaying the task to the user. It uses the printTask()
   * method to display the task to the user. It uses a JOptionPane to get the name of the task to be
   * searched for from the user. It then uses a for loop to iterate through the array list.
   */
  private void searchTaskName(String taskName) {
    for (TaskClass task : Tasks) {
      if (task.getName().equals(taskName)) {
        printTask(task);
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the displayLongestTask() method. It is called from the showMenu() method. It is
   * responsible for displaying the longest task to the user. It uses a JOptionPane to display the
   * task to the user. It uses a for loop to iterate through the array list and display the
   * information about the longest task using the overridden toString() method.
   */
  private void displayLongestTask() {
    TaskClass longestTask;
    longestTask = Tasks.get(0);

    for (TaskClass task : Tasks) {
      if (task.getDuration() > longestTask.getDuration()) {
        longestTask = task;
      }
    }
    JOptionPane.showMessageDialog(null, "Longest Task: " + Tasks.toString());
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the displayDoneTasks() method. It is called from the showMenu() method. It is
   * responsible for displaying all tasks that have been marked as done by the user. It calls the
   * displayTask() method to display each task. It uses a for loop to iterate through the array list
   */
  private void displayDoneTasks() {
    for (TaskClass task : Tasks) {
      if (task.getStatus().equals("Done")) {
        printTask(task);
      }
    }
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the printTask() method. It is used to display tasks to the user. It uses JOptionPane
   * to display the task and receives the task to display from the method calling it.
   */
  private void printTask(TaskClass task) {
    JOptionPane.showMessageDialog(null, task.toString()); // displays the task to the
                                                                         // user.
  }
  //----------------------------------------------------------------------------------------------//
  /*
   * This is the takeInput() method. It is used to get input from the user. It uses JOptionPane to
   * get the input from the user and returns the input to the method calling it. It receives the
   * prompt to display to the user from the method calling it.
   */
  private String takeInput(String promptIn) {
    return JOptionPane.showInputDialog(null, promptIn);
  }
  //----------------------------------------------------------------------------------------------//
}
//---------------------------------------END-OF-FILE----------------------------------------------//
