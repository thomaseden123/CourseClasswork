/**
 * Prints out integer values for NumberOperations object.
 *
 * @author - Thomas Eden
 * @version - September 20, 2022
 */

public class NumberOperations {
   private int number;
   
  /**
   * NumberOperations class.
   * @param numberIn - number.
   */
   
   public NumberOperations(int numberIn) {
      number = numberIn;
   }
   
   /**
    * Takes no parameters; returns an int value.
    * @return number as int.
    */ 
   
   public int getValue() {
      return number;
   }
   
   /**
    * Takes no parameters; returns a String.
    * @return output as String.
    */
   
   public String oddsUnder() {
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }      
      return output;      
   }
   
   /**
    * Takes no parameters; returns a String.
    * @return output as String.
    */
   
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
      return output;   
   }
   
   /**
    * Takes an int parameter called compareNumber; returns an int.
    * @return output as int.
    * @param compareNumber - isGreater.
    */
   
   public int isGreater(int compareNumber) {
      int output = 0;
      if (number > compareNumber) {
         return 1;
      } else if (number < compareNumber) {
         return -1;
      } else {
         return 0;   
      }     
   }
   
   /**
    * Takes no parameters; returns a String.
    * @return number as String.
    */
   
   public String toString() {
      return number + "";
   }
   
      
           
   
}