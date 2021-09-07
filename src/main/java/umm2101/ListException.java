package umm2101;

public class ListException extends RuntimeException {
  /**
   * This UID was generated.
   * 
   * Why should you bother with serialVersionUID? 
   * Effective Java by Joshua Bloch
   * Quote from chapter 11 (as stated in a comment response on a stackoverflow page here): 
   * https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
   * "Regardless of what serialized form you choose, declare an explicit 
   * serial version UID in every serializable class you write. This eliminates the serial version 
   * UID as a potential source of incompatibility (Item 74). There is also a small performance 
   * benefit. If no serial version UID is provided, an expensive computation is required to 
   * generate one at runtime."
   */
  private static final long serialVersionUID = -9208111106002188073L;

  public ListException(String s){
    super(s);
  }
}