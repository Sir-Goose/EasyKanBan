import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TaskClassTest {
  TaskClass task;

  @BeforeEach
  void setUp() {
    task = new TaskClass();
  }

  @Test
  void getName() {
    task.setName("TestTask");
    assertEquals("TestTask", task.getName());
  }

  @Test
  void getDeveloperFirstName() {
    task.setDeveloperFirstName("John");
    assertEquals("John", task.getDeveloperFirstName());
  }

  @Test
  void getDeveloperLastName() {
    task.setDeveloperLastName("Doe");
    assertEquals("Doe", task.getDeveloperLastName());
  }

  @Test
  void getNumber() {
    task.setNumber(1);
    assertEquals(1, task.getNumber());
  }

  @Test
  void getDuration() {
    task.setDuration(2);
    assertEquals(2, task.getDuration());
  }

  @Test
  void getStatus() {
    task.setStatus("Done");
    assertEquals("Done", task.getStatus());
  }

  @Test
  void getID() {
    task.setID("ID01");
    assertEquals("ID01", task.getID());
  }

  @Test
  void getDescription() {
    task.setDescription("Test Description");
    assertEquals("Test Description", task.getDescription());
  }

  @Test
  void getDeveloper() {
    task.setDeveloperFirstName("John");
    task.setDeveloperLastName("Doe");
    assertEquals("John Doe", task.getDeveloper());
  }

  @Test
  void toStringTest() {
    task.setName("TestTask");
    task.setDeveloperFirstName("John");
    task.setDeveloperLastName("Doe");
    task.setNumber(1);
    task.setDuration(2);
    task.setStatus("Done");
    task.setID("ID01");
    task.setDescription("Test Description");

    String expected = "Task Name: TestTask\n" +
        "Developer: John Doe\n" +
        "Task Number: 1\n" +
        "Duration: 2\n" +
        "Status: Done\n" +
        "ID: ID01\n" +
        "Description: Test Description\n";

    assertEquals(expected, task.toString());
  }
}
