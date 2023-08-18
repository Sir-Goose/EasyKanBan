import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserClassTest {

  private InputValidationClass mockValidator;

  private UserClass user;

  @Before
  public void setUp() throws Exception {
    user = new UserClass();
    user.setUserName("User_1");
    user.setPassword("Password1");
    user.setFirstName("John");
    user.setLastName("Doe");
  }

  @Test
  public void testGetUserName() {
    assertEquals("User_1", user.getUserName());
  }

  @Test
  public void testGetPassword() {
    assertEquals("Password1", user.getPassword());
  }

  @Test
  public void testGetFirstName() {
    assertEquals("John", user.getFirstName());
  }

  @Test
  public void testGetLastName() {
    assertEquals("Doe", user.getLastName());
  }

  @Test
  public void testSetUserName() {
    user.setUserName("User_2");
    assertEquals("User_2", user.getUserName());
  }

  @Test
  public void testSetPassword() {
    user.setPassword("Password2");
    assertEquals("Password2", user.getPassword());
  }

  @Test
  public void testSetFirstName() {
    user.setFirstName("Jane");
    assertEquals("Jane", user.getFirstName());
  }

  @Test
  public void testSetLastName() {
    user.setLastName("Doe");
    assertEquals("Doe", user.getLastName());
  }
}
