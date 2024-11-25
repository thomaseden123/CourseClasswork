/**
 * InvalidCategoryException is a user defined exception created by 
 * extending the Exception class. This exception is to be thrown
 * and caught in the readItemFile method in the BakedItemList class
 * when a line of input data contains an invalid baked item category.
 *
 * @author - Thomas Eden
 * @version - November 18, 2022
 */

public class InvalidCategoryException extends Exception {
   /**
    * Takes a single String parameter representing
    * category and invokes the super constructor.
    * @param category initializes a line of invalid input data
    * in InvalidCategoryException when the exception occurs
    */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }

}