package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains Java unit tests (JUnit tests). Methods with the annotation @Test
 * will be called when running the test with JUnit (unless there is some other indication
 * that the test should not be run, such as using the annotation @Disabled).
 */
public class LambertyListTester {

  private static final Logger logger = Logger.getLogger(ListTester.class.getName());
  
  // This field is declared here so that I can give it a value in setUp and refer to it in tests.
  // Note that I am only checking for behavior that is promised in the interface IntegerList
  IntegerList list;
  
  // Something with the annotation @BeforeEach is run before each of the provided test methods.
  // In this case, I am thankful for having @BeforeEach because the only place I declare that I am 
  // going to use an IntListArrayBased is here. This will allow me to use this same set of tests to 
  // test IntListLinked or whatever we call our linked list version of IntegerList (since I refer to 
  // the list just as 'list').
  @BeforeEach
  public void setUp() {
    list = new IntListArrayBased();
  }

  @Test
  public void testEmptyOnCreate() {
    // when you create a list, it should be empty
    assertTrue(list.isEmpty());
  }
  
  @Test
  public void testInsertMethod() {
    // Using System.out.println
    System.out.println("There should not be anything in the new list:" + list);

    // Using the logger
    logger.info("There should not be anything in the new list:" + list);

    // Check the assertion that the list has nothing
    assertEquals(0, list.length());
    // add 20 as the first item in the list (add to an empty list)
    list.insert(20);
    // verify that the list has exactly one item
    assertEquals(1, list.length());
    // Check the assertion that the item is, indeed, 20
    assertEquals(20, list.getValue());
    
    // add to the end of a non-empty list
    list.append(30);
    System.out.println("After adding 30 to the end, the list is now:" + list);

  }
  
  // todo: 6a1: add a test for insert that throws an exception because 
  // the list is already full
  
  // todo: 6a2: add a test for insert that throws an exception because 
  // the location is not a possible location since the list only has some smaller number of items
   
  // todo: 6a3: add some other test for insert that checks something else
  
  
  @Test
  public void testGet() {  
    list.insert(20);
    // verify that the list has exactly one item
    assertEquals(1, list.length());
    // Check the assertion that the item is, indeed, 20
    assertEquals(20, list.getValue());
  }
  
  // todo: 6b1: write a test to get something that is not the first item in the list
  
  // todo: 6b2: write a test to trigger an exception because 
  // you are asking for an item with a location that is too large of a number given the number of items

  
  @Test
  public void testRemove() {
    // add one item
    list.insert(20);
    
    // size is one, remove the first item, size is now zero
    assertEquals(1, list.length());
    list.remove();
    assertEquals(0, list.length());

    // add 50 things to the list
    for (int i = 1; i<=50; i++) {
      list.insert(i);
    }
    System.out.println(list);
    assertEquals(50, list.length());

    for (int i = 0; i < 10; i++) {
      list.next();
    }
    System.out.println("" + list.currPos());
    // removing the 10th item should remove 41
    assertEquals(41, list.getValue());
    list.remove();
    assertEquals(40, list.getValue());
    assertEquals(49, list.length());
    System.out.println(list);
    
    // add a 50th item in position 50
    list.moveToPos(50);
    list.insert(66);
    assertEquals(66, list.getValue());
  }

  // todo: 6c1: write a test that triggers the exception
  // because the location is too large of a number compared to the number of items in the list
 
  // todo: 6c2: write a test that removes something that is not the last item in the list
  
  // todo: 6c3: write some other test of remove
  
  // todo: 6d: write a test for removing all the items (clear)
  
}
