package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
/**
 * This class contains Java unit tests (JUnit tests). Methods with the annotation @Test
 * will be called when running the test with JUnit (unless there is some other indication
 * that the test should not be run, such as using the annotation @Disabled).
 */
public class ListTester {

  private static final Logger logger = Logger.getLogger(ListTester.class.getName());
 
  /**
   * A test method usually follows the naming pattern test___() where 
   * you may write as many "testSomething" methods in this class as you wish. Older
   * versions of JUnit testing required this format. Now, we use annotations like @Test
   * to indicate where there is a test and we can also specify lots of other things about
   * the tests using a wide variety of annotations (such as @DisplayName) to help us control
   * and understand the tests.
   */
  @DisplayName("Test adding something")
  @Test
  public void testAddMethod() {
    IntegerList list = new IntListArrayBased();

    // Information can be added to the log
    logger.info("The list looks like:" + list);

    // The following line of code checks the expectation that a the list
    // will contain one item. This test should instead actually try to add something 
    // to the list before checking that the length is one.
    // For example, try this: 
    // list.append(5);
    logger.info("The list looks like:" + list);
    assertEquals(1, list.length(), "Expected list length <1>, but was actually length <" + list.length() + ">");
    
  }
  
}
