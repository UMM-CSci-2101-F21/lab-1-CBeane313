package umm2101;

import java.util.NoSuchElementException;

public class IntListArrayBased implements IntegerList {
  private static final int MAX_LIST = 50;
  private int items[];
  private int numItems;
  private int position;
  
  public IntListArrayBased(){
    items = new int[MAX_LIST];
    numItems = 0;
    position = 0;
  }

  @Override
  public void clear(){
    items = new int[MAX_LIST];
    numItems = 0;
  }
  
  @Override
  public boolean insert(int item) throws ListIndexOutOfBoundsException {
    if (numItems >= MAX_LIST) {
    // todo: part of step 5:
    // fix the code so that the message provides correct details about the problem
    throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on insert");

    } else {
      for (int i=numItems; i>position; i--) { // Shift elements up
        items[i] = items[i-1];                //   to make room                 
      }
      items[position] = item;
      numItems++;        // Increment list size
      return true;
    }
  }

  @Override
  public boolean append(int item){
    // This adds an item to the end of a list
    if (numItems >= MAX_LIST) {
      return false;
    }
    items[numItems] = item;
    numItems++;
    return true;
  }
  
  @Override
  public int remove() 
    throws ListIndexOutOfBoundsException {
    // todo: part of step 4: this method doesn't work yet - you need to write this code
    // What needs to happen when you remove something from an array-based list?
    
    // Someone might ask to remove an item from a location that does not exist
    // todo: part of step 5: be sure that the message for this exception 
    // provides correct details about the problem
    return 0;
  }

  @Override
  public void moveToStart() {
    position = 0;
    
  }

  @Override
  public void moveToEnd() {
    position = numItems;

  }

  @Override
  public void prev() {
    if (position != 0) {
      position = position - 1;
    }
    
  }

  @Override
  public void next() {
    if (position != numItems) {
      position++;
    }
  }

  @Override
  public int length(){
    return numItems;
  }

  @Override
  public int currPos() {
    return position;
  }

  @Override
  public boolean moveToPos(int pos) {
    if (pos > numItems || pos < 0) {
      return false;
    } else {
      position = pos;
      return true;
    }
  }

  @Override
  public boolean isAtEnd() {
    if (position == numItems) {
      return true;
    }
    return false;
  }

  @Override
  public int getValue() throws NoSuchElementException {
    if (position < numItems) {
      return items[position];
    } else {
      throw new NoSuchElementException("There isn't an element here");
    }
  }

  @Override
  public boolean isEmpty(){
    return (numItems == 0);
  }
  
  public String toString(){
    String s = "[";
    for (int i = 0; i<numItems; i++){
      s = s + items[i] + " ";
    }
    s += "]";
    return s;
  }
  
}
  
  





