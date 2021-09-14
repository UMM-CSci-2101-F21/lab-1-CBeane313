package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains Java unit tests (JUnit tests). Methods with the annotation @Test
 * will be called when running the test with JUnit (unless there is some other indication
 * that the test should not be run, such as using the annotation @Disabled).
 */

public class BeaneListTester {

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
    
    
    @Test
    public void testInterstThrowExceptionFullList(){
    // todo: 6a1: add a test for insert that throws an exception because 
    // the list is already full
    for (int i = 1; i<=50; i++)
        {
            list.insert(i);
        }
    try{
        list.insert(12);
        //fail("Expected an ListIndexOutOfBoundsException to be thrown"); //fail is not defined in this class
    }
    catch(ListIndexOutOfBoundsException tes){
        System.out.println(tes.getMessage());
        assertEquals("List exception on insert - too much stuff!"+
    " Could not insert item: <" + 12 + "> because the list was already full.", tes.getMessage());
    }
    } 

    @Test
    public void testInsert(){
    // todo: 6a3: add some other test for insert that checks something else
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    System.out.println(list);
    System.out.println(list.currPos());
    for(int i = 1; i<=5;i++)
    {
        list.next();
    }
    System.out.println(list.currPos());
    list.insert(99);
    System.out.println(list);
    assertEquals(99, list.getValue());
    }

    @Test
    public void testAppend(){
    // todo: 6a2: One of which appends an item to the end of the list and checks that it worked(taken from instruction doc, different than provided code);;;;;;;;
                                // add a test for insert that throws an exception because 
                                // the location is not a possible location since the list only has some smaller number of items
    for (int i = 1; i<=20; i++)
    {
        list.insert(i);
    }
    list.append(0);
    list.moveToEnd();
    System.out.println(list);
    assertEquals(21, list.length());
    assertEquals(0,list.getValue());
    }

    @Test
    public void testGet() {  
      list.insert(20);
      // verify that the list has exactly one item
      assertEquals(1, list.length());
      // Check the assertion that the item is, indeed, 20
      assertEquals(20, list.getValue());
    }
    
    @Test
    public void testGetNotFirst(){
    // todo: 6b1: write a test to get something that is not the first item in the list
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 3;i++)
    {
        list.next();
    }
    assertEquals(4, list.getValue());
    }

    @Test
    public void testGetOutOfRange(){
    // todo: 6b2: write a test to trigger an exception because 
    // you are asking for an item with a location that is too large of a number given the number of items
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 33;i++)
    {
        list.next();
    }
    try{
        list.getValue();
    }
    catch(NoSuchElementException tes){
        System.out.println(tes.getMessage());
        assertEquals("There isn't an element here", tes.getMessage());
    }
    }
    
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
      System.out.println("Current Pos " + list.currPos());
      // removing the 10th item should remove 40
      assertEquals(40, list.getValue());
      System.out.println(list.remove());
      //assertEquals(40, list.remove());
      System.out.println(list);
      System.out.println("Current Pos " + list.currPos());
      assertEquals(39, list.getValue());
      assertEquals(49, list.length());
      System.out.println(list);
      
      // add a 50th item in position 50
      list.moveToPos(50);
      list.insert(66);
      assertEquals(66, list.getValue());
    }
  
    @Test
    public void testRemoveException(){
    // todo: 6c1: write a test that triggers the exception
    // because the location is too large of a number compared to the number of items in the list
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 25;i++)
    {
        list.next();
    }
    try{
        list.remove();
    }
    catch(ListIndexOutOfBoundsException tes){
        System.out.println(tes.getMessage());
        assertEquals("List exception on remove- position idex out" +
        " of range of List- current pos <" + 20 + "> and length of list <" + 20 + ">", tes.getMessage()); //current position is only 20 because the next method does
                                                                                                          //not alow it to go further but still throws exception due
                                                                                                          //to 0 based index
    }
    }
    
   @Test
   public void testRemoveNotLast(){
   // todo: 6c2: write a test that removes something that is not the last item in the list
   for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 13;i++)
    {
        list.next();
    }
    System.out.println(list);
    assertEquals(14, list.remove()); //should remove the #14 from the list
    System.out.println(list);
   }
    
   @Test
   public void testRemoveAnotherTest(){
   // todo: 6c3: write some other test of remove
   // tests that the list properly shifted 
   for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 13;i++)
    {
        list.next();
    }
   System.out.println(list);
   list.remove();
   assertEquals(15, list.getValue());
   }
    
   @Test
   public void testRemoveAllItems(){
   // todo: 6d: write a test for removing all the items (clear)
   for (int i = 1; i<=20; i++)
    {
        list.append(i);
    } 
   list.clear();
   assertTrue(list.isEmpty());
   }
    
        
}
